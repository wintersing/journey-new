package com.lt.journey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Title: <br>
 * Description: 异步存储可选方式：
 *              redis消息队列：RedisMQConfig
 *              RabbitMQ消息队列：RabbitMQConfig
 *              RabbitMQ注解版：AnnotationRabbitMQConfig
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@Configuration
@Import(value = {RedisConfig.class,RedisMQConfig.class,AnnotationRabbitMQConfig.class})
public class MainConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
