package com.lt.journey.config;

import com.lt.journey.mq.HotelMessageConsume;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import static com.lt.journey.constant.ChannelConst.CHANNEL_HOTEL;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
public class RedisMQConfig {


    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * MessageListenerAdapter 表示监听频道的不同订阅者
     *
     * @param redisConnectionFactory
     * @param hotelListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter hotelListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        //订阅频道
        container.addMessageListener(hotelListenerAdapter, new PatternTopic(CHANNEL_HOTEL));
        //序列化
        container.setTopicSerializer(RedisConfig.getJackson2JsonRedisSerializer());
        return container;
    }

    @Bean
    MessageListenerAdapter hotelListenerAdapter(HotelMessageConsume receiver) {
        return new MessageListenerAdapter(receiver);
    }
}
