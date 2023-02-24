package com.example.demo.design.pattern.A02observer.apiweather;

import com.example.demo.design.pattern.A02observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName ForecastDisplay
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 11:02
 **/
public class ForecastDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private String temperature;

    private String humdity;

    private String pressure;

    @Override
    public void displayed() {
        System.out.println("\"天气预报\"布告");
        System.out.println(String.format("temperature is %s; hudity is %s; pressure is %s;", temperature, humdity, pressure));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            weatherData = (WeatherData) o;
            temperature = weatherData.getTemperature();
            humdity = weatherData.getHumidity();
            pressure = weatherData.getPressure();
            displayed();
        }
    }

    public void remove(){
        weatherData.deleteObserver(this);
    }
}
