package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.Hottub;

/**
 * @auth Jacob
 * @date 2020/11/3 17:21
 */
public class HottubOffCommand implements Command {
    Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.off();
    }

    @Override
    public void undo() {
        hottub.on();
    }
}
