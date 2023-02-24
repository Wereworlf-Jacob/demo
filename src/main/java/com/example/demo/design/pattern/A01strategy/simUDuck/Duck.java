package com.example.demo.design.pattern.A01strategy.simUDuck;

import com.example.demo.design.pattern.A01strategy.simUDuck.behavior.QuackBehavior;
import com.example.demo.design.pattern.A01strategy.simUDuck.behavior.FlyBehavior;

/**
 * @ClassName Duck
 * @Description 首先我有一个鸭子超类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:03
 **/
public abstract class Duck {

    //具有飞行行为
    private FlyBehavior flyBehavior;

    //具有呱呱叫行为
    private QuackBehavior quackBehavior;

    public void swim(){
        System.out.println("I'm swimming!");
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
