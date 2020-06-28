package com.example.demo.design.pattern.observer.apiweather;

/**
 * @ClassName WeatherApiTest
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 11:06
 **/
public class WeatherApiTest {

    public static void main(String[] args) {
        //使用jdk内置的观察者模式，缺点在于其主体是一个对象，耦合性较高，不是面向接口编程
        WeatherData weatherData = new WeatherData();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        weatherData.addObserver(new CurrentConditionsDisplay());
        weatherData.addObserver(forecastDisplay);
        weatherData.addObserver(new StaticsDisplay());
        weatherData.mentsChanged();
        forecastDisplay.remove();//使观察者持有主题，便于观察者主动通知主题，撤销观察操作
        weatherData.mentsChanged();
    }

}
