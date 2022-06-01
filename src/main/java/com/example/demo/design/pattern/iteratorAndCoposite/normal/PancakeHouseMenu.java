package com.example.demo.design.pattern.iteratorAndCoposite.normal;

import com.example.demo.design.pattern.iteratorAndCoposite.MenuItem;
import com.example.demo.design.pattern.iteratorAndCoposite.iteratorV1.DinerMenuIterator;
import com.example.demo.design.pattern.iteratorAndCoposite.iteratorV1.MyIterator;
import com.example.demo.design.pattern.iteratorAndCoposite.iteratorV1.PancakeHouseIterator;

import java.util.ArrayList;

/**
 * 煎饼屋的菜单
 * @auth Jacob
 * @date 2020/11/5 14:00
 */
public class PancakeHouseMenu {

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
    //迭代器模式下，我们就不需要获取菜单数组了，我们只需要获取菜单的迭代器就可以了
    //这样客户也不需要知道菜单是怎么维护菜单项的，也不需要知道迭代器是怎么实现的，只需要遍历就可以了
    public MyIterator createIterator() {
        return new PancakeHouseIterator(menuItems);
    }


    //这里还有菜单的其他方法
}
