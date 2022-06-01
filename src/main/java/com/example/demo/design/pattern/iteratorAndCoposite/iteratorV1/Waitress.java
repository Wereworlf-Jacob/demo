package com.example.demo.design.pattern.iteratorAndCoposite.iteratorV1;

import com.example.demo.design.pattern.iteratorAndCoposite.MenuItem;
import com.example.demo.design.pattern.iteratorAndCoposite.normal.DinerMenu;
import com.example.demo.design.pattern.iteratorAndCoposite.normal.PancakeHouseMenu;

/**
 * @auth Jacob
 * @date 2020/11/5 14:36
 */
public class Waitress {

    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    /**
     * 这个printMenu()方法为每一个菜单创建一个迭代器
     * 然后对每个迭代器调用重载的printMenu(MyIterator)，将迭代器传入，然后遍历菜单项并打印出来
     * 这样我们的女招待就能从具体类里面解耦出来，她不需要知道菜单时使用数组还是list，只需要获取到迭代器就可以了
     */
    public void printMenu() {
        MyIterator pancakeIterator = pancakeHouseMenu.createIterator();
        MyIterator dinerIterator = dinerMenu.createIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }

    private void printMenu(MyIterator myIterator) {
        /**
         * 判断是否有下一项，有的话就读取下一项
         * 这样我们通过一个循环结构，就能读取list和数组的集合项
         */
        while (myIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) myIterator.next();
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    //测试迭代器版本的查询菜单
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
