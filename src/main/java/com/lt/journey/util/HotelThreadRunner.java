package com.lt.journey.util;

import com.alibaba.fastjson.JSONObject;
import com.lt.journey.model.HotelDes;
import com.lt.journey.service.HotelService;
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
//@Component
public class HotelThreadRunner implements Runnable {

//    @Autowired
    private HotelService hotelService;

    private JSONObject jsonObject;

    public HotelThreadRunner(JSONObject obj) {
        this.jsonObject = obj;
    }

    @Override
    public void run() {
        String hotelListStr = jsonObject.getJSONArray("data").toString();
        List<HotelDes> hotelList = JSONObject.parseArray(hotelListStr, HotelDes.class);
        hotelService.addHotel(hotelList);
    }
}
