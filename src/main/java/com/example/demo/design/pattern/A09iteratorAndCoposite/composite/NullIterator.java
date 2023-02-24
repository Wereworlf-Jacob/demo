package com.example.demo.design.pattern.A09iteratorAndCoposite.composite;

import java.util.Iterator;

/**
 * @auth Jacob
 * @date 2023/2/24 11:50
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        return null;
    }
}
