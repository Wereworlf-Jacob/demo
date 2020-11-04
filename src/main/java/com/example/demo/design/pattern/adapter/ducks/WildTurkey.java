package com.example.demo.design.pattern.adapter.ducks;

/**
 * 野火鸡
 * @auth Jacob
 * @date 2020/11/4 10:05
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble Gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
