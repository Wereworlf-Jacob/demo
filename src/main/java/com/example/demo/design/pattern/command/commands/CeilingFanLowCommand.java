package com.example.demo.design.pattern.command.commands;

import com.example.demo.design.pattern.command.api.CellingFan;

/**
 * 设置吊扇低速
 * @auth Jacob
 * @date 2020/11/3 16:38
 */
public class CeilingFanLowCommand implements Command {

    CellingFan cellingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    @Override
    public void execute() {
        //执行操作之前，需要记录前一个状态值
        prevSpeed = cellingFan.getSpeed();
        cellingFan.low();
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
