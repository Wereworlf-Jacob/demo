package com.example.demo.design.pattern.A04factory.abstractf.ingredients;

/**
 * 纽约风味的薄脆面皮
 * @auth Jacob
 * @date 2020/8/31 16:22
 */
public class ThinCrustDough implements Dough {
    public ThinCrustDough() {
        create();
    }

    @Override
    public void create() {
        System.out.println("Thin Crust Dough"); //薄皮面团
    }
}
