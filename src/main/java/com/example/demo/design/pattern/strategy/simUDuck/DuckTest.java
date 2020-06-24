package com.example.demo.design.pattern.strategy.simUDuck;

import com.example.demo.design.pattern.strategy.simUDuck.behavior.impl.FlyRocketPowered;

/**
 * @ClassName DuckTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 15:47
 **/
public class DuckTest {
    public static void main(String[] args) {

        /**
         * 利用继承实现duck会导致如下缺点
         * 代码在多个子类中重复
         * 运行时行为不易发生改变
         * 难以得知所有鸭子的行为
         * 改变会牵一发而动全身，造成其他鸭子不想要的改变。
         */
//        Duck duck = new MallardDuck();
//        Duck duck = new RedHeadDuck();
//        Duck duck = new RubberDuck();
        Duck duck = new ModelDuck();
        duck.display();
        duck.performFly();
        //通过set方法，可以实现在运行时改变行为；
        duck.setFlyBehavior(new FlyRocketPowered());
        duck.performFly();
        duck.performQuack();
        duck.swim();
    }
}
