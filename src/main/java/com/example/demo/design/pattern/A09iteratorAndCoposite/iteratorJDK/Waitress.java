package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorJDK;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 应用了jdk的iterator的女招待
 * @auth Jacob
 * @date 2020/11/5 15:07
 */
public class Waitress {

    Menu pancakeHouseMenu;
    Menu dinerMenu;
    //让女招待认识咖啡馆的菜单
    Menu cafeMenu;
    ArrayList menus;

    //这样女招待就不再依赖具体的菜单了，只要是菜单，那这个女招待就能知道菜单的菜单项
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public Waitress(ArrayList menus) {
        this.menus = menus;
    }

    /**
     * 这个printMenu()方法为每一个菜单创建一个迭代器
     * 然后对每个迭代器调用重载的printMenu(MyIterator)，将迭代器传入，然后遍历菜单项并打印出来
     * 这样我们的女招待就能从具体类里面解耦出来，她不需要知道菜单时使用数组还是list，只需要获取到迭代器就可以了
     */
    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        //获取这个咖啡管菜单的迭代器
        Iterator cafeIterator = cafeMenu.createIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    public void printMenu2() {
        Iterator menuIterator = menus.iterator();
        System.out.print("MENU\n----");
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            System.out.println("\nunknown menu name");
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator myIterator) {
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

    /**
     * 通过menu接口，我们将女招待从具体的类中解耦了出去，但是每当我们增加一种类型的集合之后
     * 仍然需要让女招待来知道这个菜单从而拿到菜单的迭代器，这样仍然是存在些许绑定的情况
     * @param args
     */
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
        /**
         * 如果我们给女招待一个菜单集合，而不需要让她知道菜单名称
         * 那么我们就可以避免让女招待连续调用三次乃至更多的print(Iterator)
         */
        ArrayList menus = new ArrayList();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);
        Waitress waitressV2 = new Waitress(menus);
        waitressV2.printMenu2();
    }
}
