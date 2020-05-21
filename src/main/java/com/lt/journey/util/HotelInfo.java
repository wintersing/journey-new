package com.lt.journey.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.TypeReference;
import com.lt.commons.utils.*;
import com.lt.journey.constant.ChannelConst;
import com.lt.journey.model.Hotel;
import com.lt.journey.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.journey.exception.MessageException;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.HotelParam;

import static com.lt.journey.constant.ChannelConst.CHANNEL_HOTEL;
import static com.lt.journey.constant.ChannelConst.EXPIRE_CHANNEL_HOTEL;

@Component
public class HotelInfo {

    private static final String url = CommonsUtils.getProperty("Hotel_Url");
    private static final String apikey = CommonsUtils.getProperty("IDataAPI_APIKEY");

    private static Map<String, Object> map;

    private static HotelService hotelService;

    @Autowired
    public void setHotelService(HotelService hotelService) {
        HotelInfo.hotelService = hotelService;
    }

    public static List<Hotel> getHotelInfo(HotelParam hotelParam, Model model) throws MessageException {
        JSONObject dataObj = new JSONObject();
        List<Hotel> hotelList = new ArrayList<>();

//      先从Redis中拿数据
        Map<String, Object> map1 = (Map) RedisHelper.getMapAll("hotel:" + spliceParam(hotelParam));
        if (map1.size() > 0) {
            Set<String> keySet = map1.keySet();
            for (String key : keySet) {
                dataObj.put(key, map1.get(key));
            }
            String hotelListStr = dataObj.getJSONArray("data").toString();
            hotelList = JSONObject.parseArray(hotelListStr, Hotel.class);
        }

        //查数据库
        if (dataObj.size() == 0 && hotelParam.getLat() == null && hotelParam.getLon() == null) {
            hotelList = hotelService.findHotel(hotelParam);
        }

        //调用第三方 API
        if (hotelList.size() == 0) {
            String dataStr = HttpRequest.sendGet(url, spliceParam(hotelParam));
            if (null == dataStr) {
                throw new MessageException("Search No Result");
            } else {
                //处理结果
                dataObj = JSONObject.parseObject(dataStr);
                String retcode = dataObj.getString("retcode");
                if ("100002".equals(retcode)) {
                    throw new MessageException("Search No Result");
                }
                final String hotelListStr = dataObj.getJSONArray("data").toString();

                if (hotelList.size() == 0) {
                    hotelList = JSONObject.parseArray(hotelListStr, Hotel.class);
                }
                RedisHelper.putMapAll("hotel:" + spliceParam(hotelParam), JSONObject.parseObject(dataStr, new TypeReference<Map<String, Object>>() {
                }));
                //Redis发布订阅
//                RedisHelper.convertAndSend(CHANNEL_HOTEL,dataStr);
                //RabbitMQ
                RabbitHelper.convertAndSend(ChannelConst.EXCHANGE, ChannelConst.ROUTING_HOTEL, dataStr);
                //线程池
//                ExecutorService executorService = ThreadPoolExecutor.newThreadPool();
//                executorService.execute(() -> {
//                    List<HotelDes> hotelDesList = JSONObject.parseArray(hotelListStr, HotelDes.class);
//                    hotelService.addHotel(hotelDesList);
////                    ThreadPoolExecutor.shutdown();
//                });
            }
        }

        String pageToken = null;
        boolean hasNext = false;
        if (dataObj.size() > 0) {
            pageToken = dataObj.getString("pageToken");
            hasNext = dataObj.getBoolean("hasNext");
        }
        StringBuffer urlParam = new StringBuffer();
        urlParam.append("pageToken=").append(pageToken);
        for (String key : map.keySet()) {
            if (map.get(key) != "" && map.get(key) != null && !key.equals("pageToken")) {
                urlParam.append("&").append(key).append("=").append(map.get(key));
            }
        }

        //将数据放入model中
        if (model != null) {
            model.addAttribute("hotelList", hotelList);
            model.addAttribute("hotelParam", hotelParam);

            if (hasNext) {
                model.addAttribute("hasNext", "1");
            } else {
                model.addAttribute("hasNext", "0");
            }
            model.addAttribute("urlParam", urlParam);
        }

        return hotelList;
    }

    private static String spliceParam(HotelParam hotelParam) {
        StringBuffer param = new StringBuffer();
        param.append("apikey=").append(apikey);
        Map<String, Object> map = CommonsUtils.beantoMap(hotelParam);
        for (String key : map.keySet()) {
            if (map.get(key) != "" && map.get(key) != null) {
                param.append("&").append(key).append("=").append(map.get(key));
            }
        }
        HotelInfo.map = map;
        return param.toString();
    }

    public static HotelDes getHotelDesInfo(HotelParam hotelParam) {
        HotelDes hotelDes = hotelService.findHotel(hotelParam.getId());

        if (hotelDes == null) {
            //处理返回结果
            String dataStr = HttpRequest.sendGet(url, spliceParam(hotelParam));
            JSONObject dataObj = JSON.parseObject(dataStr);
            JSONArray hotelList = dataObj.getJSONArray("data");

            for (Object obj_ : hotelList) {
                if (obj_ instanceof JSONObject) {
                    JSONObject obj = (JSONObject) obj_;
                    String id = obj.getString("id");
                    if (hotelParam.getId().equals(id)) {
                        hotelDes = JSONObject.parseObject(obj + "", HotelDes.class);
                        break;
                    }
                }
            }
        }
        return hotelDes;
    }

}