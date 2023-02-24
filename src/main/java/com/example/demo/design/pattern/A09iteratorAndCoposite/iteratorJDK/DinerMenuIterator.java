package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorJDK;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.Iterator;

/**
 * 餐馆菜单的迭代器-使用jdk的迭代器
 * @auth Jacob
 * @date 2020/11/5 14:56
 */
public class DinerMenuIterator implements Iterator {

    MenuItem[] list;
    int position = 0;

    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = list[position];
        position++;
        return menuItem;
    }
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one nest()");
        }
        if (list[position - 1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[ i + 1 ];
            }
            list[list.length - 1] = null;
        }
    }
}
