package com.example.demo.design.pattern.A01strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.A01strategy.simUDuck.behavior.QuackBehavior;

/**
 * @ClassName Quack
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:40
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱呱叫, quack, quack, quack");
    }
}
