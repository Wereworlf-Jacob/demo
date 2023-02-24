package com.example.demo.design.pattern.A03decorator;

/**
 * 这是一个饮料抽象方法
 * @auth Jacob
 * @date 2020/8/3 10:47
 */
public abstract class Beverage {

    //饮料都有自己的描述，默认是不知道这是什么饮料的描述
    private String decscription = "unknown beverage description!";

    //饮料有大杯，小杯，中杯的区分
    private CupSize size;

    public String getDecscription() {
        return decscription;
    }

    public void setDecscription(String decscription) {
        this.decscription = decscription;
    }

    public CupSize getSize() {
        return size;
    }

    public void setSize(CupSize size) {
        this.size = size;
    }

    //饮料都有自己的计算费用的方式。
    public abstract double cost();

    @Override
    public String toString() {
        return getDecscription() + " $" + cost();
    }
}
