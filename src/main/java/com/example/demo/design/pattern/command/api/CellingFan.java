package com.example.demo.design.pattern.command.api;

import javax.annotation.processing.SupportedAnnotationTypes;

/**
 * @auth Jacob
 * @date 2020/8/31 17:38
 */
public class CellingFan {

    //当设置吊扇的转速之后，撤销按钮需要记录转速状态，这个状态是在对象中的
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private String position;
    int speed;

    public CellingFan() {
        position = "";
    }

    public CellingFan(String position) {
        this.position = position;
        speed = OFF;
    }

    public void on() {
        System.out.println(position + " celling fan on!");
    }
    public void off() {
        speed = OFF;
        System.out.println(position + " celling fan off!");
    }
    public void high() {
        //设置高转速
        speed = HIGH;
        System.out.println(position + " celling fan speed high!");
    }
    public void medium() {
        //设置中转速
        speed = MEDIUM;
        System.out.println(position + " celling fan speed medium!");
    }
    public void low() {
        //设置低转速
        speed = LOW;
        System.out.println(position + " celling fan speed low!");
    }

    public int getSpeed() {
        return speed;
    }
}
