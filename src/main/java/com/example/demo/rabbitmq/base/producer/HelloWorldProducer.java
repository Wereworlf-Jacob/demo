package com.example.demo.rabbitmq.base.producer;

import com.example.demo.rabbitmq.base.RabbitmqConf;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @auth Jacob
 * @date 2020/9/3 15:22
 */
public class HelloWorldProducer {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RabbitmqConf.HOST);
        factory.setPort(RabbitmqConf.PORT);
        factory.setUsername(RabbitmqConf.ACCOUNT);
        factory.setPassword(RabbitmqConf.PWD);
        factory.setVirtualHost("/");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            /**
             * 声明队列方法queueDeclare参数：
             * String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
             * 参数明细：
             * queue: 队列名称
             * durable: 是否持久化，服务重启之后是否删除队列，true 持久化不删除，false 非持久化，会删除
             * exclusive: 是否排外的，有两个作用:
             * 一：当连接关闭时connection.close()该队列是否会自动删除；
             * 二：该队列是否是私有的private，如果不是排外的，
             *         可以使用两个消费者都访问同一个队列，没有任何问题，
             *         如果是排外的，会对当前队列加锁，其他通道channel是不能访问的，如果强制访问会报异常：
             *  true: 排外 false : 非排外
             *  autoDelete: 是否自动删除 true 自动删除 false 不自动删除
             *          当最后一个消费者断开连接之后队列是否自动被删除
             *  arguments：
             *          队列中的消息什么时候会自动被删除？
             *              Message TTL(x-message-ttl)：设置队列中的所有消息的生存周期(统一为整个队列的所有消息设置生命周期), 也可以在发布消息的时候单独为某个消息指定剩余生存时间,单位毫秒, 类似于redis中的ttl，生存时间到了，消息会被从队里中删除，注意是消息被删除，而不是队列被删除， 特性Features=TTL, 单独为某条消息设置过期时间AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties().builder().expiration(“6000”);
             *              channel.basicPublish(EXCHANGE_NAME, “”, properties.build(), message.getBytes(“UTF-8”));
             *              Auto Expire(x-expires): 当队列在指定的时间没有被访问(consume, basicGet, queueDeclare…)就会被删除,Features=Exp
             *              Max Length(x-max-length): 限定队列的消息的最大值长度，超过指定长度将会把最早的几条删除掉， 类似于mongodb中的固定集合，例如保存最新的100条消息, Feature=Lim
             *              Max Length Bytes(x-max-length-bytes): 限定队列最大占用的空间大小， 一般受限于内存、磁盘的大小, Features=Lim B
             *              Dead letter exchange(x-dead-letter-exchange)： 当队列消息长度大于最大长度、或者过期的等，将从队列中删除的消息推送到指定的交换机中去而不是丢弃掉,Features=DLX
             *              Dead letter routing key(x-dead-letter-routing-key)：将删除的消息推送到指定交换机的指定路由键的队列中去, Feature=DLK
             *              Maximum priority(x-max-priority)：优先级队列，声明队列时先定义最大优先级值(定义最大值一般不要太大)，在发布消息的时候指定该消息的优先级， 优先级更高（数值更大的）的消息先被消费,
             *              Lazy mode(x-queue-mode=lazy)： Lazy Queues: 先将消息保存到磁盘上，不放在内存中，当消费者开始消费的时候才加载到内存中
             *              Master locator(x-queue-master-locator)
             */
            channel.queueDeclare(RabbitmqConf.Hello_Queue, true, false, false, null);
            /**
             * 发送消息方法basicPublish参数：
             * String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body
             * 参数明细：
             *  exchange: 交换机名称，使用工作队列时，不指定交换机，会使用默认交换机，此时传 '' 空字符串
             *  routingKey： 当使用交换机时，路由模式下，需要执指定路由key，当不指定交换机的时候，该值为队列名称
             *  mandatory：true时，交换器无法根据自动的类型和路由键找到一个符合条件的队列，那么RabbitMq会调用Basic.Ruturn命令将消息返回给生产部
             *              为false时，出现上述情况消息被直接丢弃
             *             默认为false
             *  immediate：true，如果交换器在消息路由到队列时发现没有任何消费者，那么
             *               这个消息将不会存在队列，当与路由匹配的所有队列都没有消费者时，会Basic.Return返回给生产者
             *               默认为false
             *  props：BasicProperties 可以给消息设置属性
             *  body： 消息内容，字节数据
             */
            String msg = "你看看，欢迎使用本mq哦！";
            channel.basicPublish("", RabbitmqConf.Hello_Queue, null, msg.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
