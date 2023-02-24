package com.example.demo.design.pattern.A07adapter.mockiterator;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举对象适配成迭代器的适配器
 * 在早期java的集合对象中例如：Vector、Stack、Hashtable 都实现了一个elements的方法
 * 该方法返回一个Enumeration，枚举类，该类可以遍历集合中的对象
 *
 * 而Sun更新集合类之后，推出了新的Iterator迭代器接口来遍历元素
 *
 * 所以我们都希望在代码中尽量都使用迭代器，而遗留代码中的Enumeration就需要适配成迭代器
 * @auth Jacob
 * @date 2020/11/4 10:27
 */
public class EnumerationIteratorAdapter implements Iterator {

    private Enumeration enumeration;

    public EnumerationIteratorAdapter(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
