package com.example.demo.design.pattern.iteratorAndCoposite.iteratorV1;


import com.example.demo.design.pattern.iteratorAndCoposite.MenuItem;

/**
 * 餐厅的菜单迭代器
 * @auth Jacob
 * @date 2020/11/5 14:38
 */
public class DinerMenuIterator implements MyIterator {

    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
