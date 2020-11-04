package com.example.demo.design.pattern.template.tradional;

/**
 * 咖啡
 * @auth Jacob
 * @date 2020/11/4 15:59
 */
public class Coffee {

    //咖啡冲泡法，recipe 配方
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() { //煮沸水
        System.out.println("Boiling water");
    }
    public void brewCoffeeGrinds() { //用沸水冲泡咖啡 brew: 煮，冲泡，酿造 grinds：研磨
        System.out.println("Dripping Coffee through filter"); //用过滤器滴咖啡
    }
    public void pourInCup() { //咖啡倒进杯子
        System.out.println("Pouring into cup");
    }
    public void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk"); //加糖和牛奶
    }

}
