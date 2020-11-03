package com.example.demo.design.pattern.command.control;

import com.example.demo.design.pattern.command.api.GarageDoor;
import com.example.demo.design.pattern.command.api.Light;
import com.example.demo.design.pattern.command.commands.GarageDoorUpCommand;
import com.example.demo.design.pattern.command.commands.LightOnCommand;

/**
 * 遥控器测试类
 * @auth Jacob
 * @date 2020/11/3 15:10
 */
public class RemoteControlTest {

    public static void main(String[] args) {
        //我们要封装一个命令对象，那么需要有控制器， 控制对象（电灯）， 控制命令（打开）；
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        control.setSlot(lightOnCommand);
        //由此我们组成一个遥控器，上面插槽有一个按钮，点击这个按钮将会触发打开电灯操作
        control.buttonWasPressed();

        //同样的我们封装一个打开车库门的命令
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        control.setSlot(garageDoorUpCommand);
        control.buttonWasPressed();
        //以上我们就实现了一个基础的命令对象，后面撤销，关闭等命令，都是基于这个模式的扩展


    }

}
