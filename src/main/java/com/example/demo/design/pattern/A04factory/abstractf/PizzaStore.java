package com.example.demo.design.pattern.A04factory.abstractf;

/**
 * 抽象工厂方法中的披萨工厂
 * @auth Jacob
 * @date 2020/8/31 16:18
 */
public abstract class PizzaStore {

    /**
     * 这里仍然是一个订购披萨的方法
     * 但是给披萨进行配料分配的过程，抽象出来留给子类去实现
     * 披萨的加工，烘焙，切片，装盒流程是固定不变的，这是为了保证披萨的质量
     * @param type
     * @author Jacob
     * @date 2020/8/4 10:46
     * @return com.example.demo.design.pattern.factory.Pizza
     */
    public AbstractPizza orderPizza(String type) {
        AbstractPizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    /**
     * 这里抽象出来一个工厂方法
     * 该方法就相当一个工厂，由子类来决定这个工厂生产什么产品
     * @param type
     * @author Jacob
     * @date 2020/8/4 10:42
     * @return com.example.demo.design.pattern.factory.Pizza
     */
    public abstract AbstractPizza createPizza(String type);
}
