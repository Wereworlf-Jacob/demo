package com.example.demo.design.pattern.decorator.beverages;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CupSize;

import java.math.BigDecimal;

/**
 * 浓缩咖啡
 * @auth Jacob
 * @date 2020/8/3 11:44
 */
public class Espresso extends Beverage {

    public Espresso(CupSize size) {
        this.setDecscription("Espresso");
        this.setSize(size);
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
