package com.example.demo.design.pattern.A06command.control.v3;

import com.example.demo.design.pattern.A06command.api.CellingFan;
import com.example.demo.design.pattern.A06command.api.Light;
import com.example.demo.design.pattern.A06command.commands.*;

/**
 * 测试带有撤销操作的遥控器
 * @auth Jacob
 * @date 2020/11/3 15:42
 */
public class RemoteLoaderWithUndo {

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
        //创建一个电灯对象
        Light livingRoomLight = new Light("Living Room");
        //创建一个支持undo()功能的命令
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtionWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtionWasPushed();
        System.out.println("======================================================");

        CellingFan cellingFan = new CellingFan("Living Room");
        //创建高速，中速和关闭的命令
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(cellingFan);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(cellingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(cellingFan);

        remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);
        remoteControl.onButtonWasPushed(1); //中速开启吊扇
        remoteControl.offButtonWasPushed(1);//关闭吊扇
        System.out.println(remoteControl);
        remoteControl.undoButtionWasPushed(); //撤销，应该回回到中速...
        remoteControl.onButtonWasPushed(2); //高速开启吊扇
        System.out.println(remoteControl);
        remoteControl.undoButtionWasPushed();//再进行一次撤销，应该会回到中速。

    }

}
