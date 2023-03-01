package com.example.demo.design.pattern.A11proxy.remote;

/**
 * @auth Jacob
 * @date 2023/2/24 17:21
 */
public class SoldOutState implements State {

    transient private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你不能投入25分钱了，糖果机已经售空了");
    }

    @Override
    public void ejectQuater() {
        System.out.println("从来就没有投入过25分钱，不能退钱");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("你转动了曲柄，但是没有糖果滚出");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("没有可分配的糖果");
    }
}
