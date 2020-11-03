package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.Stereo;

/**
 * 放入cd盘打开音响设备
 * @auth Jacob
 * @date 2020/11/3 15:40
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        //要实现CD打开音响，需要三步
        //1、打开音响
        stereo.on();
        //2、设置为CD播放
        stereo.setCd();
        //3、设置播放音量
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
