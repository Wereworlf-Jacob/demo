package com.example.demo.rabbitmq.springboot;

import com.example.demo.rabbitmq.springboot.producer.RouteTyeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth Jacob
 * @date 2020/9/4 13:43
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RouteTyeProducer routeTyeProducer;

    @GetMapping("/send")
    public Map sendMsg() {
        routeTyeProducer.sendMsg();
        Map<String, String> map = new HashMap<>();
        map.put("msg=", "发送成功");
        return map;
    }
}
