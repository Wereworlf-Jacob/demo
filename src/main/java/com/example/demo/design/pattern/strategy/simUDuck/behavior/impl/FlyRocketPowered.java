package com.example.demo.design.pattern.strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.FlyBehavior;

/**
 * @ClassName FlyRocketPowered
 * @Description 拥有火箭动力的飞翔模式
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:59
 **/
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我装上了火箭飞行器，可以飞了哦");
    }
}
