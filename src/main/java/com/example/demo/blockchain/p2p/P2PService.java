package com.example.demo.blockchain.p2p;

import com.alibaba.fastjson.JSON;
import com.example.demo.blockchain.block.BlockService;
import com.example.demo.blockchain.model.Block;
import com.example.demo.blockchain.model.Transaction;
import com.example.demo.blockchain.model.Wallet;
import org.java_websocket.WebSocket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @auth Jacob
 * @date 2020/9/17 15:54
 */
public class P2PService {

    private List<WebSocket> sockets;
    private BlockService blockService;

    //查询最新的区块
    public final static int QUERY_LATEST_BLOCK = 0;
    //查询整个区块链
    public final static int QUERY_BLOCKCHAIN = 1;
    //查询交易集合
    public final static int QUERY_TRANSACTION = 2;
    //查询已打包交易集合
    public final static int QUERY_PACKED_TRANSACTION = 3;
    //查询钱包集合
    public final static int QUERY_WALLET = 4;
    //返回区块集合
    public final static int RESPONSE_BLOCKCHAIN = 5;
    // 返回交易集合
    public final static int RESPONSE_TRANSACTION = 6;
    //返回已打包交易集合
    public final static int RESPONSE_PACKED_TRANSACTION = 7;
    // 返回钱包集合
    public final static int RESPONSE_WALLET = 8;

    public P2PService(BlockService blockService) {
        this.blockService = blockService;
        this.sockets = new ArrayList<>();
    }

    public List<WebSocket> getSockets() {
        return sockets;
    }
    public void handleMessage(WebSocket webSocket, String msg, List<WebSocket> sockets) {
        try {
            Message message = JSON.parseObject(msg, Message.class);
            System.out.println("接收到" + webSocket.getRemoteSocketAddress().getPort()
                    + "的p2p消息" + JSON.toJSONString(message));
            switch (message.getType()) {
                case QUERY_LATEST_BLOCK:
                    write(webSocket, responseLatestBlockMsg());
                    break;
                case QUERY_BLOCKCHAIN:
                    write(webSocket, responseBlockChainMsg());
                    break;
                case QUERY_TRANSACTION:
                    write(webSocket, responseTransactions());
                    break;
                case QUERY_PACKED_TRANSACTION:
                    write(webSocket, responsePackedTransactions());
                    break;
                case QUERY_WALLET:
                    write(webSocket, responseWallets());
                    break;
                case RESPONSE_BLOCKCHAIN:
                    handleBlockChainResponse(message.getData(), sockets);
                    break;
                case RESPONSE_TRANSACTION:
                    handleTransactionResponse(message.getData());
                    break;
                case RESPONSE_PACKED_TRANSACTION:
                    handlePackedTransactionResponse(message.getData());
                    break;
                case RESPONSE_WALLET:
                    handleWalletResponse(message.getData());
                    break;
            }
        } catch (Exception e) {
            System.err.println("处理p2p消息错误:" + e.getMessage());
        }
    }
    public synchronized void handleBlockChainResponse(String message, List<WebSocket> sockets) {
        List<Block> receiveBLockChain = JSON.parseArray(message, Block.class);
        Collections.sort(receiveBLockChain, Comparator.comparingInt(Block::getIndex));
        Block latestBlockReceived = receiveBLockChain.get(receiveBLockChain.size() - 1);
        Block latestBlock = blockService.getLatestBlock();
        if (latestBlockReceived.getIndex() > latestBlock.getIndex()) {
            if (latestBlock.getHash().equals(latestBlockReceived.getPreviousHash())) {
                System.out.println("将接收到的区块加入到本地的区块链");
                if (blockService.addBlock(latestBlockReceived)) {
                    broadcast(responseLatestBlockMsg());
                }
            } else if (receiveBLockChain.size() == 1) {
                System.out.println("查询所有通讯节点上的区块链");
                broadcast(queryBlockChainMsg());
            } else {
                //用长链替换本地短链
                blockService.replaceChain(receiveBLockChain);
            }
        } else {
            System.out.println("接收到的区块链不比本地区块链长，不处理");
        }
    }
    public void handleWalletResponse(String message) {
        List<Wallet> wallets = JSON.parseArray(message, Wallet.class);
        wallets.forEach(wallet -> {
            blockService.getOtherWalletMap().put(wallet.getAddress(), wallet);
        });
    }
    public void handleTransactionResponse(String message) {
        List<Transaction> txs = JSON.parseArray(message, Transaction.class);
        blockService.getAllTransactions().addAll(txs);
    }
    public void handlePackedTransactionResponse(String message) {
        List<Transaction> txs = JSON.parseArray(message, Transaction.class);
        blockService.getPackedTransactions().addAll(txs);
    }

    public void write(WebSocket ws, String message) {
        System.out.println("发送给" + ws.getRemoteSocketAddress() + "的p2p消息:" + message);
        ws.send(message);
    }

    public void broadcast(String message) {
        if (sockets.size() == 0) {
            return;
        }
        System.out.println("=====广播消息开始");
        for (WebSocket socket : sockets) {
            this.write(socket, message);
        }
        System.out.println("=======广播消息结束");
    }
    public String queryBlockChainMsg() {
        return JSON.toJSONString(new Message(QUERY_BLOCKCHAIN));
    }
    public String queryLatestBlockMsg() {
        return JSON.toJSONString(new Message(QUERY_LATEST_BLOCK));
    }
    public String queryTransactionMsg() {
        return JSON.toJSONString(new Message(QUERY_TRANSACTION));
    }
    public String queryPackedTransactionMsg() {
        return JSON.toJSONString(new Message(QUERY_PACKED_TRANSACTION));
    }
    public String queryWalletMsg() {
        return JSON.toJSONString(new Message(QUERY_WALLET));
    }
    public String responseBlockChainMsg() {
        return JSON.toJSONString(new Message (RESPONSE_BLOCKCHAIN, JSON.toJSONString(blockService.getBlockChain())));
    }
    public String responseLatestBlockMsg() {
        Block[] blocks = { blockService.getLatestBlock() };
        return JSON.toJSONString(new Message(RESPONSE_BLOCKCHAIN, JSON.toJSONString(blocks)));
    }
    public String responseTransactions() {
        return JSON.toJSONString(new Message(RESPONSE_TRANSACTION, JSON.toJSONString(blockService.getAllTransactions())));
    }
    public String responsePackedTransactions() {
        return JSON.toJSONString(new Message(RESPONSE_PACKED_TRANSACTION, JSON.toJSONString(blockService.getPackedTransactions())));
    }
    public String responseWallets() {
        List<Wallet> wallets = new ArrayList<>();
        blockService.getMyWalletMap().forEach((address, wallet) -> {
            wallets.add(new Wallet(wallet.getPublicKey()));
        });
        blockService.getOtherWalletMap().forEach((address, wallet) -> {
            wallets.add(wallet);
        });
        return JSON.toJSONString(new Message(RESPONSE_WALLET, JSON.toJSONString(wallets)));
    }

}
