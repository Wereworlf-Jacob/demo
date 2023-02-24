package com.example.demo.design.pattern.A08template.tradional;

/**
 * 茶
 * @auth Jacob
 * @date 2020/11/4 16:06
 */
public class Tea {

    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() { //煮沸水
        System.out.println("Boiling water");
    }
    /* steep tea bag 和 add lemon 是泡茶专有的*/
    public void steepTeaBag() { //steep 泡 泡茶叶包
        System.out.println("Steeping the tea");
    }
    public void addLemon() {
        System.out.println("Adding Lemon"); //添加柠檬
    }
    /* 专有end */
    public void pourInCup() { //咖啡倒进杯子
        System.out.println("Pouring into cup");
    }

}
