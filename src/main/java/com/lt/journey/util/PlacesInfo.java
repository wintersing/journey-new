package com.lt.journey.util;

import java.util.*;

import com.alibaba.fastjson.TypeReference;
import com.lt.commons.utils.RabbitHelper;
import com.lt.commons.utils.RedisHelper;
import com.lt.journey.constant.ChannelConst;
import com.lt.journey.model.*;
import com.lt.journey.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.commons.utils.CommonsUtils;
import com.lt.commons.utils.HttpRequest;
import com.lt.journey.exception.MessageException;

@Component
public class PlacesInfo {

    private static final String url = CommonsUtils.getProperty("Journey_Url");
    private static final String apikey = CommonsUtils.getProperty("IDataAPI_APIKEY");

    private static PlacesService placesService;

    @Autowired
    public void setPlacesService(PlacesService placesService) {
        PlacesInfo.placesService = placesService;
    }

    public static List<Places> getPlacesInfo(PlacesParam placesParam, Model model) throws MessageException {
        JSONObject dataObj = new JSONObject();
        List<Places> placesList = new ArrayList<>();

        //查redis
        Map<String, Object> map = (Map) RedisHelper.getMapAll("places:" + spliceParam(placesParam));
        if (map.size() > 0) {
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                dataObj.put(key, map.get(key));
            }
            String hotelListStr = dataObj.getJSONArray("data").toString();
            placesList = JSONObject.parseArray(hotelListStr, Places.class);
        }

        //查数据库
        if (placesList.size() == 0) {
            placesList = placesService.findPlaces(placesParam);
            dataObj.fluentPut("pageToken",1).fluentPut("hasNext",false);
        }

        //调用第三方 API
        if (placesList.size() == 0) {
            String dataStr = HttpRequest.sendGet(url, spliceParam(placesParam));
            dataObj = JSON.parseObject(dataStr);
            String retcode = dataObj.getString("retcode");
            if ("100002".equals(retcode)) {
                throw new MessageException("Search No Result");
            }
            String placesListStr = dataObj.getJSONArray("data").toJSONString();
            placesList = JSONObject.parseArray(placesListStr, Places.class);

            RedisHelper.putMapAll("places:" + spliceParam(placesParam), JSONObject.parseObject(dataStr, new TypeReference<Map<String, Object>>() {
            }));

            //RabbitMQ
            RabbitHelper.convertAndSend(ChannelConst.EXCHANGE, ChannelConst.ROUTING_PLACES, dataStr);

        }


        if (model != null) {
            model.addAttribute(placesList);
            model.addAttribute("pageToken", dataObj.getString("pageToken"));
            if (dataObj.getBooleanValue("hasNext")) {
                model.addAttribute("hasNext", "1");
            } else {
                model.addAttribute("hasNext", "0");
            }
            model.addAttribute(placesParam);
        }

        return placesList;
    }

    private static String spliceParam(PlacesParam placesParam) {
        StringBuffer param = new StringBuffer();
        param.append("apikey=" + apikey);
        Map<String, Object> map = CommonsUtils.beantoMap(placesParam);
        for (String key : map.keySet()) {
            if (map.get(key) != "" && map.get(key) != null) {
                param.append("&" + key + "=" + map.get(key));
            }
        }
        return param.toString();
    }

    public static PlacesDes getPlacesSingleInfo(PlacesParam placesParam) {

        //发送请求
        String ret = HttpRequest.sendGet(url, spliceParam(placesParam));
        JSONObject dataObj = JSON.parseObject(ret);
        String retcode = dataObj.getString("retcode");

        if (retcode.equals("100002")) {
            return null;
        }

        JSONArray placesList = dataObj.getJSONArray("data");

        PlacesDes placesDes = null;
        for (Object obj_ : placesList) {
            if (obj_ instanceof JSONObject) {
                JSONObject obj = (JSONObject) obj_;
                String id = obj.getString("id");
                if (placesParam.getId().equals(id)) {
                    placesDes = JSONObject.parseObject(obj + "", PlacesDes.class);
                    break;
                }
            }
        }

//		model.addAttribute("pageToken", dataObj.getString("pageToken"));
//		model.addAttribute("retcode", dataObj.getString("retcode"));
//		model.addAttribute(placesParam);
//		if (dataObj.getBooleanValue("hasNext") == true) {
//			model.addAttribute("hasNext", "1");
//		} else {
//			model.addAttribute("hasNext", "0");
//		}

        return placesDes;
    }

}