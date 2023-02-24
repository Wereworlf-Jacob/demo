package com.example.demo.design.pattern.A04factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:32
 */
public class FreshClams implements Clams {
    public FreshClams() {
        create();
    }

    @Override
    public void create() {
        System.out.println("fresh clams 新鲜的蛤蜊");
    }
}
