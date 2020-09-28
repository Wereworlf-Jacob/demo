package com.example.demo.blockchain.model;

/**
 * 交易输出的结构
 * @auth Jacob
 * @date 2020/9/17 10:52
 */
public class TransactionOutput {
    /**
     * 交易金额
     */
    private int value;
    /**
     * 交易接收方的钱包公钥的hash值
     */
    private String publicKeyHash;

    public TransactionOutput() {
        super();
    }

    public TransactionOutput(int value, String publicKeyHash) {
        this.value = value;
        this.publicKeyHash = publicKeyHash;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPublicKeyHash() {
        return publicKeyHash;
    }

    public void setPublicKeyHash(String publicKeyHash) {
        this.publicKeyHash = publicKeyHash;
    }
}
