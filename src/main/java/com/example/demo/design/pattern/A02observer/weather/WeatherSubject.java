package com.example.demo.design.pattern.A02observer.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WeatherSubject
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 10:33
 **/
public class WeatherSubject extends WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObjservers() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }
    }

    @Override
    public void mentsChanged() {
        super.mentsChanged();
        notifyObjservers();
    }
}
