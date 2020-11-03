package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.CellingFan;

/**
 * 吊扇关闭命令
 * @auth Jacob
 * @date 2020/11/3 15:56
 */
public class CeilingFanOffCommand implements Command {

    CellingFan cellingFan;
    int prevSpeed;

    public CeilingFanOffCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    @Override
    public void execute() {
        //执行操作之前，需要记录前一个状态值
        prevSpeed = cellingFan.getSpeed();
        cellingFan.off();
    }

    @Override
    public void undo() {
        if (prevSpeed == CellingFan.HIGH) {
            cellingFan.high();
        } else if (prevSpeed == CellingFan.MEDIUM) {
            cellingFan.medium();
        } else if (prevSpeed == CellingFan.LOW) {
            cellingFan.low();
        } else if (prevSpeed == CellingFan.OFF) {
            cellingFan.off();
        }
    }
}
