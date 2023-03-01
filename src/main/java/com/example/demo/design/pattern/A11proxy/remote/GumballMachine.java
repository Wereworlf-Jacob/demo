package com.example.demo.design.pattern.A11proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @auth Jacob
 * @date 2023/2/24 17:22
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    //加入10%机会的幸运玩家
    State winnerState;

    State state = soldOutState;
    int count = 0;
    String location;

    public GumballMachine(String localtion, int numberGumballs) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
        this.location = localtion;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuater();
    }

    public void turnCrank() {
        boolean b = state.turnCrank();
        if (b) {
            state.dispense();
        }
    }

    public void releaseBall() {
        System.out.println("从窗口中滚出一个糖果...");
        if (count != 0) {
            count = count - 1;
        }
    }

    @Override
    public State getState() throws RemoteException {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public int getCount() throws RemoteException {
        return count;
    }

    @Override
    public String getLocation() throws RemoteException {
        return null;
    }

    @Override
    public String toString() {
        return "Mighty Gumball, Inc.\n" +
                "Java-enabled Standing Gumball Model #2004\n" +
                "Inventory: " + count + " gumballs\n" +
                "Machine is waiting for quarter" + '\n';
    }
}
