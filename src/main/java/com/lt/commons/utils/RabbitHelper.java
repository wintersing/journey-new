package com.lt.commons.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@Component
public class RabbitHelper {

    private static RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){
        RabbitHelper.rabbitTemplate = rabbitTemplate;
    }

    public static void convertAndSend(String exchange,String routingKey, Object message){
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey,message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
