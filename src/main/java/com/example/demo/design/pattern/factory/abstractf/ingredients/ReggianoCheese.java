package com.example.demo.design.pattern.factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:25
 */
public class ReggianoCheese implements Cheese {
    public ReggianoCheese() {
        create();
    }

    @Override
    public void create() {
        System.out.println("New york style cheese!");
    }
}
