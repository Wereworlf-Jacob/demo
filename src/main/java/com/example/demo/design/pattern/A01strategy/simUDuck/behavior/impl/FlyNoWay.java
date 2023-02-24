package com.example.demo.design.pattern.A01strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.A01strategy.simUDuck.behavior.FlyBehavior;

/**
 * @ClassName FlyNoWay
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:39
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
