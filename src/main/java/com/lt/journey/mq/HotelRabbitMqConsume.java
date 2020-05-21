package com.lt.journey.mq;

import com.alibaba.fastjson.JSONObject;
import com.lt.journey.constant.ChannelConst;
import com.lt.journey.model.HotelDes;
import com.lt.journey.service.HotelService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
@Component
public class HotelRabbitMqConsume {

    @Autowired
    private HotelService hotelService;

//    @Override
//    public void onMessage(Message message) {
//        System.out.println(hotelService);
//        try {
//            hotelService.addHotel(hotelDesList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void hotelConsumeHandler(String dataStr) {
        JSONObject dataObj = JSONObject.parseObject(dataStr);
        String hotelListStr = dataObj.getJSONArray("data").toString();

        List<HotelDes> hotelList = JSONObject.parseArray(hotelListStr, HotelDes.class);
        try {
            hotelService.addHotel(hotelList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
