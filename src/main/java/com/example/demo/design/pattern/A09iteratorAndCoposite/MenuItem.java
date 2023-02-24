package com.example.demo.design.pattern.A09iteratorAndCoposite;

/**
 * 菜单对象内容
 * @auth Jacob
 * @date 2020/11/5 14:02
 */
public class MenuItem {

    String name;

    String description;

    boolean vegetarian;

    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
