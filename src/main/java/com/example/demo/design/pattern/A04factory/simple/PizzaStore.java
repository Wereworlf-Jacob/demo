package com.example.demo.design.pattern.A04factory.simple;

import com.example.demo.design.pattern.A04factory.Pizza;

/**
 * 披萨店，客户用来在店里下一个披萨订单
 * @auth Jacob
 * @date 2020/8/4 10:06
 */
public class PizzaStore {

    SimplePizzaFacoty facoty;

    //给披萨店分配一个供应披萨的工厂
    public PizzaStore(SimplePizzaFacoty facoty) {
        this.facoty = facoty;
    }

    //制作一个披萨
    public Pizza orderPizza(String type) {
        Pizza pizza = facoty.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
