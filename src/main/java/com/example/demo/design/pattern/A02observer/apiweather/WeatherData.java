package com.example.demo.design.pattern.A02observer.apiweather;

import java.util.Observable;

/**
 * @ClassName WeatherData
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 11:01
 **/
public class WeatherData extends Observable {

    public String getTemperature(){
        return "38";
    }

    public String getHumidity(){
        return "40";
    }

    public String getPressure(){
        return "104";
    }

    public void mentsChanged(){
        setChanged(); //使用jdk内置观察者模式，如果不设置changed，是不会通知观察者的。
        notifyObservers();
    }

}
