package com.example.demo.design.pattern.observer.apiweather;

import java.util.Observable;
import java.util.Observer;
/**
 * @ClassName ForecastDisplay
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/24 17:07
 **/
public class ForecastDisplay implements Observer {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg){
        if(observable instanceof Object){
            Object weatherData = observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.hashCode();
            disply();
        }
    }

    public void disply(){

    }

}
