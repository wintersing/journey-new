package com.lt.journey.config;

import com.lt.journey.constant.ChannelConst;
import com.lt.journey.mq.HotelRabbitMqConsume;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.lt.journey.constant.ChannelConst.ROUTING_HOTEL;
import static com.lt.journey.constant.ChannelConst.ROUTING_PLACES;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
//@Configuration
//@PropertySource("classpath:application.properties")//applicationContext.xml中已引入，可不用配置
public class RabbitMQConfig {

    @Value("${rabbit.address}")
    private String address;

    @Value("${rabbit.username}")
    private String username;

    @Value("${rabbit.password}")
    private String password;

    @Value("${rabbit.virtualHost}")
    private String virtualHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(address);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        //创建队列
        Queue queue = new Queue(ChannelConst.QUEUE_HOTEL);
        admin.declareQueue(queue);
        Queue queue1 = new Queue(ChannelConst.QUEUE_PLACES);
        admin.declareQueue(queue1);
        //创建topic类型的交换机
        TopicExchange exchange = new TopicExchange(ChannelConst.EXCHANGE);
        admin.declareExchange(exchange);
        //交换机和队列绑定，路由规则为匹配"routing."开头的路由键
        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(ROUTING_HOTEL));
        admin.declareBinding(BindingBuilder.bind(queue1).to(exchange).with(ROUTING_PLACES));

        admin.setAutoStartup(true);
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory,MessageListenerAdapter messageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setMessageListener(messageListenerAdapter);
        container.setQueueNames(ChannelConst.QUEUE_HOTEL);
        return container;
    }

    @Bean
    public MessageListenerAdapter hotelListenerAdapter(HotelRabbitMqConsume hotelRabbitMqConsume){

        MessageListenerAdapter adapter = new MessageListenerAdapter(hotelRabbitMqConsume);
        adapter.setDefaultListenerMethod("hotelConsumeHandler");
        adapter.setMessageConverter(new Jackson2JsonMessageConverter());
        return adapter;
    }

}

