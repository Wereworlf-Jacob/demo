package com.example.demo.design.pattern.A06command.commands;

/**
 * 编写一个宏命令接口，来定义执行一组命令
 * @auth Jacob
 * @date 2020/11/3 16:55
 */
public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
