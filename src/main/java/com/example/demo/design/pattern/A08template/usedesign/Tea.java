package com.example.demo.design.pattern.A08template.usedesign;

/**
 * @auth Jacob
 * @date 2020/11/4 16:39
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addConfiments() {
        System.out.println("Adding Lemon"); //添加柠檬
    }
}
