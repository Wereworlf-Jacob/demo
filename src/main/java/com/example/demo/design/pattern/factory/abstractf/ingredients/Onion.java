package com.example.demo.design.pattern.factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:27
 */
public class Onion implements Veggies {
    public Onion() {
        create();
    }

    @Override
    public void create() {
        System.out.println("add onion 洋葱");
    }
}
