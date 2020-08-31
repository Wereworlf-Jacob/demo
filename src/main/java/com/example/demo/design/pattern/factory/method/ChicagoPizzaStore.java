package com.example.demo.design.pattern.factory.method;

import com.example.demo.design.pattern.factory.Pizza;

/**
 * 芝加哥披萨店
 * @auth Jacob
 * @date 2020/8/4 10:44
 */
public class ChicagoPizzaStore extends PizzaStore {
    //芝加哥的披萨店，来定制自己的披萨是什么风味的
    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
