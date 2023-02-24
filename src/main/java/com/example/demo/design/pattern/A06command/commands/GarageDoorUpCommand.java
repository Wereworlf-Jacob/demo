package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.GarageDoor;

/**
 * 打开车库门的命令对象
 * @auth Jacob
 * @date 2020/11/3 15:15
 */
public class GarageDoorUpCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}
