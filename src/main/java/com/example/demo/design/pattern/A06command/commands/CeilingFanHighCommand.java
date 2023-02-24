package com.example.demo.design.pattern.A06command.commands;

import com.example.demo.design.pattern.A06command.api.CellingFan;

/**
 * 设置吊扇高转速命令
 * @auth Jacob
 * @date 2020/11/3 16:32
 */
public class CeilingFanHighCommand implements Command {

    CellingFan cellingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    @Override
    public void execute() {
        //执行操作之前，需要记录前一个状态值
        prevSpeed = cellingFan.getSpeed();
        cellingFan.high();
    }

    @Override
    public void undo() { //将吊扇的速度设置回之前的值，达到撤销的目的
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
