package com.example.demo.rabbitmq.base.consumer;

import com.example.demo.rabbitmq.base.RabbitmqConf;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @auth Jacob
 * @date 2020/9/3 15:22
 */
public class HelloWorldConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitmqConf.HOST);
        factory.setPort(RabbitmqConf.PORT);
        factory.setUsername(RabbitmqConf.ACCOUNT);
        factory.setPassword(RabbitmqConf.PWD);
        factory.setVirtualHost("/");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //避免两个服务在不同模块情况下，一个服务启动另外一个未启动，导致队列未生命的情况，在消费者模块中，同样也对队列进行一个生命
        //同时，消费着生命的队列,durable等其他属性，要与生产者的生命一致，否则会报错，因为属性不一致也说明是不同的队列
        channel.queueDeclare(RabbitmqConf.Hello_Queue, true, false, false, null);
        /**
         * 消费者，来消费一条消息 basicConsume方法参数
         * String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean exclusive, Map<String, Object> arguments, DeliverCallback deliverCallback, CancelCallback cancelCallback, ConsumerShutdownSignalCallback shutdownSignalCallback
         * String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean exclusive, Map<String, Object> arguments, Consumer callback
         * 详细参数说明：1、
         * queue：消费哪个队列的数据
         * autoAck: 是否自动回复，当设置为true时，消息及时未处理完也会先回复已消费
         * consumerTag：消费者标签， 用来区分多个消费者
         * noLocal：设置为true，表示 不能将同一个Conenction中生产者发送的消息传递给这个Connection中 的消费者
         * exclusive 是否排他
         * arguments 消费者的参数
         * deliverCallback 发送的回调方法
         * cancelCallback： 关闭的回调方法
         * shutdownSignalCallback
         *
         * 2、
         * Consumer callback: 消费者的回调方法
         */
        channel.basicConsume(RabbitmqConf.Hello_Queue, true, new DefaultConsumer(channel){
            /**
             * 创建一个默认的消费者，进行回调，然后重写handleDelivery方法来处理消息的消费
             * @param consumerTag 消费者标签
             * @param envelope 消息产生的环境，能拿到消息发送情况的信息比如路由,路由key等
             * @param properties 消息设置的属性，生产者发送消息的时候，设置的值
             * @param body 消息内容
             * @author Jacob
             * @date 2020/9/3 16:13
             * @return void
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("我拿到消息啦！msg: " + new String(body, "utf-8") + ";");
            }
        });
    }
}
