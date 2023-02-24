package com.example.demo.design.pattern.A04factory.method;

import com.example.demo.design.pattern.A04factory.Pizza;

/**
 * @auth Jacob
 * @date 2020/8/31 15:24
 */
public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Pizza Deep Dish Cheese Pizza"; //芝加哥风味深盘风味披萨
        dough = "Extra Thick Crust Dough"; //   特别厚的面皮
        sauce = "Plum Tomato Sauce"; // 小番茄酱料

        toppings.add("Shredded Mozzarella Cheese"); //芝加哥风味的深盘披萨使用许多的意大利白干酪
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices"); //把披萨切割成方形的片
    }
}
