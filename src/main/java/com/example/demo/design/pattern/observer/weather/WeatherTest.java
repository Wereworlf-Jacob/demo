package com.example.demo.design.pattern.observer.weather;

/**
 * @ClassName WeatherTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 10:56
 **/
public class WeatherTest {

    public static void main(String[] args) {
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        WeatherSubject weatherSubject = new WeatherSubject();
        weatherSubject.registerObserver(currentConditionsDisplay);
        weatherSubject.registerObserver(new ForecastDisplay());
        weatherSubject.registerObserver(new StaticsDisplay());
        weatherSubject.mentsChanged();
        weatherSubject.removeObserver(currentConditionsDisplay);
        weatherSubject.mentsChanged();
    }

}
