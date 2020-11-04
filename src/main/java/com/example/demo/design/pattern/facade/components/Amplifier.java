package com.example.demo.design.pattern.facade.components;

/**
 * 扩音器/功放
 * @auth Jacob
 * @date 2020/11/4 15:29
 */
public class Amplifier {

    private Tuner tuner; //调音器

    private DvdPlayer dvdPlayer; //dvd 播放器

    private CdPlayer cdPlayer; //cd 播放器

    public void on() {
        System.out.println("Amplifier is on!");
    }
    public void off() {
        System.out.println("Amplifier is off!");
    }
    public void setCd(CdPlayer cd) {
        this.cdPlayer = cd;
        System.out.println("Amplifier set cd!");
    }
    public void setDvd(DvdPlayer dvd) {
        this.dvdPlayer = dvd;
        System.out.println("Amplifier set dvd!");
    }
    public void setStereoSound() { //设置立体声
        System.out.println("Amplifier sound is set to stereo!");
    }
    public void setSurroundSound() { //设置环绕声
        System.out.println("Amplifier sound is set to surround!");
    }
    public void setTuner() {
        System.out.println("Amplifier set tuner!");
    }
    public void setVolume(int volume) {
        System.out.println("Amplifier volume is set to " + volume + "!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
