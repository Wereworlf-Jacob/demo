package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

import java.util.Iterator;

/**
 * @auth Jacob
 * @date 2023/2/24 9:35
 */
public class MenuItem extends MenuComponent {

    String name;

    String description;

    boolean vegetarian;

    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(V)");
        }
        System.out.println(", " + getPrice());
        System.out.println("   --" + getDescription());
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
