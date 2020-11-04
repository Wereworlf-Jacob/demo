package com.example.demo.design.pattern.facade.components;

/**
 * 调音器
 * @auth Jacob
 * @date 2020/11/4 15:13
 */
public class Tuner {

    private Amplifier amplifier; //音响功放

    public void on() {
        System.out.println("Tuner is on!");
    }

    public void off() {
        System.out.println("Tuner is off!");
    }

    public void setAm() {
        System.out.println("Tuner am is set to 12!");
    }

    public void setFm() {
        System.out.println("Tuner fm is set to 33!");
    }

    public void setFrequency() { //设置频率
        System.out.println("Tuner frequency is set to 11.11Hz !");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
