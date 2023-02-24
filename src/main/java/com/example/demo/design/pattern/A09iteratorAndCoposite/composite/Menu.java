package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单
 * 组合组件，不继承getPrice和isVegetarian
 * @auth Jacob
 * @date 2023/2/24 10:42
 */
public class Menu extends MenuComponent {

    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return (MenuComponent) menuComponents.get(i);
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
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("----------------------");
        //print方法，因为菜单是一个组合，所以要输出的话，就要输出组合的每个节点。
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator createIterator() {
        //书中例子：会重复输出子菜单项
//        return new CompositeIterator(menuComponents.iterator());
        //改版后的例子，会遍历所有项
        return menuComponents.iterator();
    }
}
