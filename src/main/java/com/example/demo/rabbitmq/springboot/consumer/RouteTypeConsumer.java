package com.example.demo.rabbitmq.springboot.consumer;

import com.example.demo.rabbitmq.springboot.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @auth Jacob
 * @date 2020/9/4 13:26
 */
@Service
public class RouteTypeConsumer {

    @RabbitListener(queues = RabbitmqConfig.AJ_QUEUE)
    public void receiveAJ(String msg){
        System.out.println("receive msg AJ: " + msg);
    }

    @RabbitListener(queues = RabbitmqConfig.PEO_QUEUE)
    public void receivePeo(String msg) {
        System.out.println("receive msg PEO: " + msg);
    }

}
