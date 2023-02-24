package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.TV;

/**
 * @auth Jacob
 * @date 2020/11/3 17:21
 */
public class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
