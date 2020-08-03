package com.example.demo.design.pattern.decorator.condiments;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CondimentDecorator;

/**
 * 牛奶调味品
 * @auth Jacob
 * @date 2020/8/3 13:40
 */
public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDecscription() {
        return beverage.getDecscription() + ", milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
