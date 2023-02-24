package com.example.demo.design.pattern.A08template.usedesign;

/**
 * 咖啡
 * @auth Jacob
 * @date 2020/11/4 16:40
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter"); //用过滤器滴咖啡
    }

    @Override
    void addConfiments() {
        System.out.println("Adding Sugar and Milk"); //加糖和牛奶
    }
}
