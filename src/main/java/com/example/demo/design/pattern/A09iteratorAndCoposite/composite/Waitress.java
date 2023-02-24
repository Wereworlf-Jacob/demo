package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

import java.util.Iterator;

/**
 * @auth Jacob
 * @date 2023/2/24 11:13
 */
public class Waitress {

    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    public void printMenu() {
        allMenus.print();
    }

    /**
     * 设计模式书上的例子有问题，其创建createIterator的时候，每次都使用了
     * CopositeIterator这个迭代器，这就导致当有二级菜单时，判断为菜单
     * iterator.next会递归到子组件的stack中，这样会在父stack和子stack中同时push进一个菜单项
     * 最终结果是，子菜单内容会遍历两遍
     * 解决方法：将CompositeIterator移到外部，只使用一个stack来堆栈存储下级菜单。
     * 用在外部处理，自我感觉像是装饰器模式，装饰了一下迭代器，让其能够遍历组合中的子项
     * */
    //使用组合迭代器
    //通过外部迭代器，女招待就可以获得所有的菜单项和子菜单，这样就能根据自己的需求来过滤菜单
    //比如找到素食菜单
    public void printVegetarianMenu() {
        //配合书中new CompositeIterator(menuComposites.iterator);
//        Iterator iterator = allMenus.createIterator();
        //改进为装饰器模式，装饰组合的迭代器，实现完整遍历
        //不能调用菜单的print，因为菜单会输出下级所有资源，会导致输出好多遍
        Iterator iterator = new CompositeIterator(allMenus.createIterator());
        System.out.println("\n素食菜单\n---");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try {
                if (!menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ex) { }
        }

    }
}
