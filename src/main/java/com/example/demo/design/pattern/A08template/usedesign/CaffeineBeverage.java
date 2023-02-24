package com.example.demo.design.pattern.A08template.usedesign;

/**
 * 抽象出来共同的算法过程，为咖啡因饮料
 * @auth Jacob
 * @date 2020/11/4 16:35
 */
public abstract class CaffeineBeverage {

    //避免子类修改超类的算法，将其设定为final形式
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addConfiments();
    }

    /* 冲泡还是浸泡操作，添加什么调味品是由子类来确定的，所以为抽象方法 */
    abstract void brew();
    abstract void addConfiments();

    void boilWater() { //煮沸水
        System.out.println("Boiling water");
    }
    void pourInCup() { //咖啡倒进杯子
        System.out.println("Pouring into cup");
    }

}
