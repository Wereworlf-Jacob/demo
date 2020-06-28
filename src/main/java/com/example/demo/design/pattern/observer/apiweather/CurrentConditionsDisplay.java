package com.example.demo.design.pattern.observer.apiweather;

import com.example.demo.design.pattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName CurrentConditionsDisplay
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 11:02
 **/
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private String temperature;

    private String humdity;

    private String pressure;

    @Override
    public void displayed() {
        System.out.println("\"目前状况\"布告");
        System.out.println(String.format("temperature is %s; hudity is %s; pressure is %s;", temperature, humdity, pressure));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherSubject = (WeatherData) o;
            temperature = weatherSubject.getTemperature();
            humdity = weatherSubject.getHumidity();
            pressure = weatherSubject.getPressure();
            displayed();
        }
    }
}
