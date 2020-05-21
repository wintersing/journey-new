package com.lt.journey.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.journey.exception.MessageException;
import com.lt.journey.model.Hotel;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.HotelParam;
import com.lt.journey.model.News;
import com.lt.journey.service.HotelService;
import com.lt.journey.service.NewsService;
import com.lt.journey.util.HotelInfo;

@Controller
@RequestMapping("/")
public class HotelController {

    private static final int pageSize = 9;

    private static final int pageSize_news = 20;

//	private static final String catLabel2_小吃 = CatLabel2.小吃.toString();

    @Autowired
    private HotelService hotelService;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/hotel")
    public String hotelView(Model model, String pageToken, HttpServletRequest req) {

        if (pageToken == null || pageToken == "") {
            pageToken = "1";
        }

        //酒店
        List<Hotel> hotelList = hotelService.findHotelRecommend("2", (Integer.parseInt(pageToken) - 1) * pageSize, pageSize);
        model.addAttribute(hotelList);

        //旅游新闻资讯
        List<News> newsList = newsService.findNewsRecommend("1", (Integer.parseInt(pageToken) - 1) * pageSize_news, pageSize_news);
        model.addAttribute(newsList);

        int count = hotelService.findHotelCount();

        model.addAttribute("pageToken", pageToken);
        if (count > pageSize * Integer.parseInt(pageToken)) {
            model.addAttribute("hasNext", "1");
        } else {
            model.addAttribute("hasNext", "0");
        }

        model.addAttribute("reqURI", req.getRequestURI());


        return "hotel";
    }

    @RequestMapping("/hotel/search")
    public String searchHotel(Model model, HotelParam hotelParam, String pageToken_news, HttpServletRequest req) throws UnsupportedEncodingException, MessageException {

        if("".equals(hotelParam.getId()) && "".equals(hotelParam.getBrandName()) && "".equals(hotelParam.getLevel())){
            return "forward:/hotel";
        }
        //请求“酒店信息API”，并将返回结果放入model
        HotelInfo.getHotelInfo(hotelParam, model);
        model.addAttribute("reqURI", req.getRequestURI());

        if (pageToken_news == null || pageToken_news.equals("")) {
            pageToken_news = "1";
        }
        List<News> newsList = newsService.findNewsRecommend("2", (Integer.parseInt(pageToken_news) - 1) * pageSize_news, pageSize_news);
        model.addAttribute(newsList);
        model.addAttribute("pageToken_news", Integer.parseInt(pageToken_news) + 1 + "");

        return "hotel";
    }

    @RequestMapping("/hotel/{id}")
    public String hotelSingle(@PathVariable("id") String id, String recommend, Model model) {
        if (recommend == null) {
            HotelParam hotelParam = new HotelParam();
            hotelParam.setId(id);
            HotelDes hotelDes = HotelInfo.getHotelDesInfo(hotelParam);
            model.addAttribute(hotelDes);
        } else {
            HotelDes hotelDes = hotelService.findHotel(id);
            model.addAttribute(hotelDes);
        }
        //旅游新闻资讯
        List<News> newsList = newsService.findNewsRecommend("3", 0, pageSize_news);
        model.addAttribute(newsList);
        return "hotel-single";
    }
}
