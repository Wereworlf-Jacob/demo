package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.GarageDoor;

/**
 * 关闭车库大门的命令
 * @auth Jacob
 * @date 2020/11/3 15:58
 */
public class GarageDoorDownCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {

    }
}
