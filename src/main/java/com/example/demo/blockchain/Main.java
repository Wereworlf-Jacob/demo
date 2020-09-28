package com.example.demo.blockchain;

import com.example.demo.blockchain.block.BlockService;
import com.example.demo.blockchain.http.HTTPService;
import com.example.demo.blockchain.p2p.P2PClient;
import com.example.demo.blockchain.p2p.P2PServer;
import com.example.demo.blockchain.p2p.P2PService;

/**
 * @auth Jacob
 * @date 2020/9/14 15:54
 */
public class Main {

    public static void main(String[] args) {
        if (args != null && (args.length == 1 || args.length == 2 || args.length == 3)) {
            try {
                BlockService blockService = new BlockService();
                P2PService p2pService = new P2PService(blockService);
                startP2PServer(args, p2pService);
                HTTPService httpService = new HTTPService(blockService, p2pService);
                int httpPort = Integer.valueOf(args[0]);
                httpService.initHTTPServer(httpPort);
            } catch (Exception e) {
                System.err.println("startup is error:" + e.getMessage());
            }
        } else {
            System.out.println("usage: java -jar blockchain.jar 8081 7001");
        }
    }

    private static void startP2PServer(String[] args, P2PService p2pService) {
        P2PServer p2pServer = new P2PServer(p2pService);
        P2PClient p2pClient = new P2PClient(p2pService);
        int p2pPort = Integer.valueOf(args[1]);
        //启动p2p服务端
        p2pServer.initP2PServer(p2pPort);
        if (args.length == 3 && args[2] != null) {
            //作为p2p客户端连接p2p服务端
            p2pClient.connectToPeer(args[2]);
        }
    }

}
