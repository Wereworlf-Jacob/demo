package com.example.demo.design.pattern.factory.abstractf;

/**
 * 抽象工厂方法测试类
 * @auth Jacob
 * @date 2020/8/31 16:34
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        NYPizzaStore store = new NYPizzaStore();
        store.orderPizza("cheese");
    }
}
