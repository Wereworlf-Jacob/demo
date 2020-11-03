package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.Light;

/**
 * 电灯打开命令
 * @auth Jacob
 * @date 2020/8/31 18:15
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) { //构造器被传入了某个电灯（比如客厅的电灯），以便让这个命令控制
        this.light = light;
    }

    @Override
    public void execute() {
        light.on(); //接口调用对象，比如电灯，来调用电灯的on方法
    }

    @Override
    public void undo() {
        //打开电灯的撤销命令就是关闭电灯
        light.off();
    }
}
