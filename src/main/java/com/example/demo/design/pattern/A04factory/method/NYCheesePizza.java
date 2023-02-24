package com.example.demo.design.pattern.A04factory.method;

import com.example.demo.design.pattern.A04factory.Pizza;

/**
 * 纽约风味芝士披萨
 * @auth Jacob
 * @date 2020/8/5 16:15
 */
public class NYCheesePizza extends Pizza {

    public NYCheesePizza() {
        name = "NY style Sauce and Cheese pizza";//纽约风味酱料和芝士的披萨
        dough = "Thin Crust Dough"; //薄皮面团
        sauce = "Marinara Sauce"; // 大蒜番茄酱

        toppings.add("Grated Reggiano Cheese"); //意大利 reggiano 高级干酪
    }
}
