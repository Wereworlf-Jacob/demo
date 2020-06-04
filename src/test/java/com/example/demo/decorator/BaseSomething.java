package com.example.demo.decorator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName BaseSomething
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/3 9:39
 **/
public class BaseSomething implements ISomething {

    @Override
    public Map<String, String> doWork(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            map = new LinkedHashMap<>();
            map.put("init", "BaseSomething");
            System.out.println("init base work!");
            return map;
        }
        return map;
    }

}
