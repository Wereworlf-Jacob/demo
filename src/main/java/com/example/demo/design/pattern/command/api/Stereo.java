package com.example.demo.design.pattern.command.api;

/**
 * @auth Jacob
 * @date 2020/8/31 17:36
 */
public class Stereo {

    private String position;

    public Stereo() {
        position = "";
    }
    public Stereo(String position) {
        this.position = position;
    }

    public void on() {
        System.out.println(position + " Stereo on!");
    }

    public void off() {
        System.out.println(position + " Stereo off!");
    }

    public void setCd() {
        System.out.println(position + " Stereo set cd!");
    }

    public void setDvd() {
        System.out.println(position + " Stereo set dvd!");
    }

    public void setRadio() {
        System.out.println(position + " stereo set radio!");
    }

    public void setVolume(int volume) {
        System.out.println(position + " stereo set volume " + volume + " !");
    }

}
