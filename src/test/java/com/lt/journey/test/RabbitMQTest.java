package com.lt.journey.test;

import com.lt.commons.utils.RabbitHelper;
import com.lt.journey.constant.ChannelConst;
import com.lt.journey.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
public class RabbitMQTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) ac.getBean("rabbitTemplate");
//        System.out.println(rabbitTemplate);
//        rabbitTemplate.convertAndSend(ChannelConst.Exchange_HOTEL,ChannelConst.ROUTING_HOTEL,"hello world!");
        RabbitHelper.convertAndSend(ChannelConst.EXCHANGE,ChannelConst.ROUTING_HOTEL,"hello world!");
    }
}
