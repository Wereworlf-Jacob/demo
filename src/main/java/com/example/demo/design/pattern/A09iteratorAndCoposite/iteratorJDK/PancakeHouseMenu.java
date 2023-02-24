package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorJDK;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋的菜单-使用jdk中的iterator
 * @auth Jacob
 * @date 2020/11/5 14:00
 */
public class PancakeHouseMenu implements Menu {

    //煎饼屋的老板用ArrayList来保存菜单内容
    ArrayList menuItems;

    public PancakeHouseMenu() { //初始化菜单内容
        menuItems = new ArrayList();

        addItem("K&B's Pancake Breakfast", //K&B's 薄煎饼早餐
                "Pancakes with scrambled eggs, and toast", //薄煎饼、清蛋和吐司
                true,
                2.99d);

        addItem("Regular Pancake Breakfast", //薄煎饼早餐例餐
                "Pancakes with fried eggs, sausage", //薄煎饼带简单，香肠
                false,
                2.99d);

        addItem("Blueberry Pancakes", //蓝莓薄煎饼
                "Pancakes made with fresh blueberries", //新鲜蓝莓和蓝莓糖浆做成的薄煎饼
                true,
                3.49d);

        addItem("Waffles", //松饼
                "Waffles, with your choice of blueberries or strawberries",//松饼可以选择蓝莓或草莓
                true,
                3.59d);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        //ArrayList自己就支持迭代器，所以可以直接返回一个迭代器
        return menuItems.iterator();
    }


    //这里还有菜单的其他方法
}
