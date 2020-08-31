package com.example.demo.design.pattern.factory.abstractf.ingredients;

/**
 * @auth Jacob
 * @date 2020/8/31 16:31
 */
public class SlicedPepperoni implements Pepperoni {
    public SlicedPepperoni() {
        create();
    }

    @Override
    public void create() {
        System.out.println("sliced pepperoni 意式风味腊肠");
    }
}
