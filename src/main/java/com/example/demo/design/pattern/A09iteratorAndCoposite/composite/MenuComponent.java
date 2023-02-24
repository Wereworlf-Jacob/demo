package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

import java.util.Iterator;

/**
 * 菜单组件
 * 为叶节点和组合节点提供一个共同的接口。
 * @auth Jacob
 * @date 2023/2/23 10:17
 */
public abstract class MenuComponent {

    //将新增、删除和取得菜单组件，这些“组合”方法，组织到一起。
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    //这些是“操作”方法，他们被菜单项使用。也可以用到菜单上。
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    //在组合中添加迭代器
    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }

}
