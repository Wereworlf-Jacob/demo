package com.example.demo.design.pattern.template.usedesign;

/**
 * 测试咖啡因饮料
 * @auth Jacob
 * @date 2020/11/4 16:42
 */
public class TestCaffeineBeverage {

    public static void main(String[] args) {
        System.out.println("preparing make te -------");
        Tea myTea = new Tea();
        myTea.prepareRecipe();
        System.out.println("preparing make coffee -------");
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
