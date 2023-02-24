package com.example.demo.design.pattern.A08template.withhook;

/**
 * 咖啡因饮料带有钩子函数的模板
 * @auth Jacob
 * @date 2020/11/4 16:46
 */
public abstract class CaffeineBeverageWithHook {

    //避免子类修改超类的算法，将其设定为final形式
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        /**
         *加上了一个条件语句，而条件是否成立由customerWantsCondiments()来决定
         * 如果客户想要调料，我们才调用addCondiments();
         */
        if (customerWantsCondiments()) {
            addConfiments();
        }
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

    /**
     * 这是一个钩子，子类可以覆盖这个方法，来控制模板一些流程
     * 但是子类不一定非得这样做，默认情况下，执行模板所有流程
     * @return
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
