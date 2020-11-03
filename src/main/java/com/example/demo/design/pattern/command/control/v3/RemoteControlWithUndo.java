package com.example.demo.design.pattern.command.control.v3;

import com.example.demo.design.pattern.command.commands.Command;
import com.example.demo.design.pattern.command.commands.NoCommand;

/**
 * 有撤销按键的遥控器
 * @auth Jacob
 * @date 2020/11/3 16:17
 */
public class RemoteControlWithUndo {

    //电器对象打开的命令集合
    Command[] onCommands;
    //电器对象关闭的命令集合
    Command[] offCommands;
    //前一个命令将被记录在这里
    Command undoCommand;

    public RemoteControlWithUndo() {
        //初始化遥控器的时候，遥控器的每个插槽都要设置上空命令
        int num = 7;
        onCommands = new Command[num];
        offCommands = new Command[num];
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < num; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtionWasPushed() {
        undoCommand.undo();
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
        stringBuffer.append("[undoCommand] " + undoCommand.getClass().getName() + "\n");
        return stringBuffer.toString();
    }
}
