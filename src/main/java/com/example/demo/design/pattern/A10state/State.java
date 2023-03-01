package com.example.demo.design.pattern.A10state;

/**
 * 状态接口
 * @auth Jacob
 * @date 2023/2/24 17:19
 */
public interface State {

    //投入25分钱
    void insertQuarter();
    //退回25分钱
    void ejectQuater();
    //转动曲柄
    boolean turnCrank();
    //分配糖果
    void dispense();
}
