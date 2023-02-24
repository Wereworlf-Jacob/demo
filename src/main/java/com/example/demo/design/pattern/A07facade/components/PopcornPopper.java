package com.example.demo.design.pattern.A07facade.components;

/**
 * 爆米花机
 * @auth Jacob
 * @date 2020/11/4 15:27
 */
public class PopcornPopper {

    public void on() {
        System.out.println("Popcorn popper is on!");
    }
    public void off() {
        System.out.println("Popcorn popper is off!");
    }
    public void pop() { //爆米花
        System.out.println("Popcorn popper is pop!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
