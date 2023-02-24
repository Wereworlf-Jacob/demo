package com.example.demo.design.pattern.A04factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:28
 */
public class Mushroom implements Veggies {
    public Mushroom() {
        create();
    }

    @Override
    public void create() {
        System.out.println("add mushroom 蘑菇");
    }
}
