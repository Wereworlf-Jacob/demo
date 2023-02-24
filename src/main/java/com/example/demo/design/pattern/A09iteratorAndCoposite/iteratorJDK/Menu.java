package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorJDK;

import java.util.Iterator;

/**
 * 提取出来菜单类，该菜单当前只公布出来一个创建迭代器的方法
 * 类似addItem方法，后续再考虑
 * @auth Jacob
 * @date 2020/11/5 15:03
 */
public interface Menu {

    Iterator createIterator();
}
