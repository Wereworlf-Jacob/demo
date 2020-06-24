package com.example.demo.design.pattern.strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.FlyBehavior;

/**
 * @ClassName FlyWithSwings
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:38
 **/
public class FlyWithSwings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with swings!");
    }
}
