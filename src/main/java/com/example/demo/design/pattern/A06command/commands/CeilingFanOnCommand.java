package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.CellingFan;

/**
 * 吊扇打开命令
 * @auth Jacob
 * @date 2020/11/3 15:56
 */
public class CeilingFanOnCommand implements Command {

    CellingFan cellingFan;

    public CeilingFanOnCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    @Override
    public void execute() {
        cellingFan.on();
    }

    //带有状态的撤销操作
    @Override
    public void undo() {

    }
}
