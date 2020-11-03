package com.example.demo.design.pattern.command.commands;

/**
 * 命令对象
 * @auth Jacob
 * @date 2020/8/31 18:14
 */
public interface Command {
    //有一个执行的方法
    void execute();
    //增加撤销的命令
    void undo();
}
