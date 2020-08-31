package com.example.demo.design.pattern.factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:28
 */
public class RedPepper implements Veggies {
    public RedPepper() {
        create();
    }

    @Override
    public void create() {
        System.out.println("add red pepper 红辣椒");
    }
}
