package com.example.demo.design.pattern.A10state;

/**
 * @auth Jacob
 * @date 2023/2/24 17:21
 */
public class SoldState implements State {
    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请稍等，我们正在准备给你一个糖果");
    }

    @Override
    public void ejectQuater() {
        System.out.println("对不起，你已经转动曲柄了");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("两次的转动不会给你另外更多的糖果");
        return false;
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("糖果卖完了");
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }
}
