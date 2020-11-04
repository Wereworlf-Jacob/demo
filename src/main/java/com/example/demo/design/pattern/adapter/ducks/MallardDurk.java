package com.example.demo.design.pattern.adapter.ducks;

/**
 * 这是一个绿头鸭
 * @auth Jacob
 * @date 2020/11/4 10:04
 */
public class MallardDurk implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
