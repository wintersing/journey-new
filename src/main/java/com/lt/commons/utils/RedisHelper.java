package com.lt.commons.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@Component
public class RedisHelper {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisHelper.redisTemplate = redisTemplate;
    }

    public static void setValue(String key, Object obj) {
        try {
            redisTemplate.opsForValue().set(key, obj, 60 * 6L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getValue(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void putMapAll(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            redisTemplate.expire(key, 60 * 10L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getMapAll(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void convertAndSend(String channel, Object message) {
        try {
            redisTemplate.convertAndSend(channel, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lPush(String channel, Object message) {
        try {
            redisTemplate.opsForList().leftPush(channel, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object brPop(String key) {
        return brPop(key, 60, TimeUnit.SECONDS);
    }

    public static Object brPop(String key, long timeout, TimeUnit timeUnit) {
        try {
            return redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean expire(String key, long timeout, TimeUnit timeUnit){
        try {
            return redisTemplate.expire(key,timeout,timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
