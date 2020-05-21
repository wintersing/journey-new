package com.lt.journey.mq;

import com.alibaba.fastjson.JSONObject;
import com.lt.journey.config.RedisConfig;
import com.lt.journey.model.HotelDes;
import com.lt.journey.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@Component
public class HotelMessageConsume implements MessageListener {

    @Autowired
    private HotelService hotelService;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String dataStr = (String) RedisConfig.getJackson2JsonRedisSerializer().deserialize(message.getBody());
        JSONObject dataObj = JSONObject.parseObject(dataStr);
        String hotelListStr = dataObj.getJSONArray("data").toString();

        List<HotelDes> hotelList = JSONObject.parseArray(hotelListStr, HotelDes.class);
        hotelService.addHotel(hotelList);
    }
}
