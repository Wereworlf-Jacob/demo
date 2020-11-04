package com.example.demo.design.pattern.adapter.ducks;

/**
 * 同样，我们需要火鸡的时候，缺少鸭子对象
 * 那么就通过鸭子适配器，来将火鸡适配成鸭子
 * @auth Jacob
 * @date 2020/11/4 10:09
 */
public class DuckAdapter implements Turkey {

    //同样的我们需要有一个鸭子对象
    private Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
        System.out.println("鸭子跌倒了");
    }
}
