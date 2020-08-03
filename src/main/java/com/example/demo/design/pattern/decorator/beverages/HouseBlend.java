package com.example.demo.design.pattern.decorator.beverages;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CupSize;

import java.math.BigDecimal;

/**
 * 综合咖啡
 * @auth Jacob
 * @date 2020/8/3 11:46
 */
public class HouseBlend extends Beverage {

    public HouseBlend(CupSize cupSize) {
        this.setDecscription("House Blend Coffee");
        this.setSize(cupSize);
    }

    @Override
    public double cost() {
        return .89;
    }
}
