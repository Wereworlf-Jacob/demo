package com.example.demo.design.pattern.A07adapter.ducks;

/**
 * 当我们缺少鸭子对象的时候，我们需要用火鸡来冒充鸭子
 * 那么就通过火鸡适配器，将火鸡适配成鸭子
 * @auth Jacob
 * @date 2020/11/4 10:07
 */
public class TurkeyAdapter implements Duck {

    //需要用火鸡来模拟鸭子的行为，那么就需要持有一个火鸡对象
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        //火鸡的飞行距离太短，所以让它多飞几次
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
