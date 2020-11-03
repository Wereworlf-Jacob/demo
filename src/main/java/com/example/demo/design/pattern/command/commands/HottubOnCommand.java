package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.Hottub;

/**
 *
 * @auth Jacob
 * @date 2020/11/3 17:21
 */
public class HottubOnCommand implements Command {
    Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.on();
    }

    @Override
    public void undo() {
        hottub.off();
    }
}
