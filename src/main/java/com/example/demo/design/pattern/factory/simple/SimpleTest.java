package com.example.demo.design.pattern.factory.simple;

import com.example.demo.design.pattern.factory.Pizza;

/**
 * @auth Jacob
 * @date 2020/8/4 10:20
 */
public class SimpleTest {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFacoty());
        Pizza pizza = pizzaStore.orderPizza("clam"); //我要买一个蛤蜊披萨
        System.out.println(pizza);
    }
}
