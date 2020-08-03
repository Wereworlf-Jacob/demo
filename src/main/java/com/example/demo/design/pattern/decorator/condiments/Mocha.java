package com.example.demo.design.pattern.decorator.condiments;

import com.example.demo.design.pattern.decorator.Beverage;
import com.example.demo.design.pattern.decorator.CondimentDecorator;

/**
 * 摩卡调味品
 * @auth Jacob
 * @date 2020/8/3 11:51
 */
public class Mocha extends CondimentDecorator {

    //调味品要持有一个饮料，饮料才是主体，调味品是附加项
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDecscription() { //重新定义饮料的描述
        return beverage.getDecscription() + ", Mocha";
    }

    @Override
    public double cost() { //饮料的价格加上调味品的价格
        return .20 + beverage.cost();
    }
}
