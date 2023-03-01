package com.example.demo.design.pattern.A10state;

/**
 * @auth Jacob
 * @date 2023/2/24 17:21
 */
public class NoQuarterState implements State {

    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投入了25分钱");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuater() {
        System.out.println("你还没有投入25分钱");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("你转动了曲柄，但是没有给钱");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("你还没有给钱");
    }
}
