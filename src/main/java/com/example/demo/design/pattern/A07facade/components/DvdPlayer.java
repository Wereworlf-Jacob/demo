package com.example.demo.design.pattern.A07facade.components;

/**
 * dvd播放器
 * @auth Jacob
 * @date 2020/11/4 15:16
 */
public class DvdPlayer {

    private Amplifier amplifier; //音响功放

    public void on() {
        System.out.println("Dvd is on!");
    }
    public void off() {
        System.out.println("Dvd is off!");
    }
    public void eject() { //弹出
        System.out.println("Dvd is eject!");
    }
    public void pause() {
        System.out.println("Dvd is pause!");
    }
    public void play() {
        System.out.println("Dvd is playing!");
    }
    public void play(String movie) {
        System.out.println("Dvd is playing" + movie + "!");
    }
    public void setSurroundAudio() { //设置环绕音效
        System.out.println("Dvd is surround audio!");
    }
    public void setTwoChannelAudio() {//设置双声道音频
        System.out.println("Dvd is two channel audio!");
    }
    public void stop() {
        System.out.println("Dvd is stopped!");
    }

}
