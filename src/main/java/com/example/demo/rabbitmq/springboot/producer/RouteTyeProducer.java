package com.example.demo.rabbitmq.springboot.producer;

import com.example.demo.rabbitmq.springboot.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auth Jacob
 * @date 2020/9/4 13:26
 */
@Service
public class RouteTyeProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg() {
        String msg = "发送一个广播所有的消息";
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.RK_ALL, msg);

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.RK_AJ, "发送一个案件信息");

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.RK_PEO, "发送一个人员信息");
    }
}
