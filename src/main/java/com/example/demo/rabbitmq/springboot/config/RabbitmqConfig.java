package com.example.demo.rabbitmq.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auth Jacob
 * @date 2020/9/4 10:16
 */
@Configuration
public class RabbitmqConfig {

    public static final String EXCHANGE = "demo";

    public static final String AJ_QUEUE = "aj";

    public static final String PEO_QUEUE = "peo";

    public static final String RK_AJ = "rk.aj";

    public static final String RK_PEO = "rk.peo";

    public static final String RK_ALL = "rk.all";

    @Bean(EXCHANGE)
    public DirectExchange direct() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean(AJ_QUEUE)
    public Queue aj () {
        return new Queue(AJ_QUEUE);
    }

    @Bean(PEO_QUEUE)
    public Queue peo () {
        return new Queue(PEO_QUEUE);
    }

    @Bean
    public Binding bingding1 (@Qualifier(EXCHANGE) DirectExchange direct,
                              @Qualifier(AJ_QUEUE) Queue queue) {
        BindingBuilder.bind(queue).to(direct).with(RK_ALL);
        return BindingBuilder.bind(queue).to(direct).with(RK_AJ);
    }

    @Bean
    public Binding bingding2 (@Qualifier(EXCHANGE) DirectExchange direct,
                              @Qualifier(PEO_QUEUE) Queue queue) {
        BindingBuilder.bind(queue).to(direct).with(RK_ALL);
        return BindingBuilder.bind(queue).to(direct).with(RK_PEO);
    }

}
