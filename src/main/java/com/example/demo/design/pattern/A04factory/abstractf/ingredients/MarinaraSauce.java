package com.example.demo.design.pattern.A04factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:23
 */
public class MarinaraSauce implements Sauce {
    public MarinaraSauce() {
        create();
    }

    @Override
    public void create() {
        System.out.println("Marinara Sauce"); //大蒜番茄酱
    }
}
