package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorJDK;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * 咖啡馆的菜单，如今也合并了进来
 * @auth Jacob
 * @date 2020/11/5 15:12
 */
public class CafeMenu implements Menu {

    Hashtable menuItems;

    public CafeMenu() {
        menuItems = new Hashtable();
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99d);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69d);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29d);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator createIterator() {
        //还好咖啡馆的Hashtable结构的values支持迭代器，所以不需要定义咖啡馆的迭代器
        return menuItems.values().iterator();
    }
}
