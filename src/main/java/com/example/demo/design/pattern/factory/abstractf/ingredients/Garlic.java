package com.example.demo.design.pattern.factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:26
 */
public class Garlic implements Veggies {
    public Garlic() {
        create();
    }

    @Override
    public void create() {
        System.out.println("add garlic 大蒜");
    }
}
