package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.Light;

/**
 * 电灯关闭命令
 * @auth Jacob
 * @date 2020/11/3 15:34
 */
public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        //关闭电灯的撤销命令，就是打开电灯
        light.on();
    }
}
