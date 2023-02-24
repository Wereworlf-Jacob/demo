package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.CellingFan;

/**
 * 吊扇设置中速
 * @auth Jacob
 * @date 2020/11/3 16:39
 */
public class CeilingFanMediumCommand implements Command {

    CellingFan cellingFan;
    int prevSpeed;

    public CeilingFanMediumCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    @Override
    public void execute() {
        //执行操作之前，需要记录前一个状态值
        prevSpeed = cellingFan.getSpeed();
        cellingFan.medium();
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
