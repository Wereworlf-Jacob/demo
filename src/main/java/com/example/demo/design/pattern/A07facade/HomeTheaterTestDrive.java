package com.example.demo.design.pattern.A07facade;

import com.example.demo.design.pattern.A07facade.components.*;
import com.example.demo.design.pattern.A07facade.simpleinterface.HomeTheaterFacade;

/**
 * 家庭影院测试程序
 * @auth Jacob
 * @date 2020/11/4 15:47
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(), new Tuner(), new DvdPlayer(), new CdPlayer(),
                new Projector(), new Screen(), new TheaterLights(), new PopcornPopper());
        homeTheater.watchMovie("失落方舟的袭击者"); //Raiders of the lost Ark
        homeTheater.endMovie();
    }
}
