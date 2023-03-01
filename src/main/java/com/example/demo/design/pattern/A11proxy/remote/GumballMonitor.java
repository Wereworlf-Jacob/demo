package com.example.demo.design.pattern.A11proxy.remote;

import java.rmi.RemoteException;

/**
 * @auth Jacob
 * @date 2023/2/27 17:03
 */
public class GumballMonitor {

    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("糖果机：" + machine.getLocation());
            System.out.println("库存：" + machine.getCount() + "个糖果");
            System.out.println("当前状态：" + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
