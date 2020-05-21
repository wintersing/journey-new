package com.lt.journey.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedisObj() {
        System.out.println(redisTemplate);
        Map<String, Object> properties = new HashMap<>();
        properties.put("123", "hello");
        properties.put("abc", 456);

        redisTemplate.opsForHash().putAll("hash", properties);

        Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        System.out.println("ans: " + ans);
    }
}
