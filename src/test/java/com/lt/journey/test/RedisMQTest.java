package com.lt.journey.test;

import com.lt.journey.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import static com.lt.journey.constant.ChannelConst.*;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */

public class RedisMQTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisTemplate<String,Object> redisTemplate = (RedisTemplate) ac.getBean("redisTemplate");
        String channel1 = CHANNEL_HOTEL; String channel2 = CHANNEL_JOURNEY;
        User user = new User();
        user.setUsername("刘大");
        user.setPassword("222222");
        user.setPhone("18675830623");

        User user2 = new User();
        user2.setUsername("李二");
        user2.setPassword("111111");
        user2.setPhone("17856232365");

        redisTemplate.convertAndSend(channel1,user2);
        redisTemplate.convertAndSend(channel2,user);
    }
}
