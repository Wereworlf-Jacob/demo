package com.example.demo.design.pattern.A06command.control.v2;

import com.example.demo.design.pattern.A06command.api.CellingFan;
import com.example.demo.design.pattern.A06command.api.GarageDoor;
import com.example.demo.design.pattern.A06command.api.Light;
import com.example.demo.design.pattern.A06command.api.Stereo;
import com.example.demo.design.pattern.A06command.commands.*;

/**
 * 测试第二版本的遥控器
 * @auth Jacob
 * @date 2020/11/3 15:42
 */
public class RemoteLoader {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        //创建电器对象
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CellingFan cellingFan = new CellingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("Living Room");
        //创建控制电器的一系列命令
        /* 创建所有的电灯命令对象 */
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        /* 创建吊扇的开关命令 */
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(cellingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(cellingFan);

        /* 创建车库门上和下的命令 */
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        /* 创建音响的开关命令 */
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        //将所有的命令加载到遥控器的插槽中
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }

}
