package com.example.demo.design.pattern.strategy.simUDuck;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.FlyNoWay;
import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.MuteQuack;

/**
 * @ClassName ModelDuck
 * @Description 模型鸭子
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:49
 **/
public class ModelDuck extends Duck {

    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("这是一只模型鸭");
    }
}
