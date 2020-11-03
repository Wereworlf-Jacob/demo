package com.example.demo.design.pattern.command.control.v3;

import com.example.demo.design.pattern.command.api.Hottub;
import com.example.demo.design.pattern.command.api.Light;
import com.example.demo.design.pattern.command.api.Stereo;
import com.example.demo.design.pattern.command.api.TV;
import com.example.demo.design.pattern.command.commands.*;
import com.example.demo.design.pattern.command.control.v2.RemoteControl;

/**
 * 遥控器宏命令测试
 * @auth Jacob
 * @date 2020/11/3 17:16
 */
public class RemoteMacroControlTest {

    public static void main(String[] args) {
        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
        TVOnCommand tvOn = new TVOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TVOffCommand tvOff = new TVOffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn };
        Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro off ---");
        remoteControl.offButtonWasPushed(0);

        System.out.println("===== test undo macro =========");
        RemoteControlWithUndo remoteControlUndo = new RemoteControlWithUndo();
        remoteControlUndo.setCommand(0, partyOnMacro, partyOffMacro);
        System.out.println("--- Pushing Macro On ---");
        remoteControlUndo.onButtonWasPushed(0);
        System.out.println("--- undo Macro ---");
        remoteControlUndo.undoButtionWasPushed();
        System.out.println("--- Pushing Macro off ---");
        remoteControlUndo.offButtonWasPushed(0);
        System.out.println("--- undo Macro ---");
        remoteControlUndo.undoButtionWasPushed();
        System.out.println("===== test undo macro =========");

    }

}
