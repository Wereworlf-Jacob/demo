package com.example.demo.design.pattern.observer.weather;

/**
 * @ClassName Subject
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/28 10:20
 **/
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObjservers();

}
