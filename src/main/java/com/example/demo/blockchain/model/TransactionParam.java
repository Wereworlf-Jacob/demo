package com.example.demo.blockchain.model;

/**
 * @auth Jacob
 * @date 2020/9/17 10:57
 */
public class TransactionParam {

    /**
     * 发送方钱包地址
     */
    private String sender;
    /**
     * 接收方钱包地址
     */
    private String recipient;
    /**
     * 发送金额
     */
    private int Amount;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
