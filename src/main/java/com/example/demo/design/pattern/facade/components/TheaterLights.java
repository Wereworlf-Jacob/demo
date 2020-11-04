package com.example.demo.design.pattern.facade.components;

/**
 * 影院灯光
 * @auth Jacob
 * @date 2020/11/4 15:25
 */
public class TheaterLights {

    public void on() {
        System.out.println("Theater lights is on!");
    }
    public void off() {
        System.out.println("Theater lights is off!");
    }
    public void dim(int percent) { //设置昏暗光线
        System.out.println("Theater lights is dim to " + percent + "%!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
