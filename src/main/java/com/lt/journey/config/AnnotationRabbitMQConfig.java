package com.lt.journey.config;

import com.lt.journey.constant.ChannelConst;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

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
public class AnnotationRabbitMQConfig {

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
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}
