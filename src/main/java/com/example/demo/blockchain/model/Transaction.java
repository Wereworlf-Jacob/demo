package com.example.demo.blockchain.model;

import com.alibaba.fastjson.JSON;
import com.example.demo.blockchain.security.CryptoUtil;
import com.example.demo.blockchain.security.RSACoder;

/**
 * 交易记录结构
 * @auth Jacob
 * @date 2020/9/14 16:37
 */
public class Transaction {

    /**
     * 交易唯一标识
     */
    private String id;
    /**
     * 交易输入
     */
    private TransactionInput txIn;
    /**
     * 交易输出
     */
    private TransactionOutput txOut;

    public Transaction() {
        super();
    }

    public Transaction(String id, TransactionInput txIn, TransactionOutput txOut) {
        this.id = id;
        this.txIn = txIn;
        this.txOut = txOut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionInput getTxIn() {
        return txIn;
    }

    public void setTxIn(TransactionInput txIn) {
        this.txIn = txIn;
    }

    public TransactionOutput getTxOut() {
        return txOut;
    }

    public void setTxOut(TransactionOutput txOut) {
        this.txOut = txOut;
    }
    /**
     * 是否系统生成区块的奖励交易
     * @author Jacob
     * @date 2020/9/17 11:45
     * @return boolean
     */
    public boolean coinbaseTx() {
        return txIn.getTxId().equals("0") && getTxIn().getValue() == -1;
    }
    /**
     * 用私钥生成交易签名
     * @param privateKey
     * @param prevTx
     * @author Jacob
     * @date 2020/9/17 11:43
     * @return void
     */
    public void sign(String privateKey, Transaction prevTx) {
        //判断是否是系统的coinbase交易
        if(coinbaseTx()){
            return;
        }
        if (!prevTx.getId().equals(getTxIn().getTxId())){
            System.err.println("交易签名失败，当前交易输入引用的前一笔交易于传入的前一笔交易不匹配");
        }
        Transaction txClone = cloneTx();
        txClone.getTxIn().setPublicKey(prevTx.getTxOut().getPublicKeyHash());
        String sign = "";
        try {
            sign = RSACoder.sign(txClone.hash().getBytes(), privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txIn.setSignature(sign);
    }
    /**
     * 生成用于交易签名的交易记录副本
     * @author Jacob
     * @date 2020/9/17 14:11
     * @return com.example.demo.blockchain.model.Transaction
     */
    public Transaction cloneTx() {
        TransactionInput input = new TransactionInput(txIn.getTxId(), txIn.getValue(), null, null);
        TransactionOutput out = new TransactionOutput(txOut.getValue(), txOut.getPublicKeyHash());
        return new Transaction(id, input, out);
    }
    /**
     * 生成交易的hash
     * @author Jacob
     * @date 2020/9/17 14:15
     * @return java.lang.String
     */
    public String hash() {
        return CryptoUtil.SHA256(JSON.toJSONString(this));
    }
    public boolean verify(Transaction prevTx) {
        if (coinbaseTx()) {
            return true;
        }
        if (!prevTx.getId().equals(txIn.getTxId())) {
            System.err.println("验证交易签名失败：当前交易输入引用的前一笔交易于输入的前一笔交易不匹配");
        }
        Transaction txClone = cloneTx();
        txClone.getTxIn().setPublicKey(prevTx.getTxOut().getPublicKeyHash());

        boolean result = false;
        try {
            result = RSACoder.verify(txClone.hash().getBytes(), txIn.getPublicKey(), txIn.getSignature());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return false;
    }
}
