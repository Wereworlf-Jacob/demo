package com.example.demo.design.pattern.strategy.simUDuck;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.FlyNoWay;
import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.Squeak;

/**
 * @ClassName RubberDuck
 * @Description 橡皮鸭
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:47
 **/
public class RubberDuck extends Duck {

    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("这是一只橡皮鸭");
    }
}
