package com.example.demo.design.pattern.decorator.condiments;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CondimentDecorator;
import com.example.demo.design.pattern.decorator.CupSize;

/**
 * 豆浆调味品
 * @auth Jacob
 * @date 2020/8/3 13:41
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDecscription() {
        return beverage.getDecscription() + ", soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        //大小不同的杯子豆奶价格不一样
        if (CupSize.TALL.equals(beverage.getSize())) {
            cost += 0.10;
        } else if (CupSize.GRANDE.equals(beverage.getSize())) {
            cost += 0.15;
        } else if (CupSize.VENTI.equals(beverage.getSize())) {
            cost += 0.20;
        }
        return cost;
    }
}
