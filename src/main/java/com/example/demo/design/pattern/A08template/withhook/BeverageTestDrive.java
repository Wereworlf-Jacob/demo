package com.example.demo.design.pattern.A08template.withhook;

/**
 * 饮料测试类
 * @auth Jacob
 * @date 2020/11/4 16:54
 */
public class BeverageTestDrive {

    public static void main(String[] args) {
        TeaWithHook teaWithHook = new TeaWithHook();
        CoffeeWithHook coffeeWithHook = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        teaWithHook.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffeeWithHook.prepareRecipe();
    }

}
