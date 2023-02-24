package com.example.demo.design.pattern.A02observer.weather;

import com.example.demo.design.pattern.A02observer.DisplayElement;

/**
 * @ClassName ForecastDisplay
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 10:45
 **/
public class ForecastDisplay implements Observer, DisplayElement {

    private String temperature;

    private String humdity;

    private String pressure;

    @Override
    public void displayed() {
        System.out.println("\"天气预报\"布告");
        System.out.println(String.format("temperature is %s; hudity is %s; pressure is %s;", temperature, humdity, pressure));
    }

    @Override
    public void update(Object subject, Object args) {
        if (subject instanceof WeatherSubject){
            WeatherSubject weatherSubject = (WeatherSubject) subject;
            temperature = weatherSubject.getTemperature();
            humdity = weatherSubject.getHumidity();
            pressure = weatherSubject.getPressure();
            displayed();
        }
    }
}
