package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorV1;

import com.example.demo.design.pattern.A09iteratorAndCoposite.MenuItem;

import java.util.ArrayList;

/**
 * @auth Jacob
 * @date 2020/11/5 14:43
 */
public class PancakeHouseIterator implements MyIterator {

    ArrayList menuList;
    int position;

    public PancakeHouseIterator(ArrayList menuList) {
        this.menuList = menuList;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuList.size() || menuList.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) menuList.get(position);
        position++;
        return menuItem;
    }
}
