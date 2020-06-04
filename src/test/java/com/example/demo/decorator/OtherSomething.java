package com.example.demo.decorator;

import java.util.Map;

/**
 * @ClassName OtherSomething
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/3 9:50
 **/
public class OtherSomething implements ISomething {

    private ISomething iSomething;

    public OtherSomething(ISomething iSomething) {
        this.iSomething = iSomething;
    }

    @Override
    public Map<String, String> doWork(Map<String, String> map) {
        map = iSomething.doWork(map);
        map.put("others", "OtherSomething");
        System.out.println("othersome");
        return map;
    }
}
