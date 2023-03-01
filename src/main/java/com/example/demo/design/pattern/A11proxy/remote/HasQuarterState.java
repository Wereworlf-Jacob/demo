package com.example.demo.design.pattern.A11proxy.remote;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * @auth Jacob
 * @date 2023/2/24 17:22
 */
public class HasQuarterState implements State {

    //需要加入一个随机数生成器，来生成幸运买家
    transient Random winnerRandom = new Random(System.currentTimeMillis());
    transient private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你不能再投入更多的25分钱了");
    }

    @Override
    public void ejectQuater() {
        System.out.println("退回25分钱");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public boolean turnCrank() {
        System.out.println("你转动了曲柄...");
        //如果中奖了，那么就走幸运买家状态行为
        int winner = winnerRandom.nextInt(10);
        try {
            if (winner == 0 && gumballMachine.getCount() > 1) {
                gumballMachine.setState(gumballMachine.getWinnerState());
            } else {
                gumballMachine.setState(gumballMachine.getSoldState());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void dispense() {
        System.out.println("还没有转动曲柄，所以没有糖果");
    }
}
