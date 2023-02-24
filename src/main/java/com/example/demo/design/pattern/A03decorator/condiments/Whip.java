package com.example.demo.design.pattern.A03decorator.condiments;

import com.example.demo.design.pattern.A03decorator.Beverage;
import com.example.demo.design.pattern.A03decorator.CondimentDecorator;

/**
 * 奶泡调味品
 * @auth Jacob
 * @date 2020/8/3 13:39
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDecscription() {
        return beverage.getDecscription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
