package com.lt.journey.mq;

import com.alibaba.fastjson.JSONObject;
import com.lt.journey.constant.ChannelConst;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.PlacesDes;
import com.lt.journey.service.HotelService;
import com.lt.journey.service.PlacesService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AnnotationHotelRabbitMqConsume {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PlacesService placesService;

    @RabbitListener(queues = ChannelConst.QUEUE_HOTEL)
    public void hotelConsumeHandler(String dataStr) {
        try {
//            JSONObject dataObj = JSONObject.parseObject(dataStr);
//            String hotelListStr = dataObj.getJSONArray("data").toString();
//
//            List<HotelDes> hotelList = JSONObject.parseArray(hotelListStr, HotelDes.class);
            List<HotelDes> hotelList = parse(dataStr, HotelDes.class);
            hotelService.addHotel(hotelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = ChannelConst.QUEUE_PLACES)
    public void placesConsumeHandler(String dataStr) {
//        JSONObject dataObj = JSONObject.parseObject(dataStr);
//        String placesListStr = dataObj.getJSONArray("data").toString();
//
//        List<PlacesDes> hotelList = JSONObject.parseArray(placesListStr, PlacesDes.class);
        try {
            List<PlacesDes> hotelList = parse(dataStr, PlacesDes.class);
            placesService.addPlaces(hotelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static  <T> List<T> parse(String dataStr, Class<T> tClass){
        JSONObject dataObj = JSONObject.parseObject(dataStr);
        String placesListStr = dataObj.getJSONArray("data").toString();

        List<T> hotelList = JSONObject.parseArray(placesListStr, tClass);
        return hotelList;
    }
}
