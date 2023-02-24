package com.example.demo.design.pattern.A04factory.simple;

import com.example.demo.design.pattern.A04factory.Pizza;

/**
 * 简单的披萨工厂
 * @auth Jacob
 * @date 2020/8/4 10:07
 */
public class SimplePizzaFacoty {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        //芝士披萨
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
            //意大利香肠披萨
        } else if ("pepperonis".equals(type)) {
            pizza = new PepperonisPizza();
            //蛤蜊披萨
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
            //蔬菜披萨
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }

}
