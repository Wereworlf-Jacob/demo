package com.example.demo.design.pattern.A07facade.components;

/**
 * 放映机/投影仪
 * @auth Jacob
 * @date 2020/11/4 15:22
 */
public class Projector {

    private DvdPlayer dvdPlayer;

    public void on() {
        System.out.println("Projector is on!");
    }

    public void off() {
        System.out.println("Projector is off!");
    }

    public void tvMode() {
        System.out.println("Projector tv mode is set to 4K!");
    }

    public void wideScreenMode() {
        System.out.println("Projector set to wide screen mode!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
