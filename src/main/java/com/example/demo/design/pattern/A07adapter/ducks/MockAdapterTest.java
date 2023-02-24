package com.example.demo.design.pattern.A07adapter.ducks;

/**
 * 来测试鸭子适配器和火鸡适配器
 * @auth Jacob
 * @date 2020/11/4 10:10
 */
public class MockAdapterTest {

    public static void main(String[] args) {
        WildTurkey wildTurkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);
        testDuck(turkeyAdapter);

        MallardDurk mallardDurk = new MallardDurk();
        DuckAdapter duckAdapter = new DuckAdapter(mallardDurk);
        testTurkey(duckAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }

}
