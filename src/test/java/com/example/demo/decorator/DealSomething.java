package com.example.demo.decorator;

import java.util.Map;

/**
 * @ClassName DealSomething
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/3 9:44
 **/
public class DealSomething implements ISomething {

    private ISomething iSomething;

    public DealSomething(ISomething iSomething) {
        this.iSomething = iSomething;
    }

    @Override
    public Map<String, String> doWork(Map<String, String> map) {
        map = iSomething.doWork(map);
        System.out.println("I'll do something");
        map.put("deal", "DealSomething");
        return map;
    }
}
