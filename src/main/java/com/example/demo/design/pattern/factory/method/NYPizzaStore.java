package com.example.demo.design.pattern.factory.method;

import com.example.demo.design.pattern.factory.Pizza;

/**
 * 纽约披萨店
 * @auth Jacob
 * @date 2020/8/4 10:43
 */
public class NYPizzaStore extends PizzaStore {

    //纽约披萨店来定制自己的披萨是什么风味的
    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new NYCheesePizza();
        }
        return null;
    }
}
