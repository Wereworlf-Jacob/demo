package com.example.demo.decorator;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @ClassName Test
 * @Description
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/3 9:45
 **/
public class Test {

    public static void main(String[] args) {
        Map<String, String> map = null;
        boolean flag = false;
        ISomething iSomething = new BaseSomething();
        iSomething = new OtherSomething(iSomething);
        iSomething = new DealSomething(iSomething);
        System.out.println(JSONObject.toJSONString(iSomething.doWork(map)));
    }

}
