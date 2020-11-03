package com.example.demo.design.pattern.command.control;

import com.example.demo.design.pattern.command.commands.Command;

/**
 * 有一个插槽持有命令，而这个命令控制着一个装置
 * @auth Jacob
 * @date 2020/8/31 18:18
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    //这段代码，用来设置插槽控制的命令。如果这段代码的客户想要改变按钮的行为，可以多次调用这个方法
    public void setSlot(Command slot) {
        this.slot = slot;
    }

    //当按钮被按下的时候，这个方法就会被调用，使得当前命令衔接插槽，并调用它的execute方法
    public void buttonWasPressed() {
        slot.execute();
    }
}
