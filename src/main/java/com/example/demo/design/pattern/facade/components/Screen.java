package com.example.demo.design.pattern.facade.components;

/**
 * 屏幕
 * @auth Jacob
 * @date 2020/11/4 15:21
 */
public class Screen {

    public void up() {
        System.out.println("Screen is up!");
    }
    public void down() {
        System.out.println("Screen is down!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
