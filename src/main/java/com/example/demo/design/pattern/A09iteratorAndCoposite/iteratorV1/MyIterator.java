package com.example.demo.design.pattern.A09iteratorAndCoposite.iteratorV1;

/**
 * 我自定义的迭代器，在java.util包下有迭代器Iterator，我们可以直接拿来使用
 * @auth Jacob
 * @date 2020/11/5 14:36
 */
public interface MyIterator {
    boolean hasNext();
    Object next();
}
