package com.example.demo.design.pattern.command.api;

/**
 * @auth Jacob
 * @date 2020/8/31 17:37
 */
public class Light {

    private String position;

    public Light() {
        this.position = "";
    }

    public Light(String position) {
        this.position = position;
    }

    public void on() {
        System.out.println(position + " light on!");
    }
    public void off() {
        System.out.println(position + " light off!");
    }
}
