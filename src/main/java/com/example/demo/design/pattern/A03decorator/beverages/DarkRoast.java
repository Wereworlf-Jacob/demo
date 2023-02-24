package com.example.demo.design.pattern.A03decorator.beverages;

import com.example.demo.design.pattern.A03decorator.Beverage;
import com.example.demo.design.pattern.A03decorator.CupSize;

/**
 * 深焙咖啡
 * @auth Jacob
 * @date 2020/8/3 11:57
 */
public class DarkRoast extends Beverage {

    public DarkRoast(CupSize size) {
        this.setDecscription("Dark Roast Coffee");
        this.setSize(size);
    }

    @Override
    public double cost() {
        return .99;
    }
}
