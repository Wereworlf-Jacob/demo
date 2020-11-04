package com.example.demo.design.pattern.facade.components;

/**
 * cd 播放器
 * @auth Jacob
 * @date 2020/11/4 15:20
 */
public class CdPlayer {

    private Amplifier amplifier; //音响功放

    public void on() {
        System.out.println("Cd is on!");
    }
    public void off() {
        System.out.println("Cd is off!");
    }
    public void eject() { //弹出
        System.out.println("Cd is eject!");
    }
    public void pause() {
        System.out.println("Cd is pause!");
    }
    public void play() {
        System.out.println("Cd is playing!");
    }
    public void play(String music) {
        System.out.println("Cd is playing" + music + "!");
    }
    public void stop() {
        System.out.println("Cd is stopped!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
