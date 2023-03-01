package com.example.demo.design.pattern.A11proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口类
 * @auth Jacob
 * @date 2023/2/27 16:30
 */
public interface GumballMachineRemote extends Remote {

    int getCount() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
    //所有返回类型都必须是可序列化的类型。所以这里state继承下序列化。

}
