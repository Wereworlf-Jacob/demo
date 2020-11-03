package com.example.demo.design.pattern.command.control.v2;

import com.example.demo.design.pattern.command.commands.Command;
import com.example.demo.design.pattern.command.commands.NoCommand;

/**
 * 扩展出来关闭，撤销操作的遥控器
 * @auth Jacob
 * @date 2020/11/3 15:22
 */
public class RemoteControl {

    //电器对象打开的命令集合
    Command[] onCommands;
    //电器对象关闭的命令集合
    Command[] offCommands;

    public RemoteControl() {
        //初始化遥控器的时候，遥控器的每个插槽都要设置上空命令
        int num = 7;
        onCommands = new Command[num];
        offCommands = new Command[num];
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < num; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    /**
     * 重写toString方法，打印每个插槽和它对应的命令。
     * 稍后在测试遥控器的时候，会用到这个方法
     * @author Jacob
     * @date 2020/11/3 15:32
     * @return java.lang.String
     */
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
             + "      " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
