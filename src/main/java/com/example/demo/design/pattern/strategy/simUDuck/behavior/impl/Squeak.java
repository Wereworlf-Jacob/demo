package com.example.demo.design.pattern.strategy.simUDuck.behavior.impl;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.QuackBehavior;

/**
 * @ClassName Squeak
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:41
 **/
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫, squeak, squeak, squeak");
    }
}
