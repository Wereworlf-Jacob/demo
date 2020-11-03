package com.example.demo.design.pattern.command.api;

/**
 * @auth Jacob
 * @date 2020/8/31 17:37
 */
public class TV {

    private String location;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is on!");
    }

    public void off() {
        System.out.println(location + " TV is off!");
    }
}
