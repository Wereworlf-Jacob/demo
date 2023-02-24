package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.Stereo;

/**
 * 关闭音响的命令
 * @auth Jacob
 * @date 2020/11/3 15:59
 */
public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
