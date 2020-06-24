package com.example.demo.design.pattern.strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.QuackBehavior;

/**
 * @ClassName MuteQuack
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:42
 **/
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫~~, 哑的 , mute, mute, mute");
    }
}
