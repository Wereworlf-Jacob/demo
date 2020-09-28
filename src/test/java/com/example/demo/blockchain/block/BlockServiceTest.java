package com.example.demo.blockchain.block;

import com.alibaba.fastjson.JSON;
import com.example.demo.blockchain.model.*;
import com.example.demo.blockchain.security.CryptoUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auth Jacob
 * @date 2020/9/14 15:54
 */
public class BlockServiceTest {

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("set up something...");
    }

    @Test
    public void testBlockMine() throws Exception {
        //创建要给空的区块链
        List<Block> blockChain = new ArrayList<>();
        /**
         * 生成新的区块，在区块链中，会有一个默认的区块，叫做创世区块
         * 创世区块的值是写死的
         */
        Block creationBlock = new Block(1, System.currentTimeMillis(),
                new ArrayList<>(), 1, "1", "1");
        //加入创世区块到区块链里
        blockChain.add(creationBlock);
        System.out.println(JSON.toJSONString(blockChain));

        //创建一个空的交易集合
        List<Transaction> txs = new ArrayList<>();
        //TODO 创建3笔交易 tx1，tx2，tx3
        Transaction tx1 = new Transaction();
        Transaction tx2 = new Transaction();
        txs.add(tx1);
        txs.add(tx2);

        //交易发起方
        Wallet walletSender = Wallet.generateWallet();
        Wallet walletReciptent = Wallet.generateWallet();

        TransactionInput txIn = new TransactionInput(tx2.getId(),
                10, null, walletSender.getPublicKey());
        TransactionOutput txOut = new TransactionOutput(10, walletReciptent.getHashPubKey());
        Transaction tx3 = new Transaction(CryptoUtil.UUID(), txIn, txOut);

        //绑定tx2之前已经被打包进区块，也就是已经被记录近账本了
        tx3.sign(walletSender.getPrivateKey(), tx2);
        txs.add(tx3);


        //加入系统奖励的交易
        Transaction sysTx = new Transaction();
        txs.add(sysTx);
        //获取当前区块链里的最后一个区块
        Block lastBlock = blockChain.get(blockChain.size() - 1);
        //Hash = SHA256(最后一个区块的hash + 交易记录信息 + 随机数)
        int nonce = 1;
        String hash = "";
        while (true) {
            hash = CryptoUtil.SHA256(lastBlock.getHash() + JSON.toJSONString(txs) + nonce);
            if (hash.startsWith("0000")){
                System.out.println("======计算结果正确，计算次数为：" + nonce + ",hash:" + hash);
                break;
            }
            nonce++;
            System.out.println("-----计算错误，hash：" + hash);
        }
        //挖到矿之后，要创建一个新的区块
        Block newBlock = new Block(lastBlock.getIndex() + 1,
                System.currentTimeMillis(), txs, nonce, lastBlock.getHash(), hash);
        blockChain.add(newBlock);
        System.out.println("挖矿后的区块链：" + JSON.toJSONString(blockChain));
    }

    @Test
    public void testWallet() {
        Wallet wallet = Wallet.generateWallet();
        System.out.println(JSON.toJSONString(wallet));
    }

    @Test
    public void testA() {
        long time = 1520429408609l;
        Date date = new Date(time);
        System.out.println(date);
    }

}
