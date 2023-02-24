package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

/**
 * 测试程序
 * @auth Jacob
 * @date 2023/2/24 11:14
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("煎饼屋菜单", "早餐");
        MenuComponent dinerMenu = new Menu("餐厅菜单", "午餐");
        MenuComponent cafeMenu = new Menu("咖啡菜单", "晚餐");
        MenuComponent desserMenu = new Menu("甜点菜单", "当然是甜点了");
        MenuComponent desserMenu2 = new Menu("甜点菜单2", "当然是甜点了");

        MenuComponent allMenus = new Menu("所有菜单", "所有菜单的组合");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem(
                "牛肉煎饼",
                "油滚滚",
                false,
                10
        ));

        dinerMenu.add(new MenuItem(
                "意大利面食",
                "Marinara酱意大利面和一片酸面团面包",
                true,
                3.89
        ));

        dinerMenu.add(desserMenu);

        desserMenu.add(new MenuItem(
                "苹果派",
                "苹果馅饼，上面有香草冰淇淋",
                true,
                1.59
        ));
        desserMenu.add(desserMenu2);
        desserMenu2.add(new MenuItem(
                "苹果派23",
                "上面啥也没有",
                true,
                33
        ));
        //将整个菜单层次构造完毕，把它整个交给女招待，就可以很方便得打印整个菜单
        Waitress waitress = new Waitress(allMenus);
        //输出所有菜单
//        waitress.printMenu();
        //输出素食菜单
        waitress.printVegetarianMenu();
    }

}
