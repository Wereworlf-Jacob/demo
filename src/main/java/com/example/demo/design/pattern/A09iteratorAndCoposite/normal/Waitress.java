package com.example.demo.design.pattern.A09iteratorAndCoposite.normal;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.ArrayList;

/**
 * 女招待员，可以从菜单中点餐
 * @auth Jacob
 * @date 2020/11/5 14:23
 */
public class Waitress {

    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();

    ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    public void printMenu() {
        /**
         * 早餐菜单和午餐菜单看起来获取方法是一样的，但是返回值是不一样的。
         * 那么此时，我们来遍历这个菜单，那么就会出现代码重复的情况
         * 如果我们都用迭代器来遍历的话，那么就可以保持一种遍历形式
         */
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem == null)
                continue;
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }

    public static void main(String[] args) {
        Waitress waitress = new Waitress();
        waitress.printMenu();
    }
}
