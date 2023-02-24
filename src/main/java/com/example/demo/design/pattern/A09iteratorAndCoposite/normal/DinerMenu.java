package com.example.demo.design.pattern.A09iteratorAndCoposite.normal;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;
import com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorV1.DinerMenuIterator;
import com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorV1.MyIterator;

/**
 * Mel的餐厅菜单
 * @auth Jacob
 * @date 2020/11/5 14:10
 */
public class DinerMenu {

    //餐厅的菜单是定长的，老板只想做有限数量的菜品
    static final int MAX_ITEMS = 6;

    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", //素食BLT
                //（煎）培根、生菜 & 系统是 用麸皮面包做
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true, 2.99d);

        addItem("BLT", //BLT
                //培根、生菜&西红柿
                "Bacon with lettuce & tomato on whole wheat",
                false, 2.99d);

        addItem("Soup of the day", //例汤
                "Soup of the day, with a side of potato salad", //一碗例汤，配上土豆沙拉
                false, 3.29d);

        addItem("Hotdog", //热狗
                //热狗，酸菜，上盖芝士
                "A hot dog,with saurkraut, relish, onions, topped with cheese",
                false, 3.05d);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    //普通的获取菜单的方式
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    //迭代器模式下，我们就不需要获取菜单数组了，我们只需要获取菜单的迭代器就可以了
    //这样客户也不需要知道菜单是怎么维护菜单项的，也不需要知道迭代器是怎么实现的，只需要遍历就可以了
    public MyIterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }

    //这里还有菜单的其他方法
}
