package com.example.demo.blockchain.model;

import com.example.demo.blockchain.security.CryptoUtil;
import com.example.demo.blockchain.security.RSACoder;

import java.util.Map;

/**
 * 钱包
 * @auth Jacob
 * @date 2020/9/14 17:28
 */
public class Wallet {

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Wallet() {
    }

    public Wallet(String publicKey) {
        this.publicKey = publicKey;
    }

    public Wallet(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public static Wallet generateWallet() {
        Map<String, Object> initKey;
        try {
            //本地生成公私钥对儿
            initKey = RSACoder.initKey();
            String publicKey = RSACoder.getPublicKey(initKey);
            String privateKey = RSACoder.getPrivateKey(initKey);
            return new Wallet(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取钱包地址
     * @author Jacob
     * @date 2020/9/16 16:15
     * @return java.lang.String
     */
    public String getAddress() {
        String publicKeyHash = hashPubKey(publicKey);
        return CryptoUtil.MD5(publicKeyHash);
    }

    public static String getAddress(String publicKey){
        String publicKeyHash = hashPubKey(publicKey);
        return CryptoUtil.MD5(publicKeyHash);
    }

    public String getHashPubKey() {
        return CryptoUtil.SHA256(publicKey);
    }

    public static String hashPubKey(String publicKey) {
        return CryptoUtil.SHA256(publicKey);
    }
}
