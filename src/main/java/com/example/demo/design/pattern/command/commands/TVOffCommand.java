package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.TV;

/**
 * @auth Jacob
 * @date 2020/11/3 17:21
 */
public class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
