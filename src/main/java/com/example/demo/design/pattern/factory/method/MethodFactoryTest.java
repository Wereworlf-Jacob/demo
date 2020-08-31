package com.example.demo.design.pattern.factory.method;

import com.example.demo.design.pattern.factory.Pizza;

/**
 * @auth Jacob
 * @date 2020/8/31 15:35
 */
public class MethodFactoryTest {

    public static void main(String[] args) {
//        ChicagoPizzaStore store = new ChicagoPizzaStore();
        NYPizzaStore store = new NYPizzaStore();
        Pizza pizza = store.orderPizza("cheese");
    }

}
