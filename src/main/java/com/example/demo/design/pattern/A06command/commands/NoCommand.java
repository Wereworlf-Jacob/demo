package com.example.demo.design.pattern.A06command.commands;


/**
 * 未设置命令操作的空命令对象
 * 默认遥控器上的都是命令对象，
 * 需要继承哪些电器的命令操作，再将命令插槽到遥控器上
 * @auth Jacob
 * @date 2020/11/3 15:25
 */
public class NoCommand implements Command {

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
