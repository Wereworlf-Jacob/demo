package com.example.demo.design.pattern.decorator.beverages;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CupSize;

/**
 * 低咖啡因咖啡
 * @auth Jacob
 * @date 2020/8/3 12:00
 */
public class Decaf extends Beverage {

    public Decaf(CupSize cupSize) {
        this.setDecscription("Decaf");
        this.setSize(cupSize);
    }

    @Override
    public double cost() {
        return 1.05;
    }

}
