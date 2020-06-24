package com.example.demo.design.pattern.strategy.simUDuck;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.FlyWithSwings;
import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.Quack;

/**
 * @ClassName MallardDuck
 * @Description 绿头鸭
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:45
 **/
public class MallardDuck extends Duck {

    public MallardDuck() {
        setFlyBehavior(new FlyWithSwings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("这是一只绿头鸭");
    }

}
