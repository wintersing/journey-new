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
import com.lt.journey.model.Blog;
import com.lt.journey.model.BlogParam;
import com.lt.journey.model.News;
import com.lt.journey.model.Places;
import com.lt.journey.model.PlacesDes;
import com.lt.journey.model.PlacesParam;
import com.lt.journey.service.BlogService;
import com.lt.journey.service.NewsService;
import com.lt.journey.service.PlacesService;
import com.lt.journey.util.BlogInfo;
import com.lt.journey.util.PlacesInfo;

@Controller
@RequestMapping("/")
public class PlacesController {
    @Autowired
    private PlacesService placesService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private NewsService newsService;

    private static final int pageSize = 9;

    private static final int pageSize_news = 17;

    private static final int pageSize_blog = 9;

    @RequestMapping("/places")
    public String placesView(Model model, String pageToken, HttpServletRequest req) {
        int page = 1;
        if (pageToken != null && pageToken != "") {
            page = Integer.parseInt(pageToken);
        }
        //景点
        List<Places> placesList = placesService.findPlacesRecommend("2", (page - 1) * pageSize, pageSize);
        model.addAttribute(placesList);
        //游记
        List<Blog> blogList = blogService.findBlog("2", (page - 1) * pageSize_blog, pageSize_blog);
        model.addAttribute(blogList);

        model.addAttribute("pageToken", page + 1 + "");
        int count = placesService.findCount("2");
        if (count > pageSize * page) {
            model.addAttribute("hasNext", "1");
        } else {
            model.addAttribute("hasNext", "0");
        }
        model.addAttribute("reqURI", req.getRequestURI());

        return "places";
    }

    @RequestMapping("/places/search")
    public String searchPlaces(Model model, String cityid, String cityName, String sort, String pageToken,
                               HttpServletRequest req) throws MessageException {
        //景点
        if (cityName == null || "".equals(cityName)) {
            return "forward:/places";
        }
        PlacesParam placesParam = new PlacesParam();
        if (cityid == null) {
            cityid = placesService.findCityidByCityName(cityName);
            pageToken = "1";

            if (cityid == null) {
                // 搜索目标无结果
                throw new MessageException("Search No Result");
            }
        }
        placesParam.setCityid(cityid);
        placesParam.setCityName(cityName);
        placesParam.setSort(sort);
        placesParam.setPageToken(pageToken);
        PlacesInfo.getPlacesInfo(placesParam, model);

        //旅游日记
//        BlogParam blogParam = new BlogParam();
//        blogParam.setCityid(cityid);
//        blogParam.setSort("0");
//        blogParam.setPageToken(pageToken);
//        BlogInfo.getBlogInfo(blogParam, model, Blog.class);
        List<Blog> blogList = blogService.findBlog("2", 0, pageSize_blog);
        model.addAttribute(blogList);

        model.addAttribute("reqURI", req.getRequestURI());
        return "places";
    }

    @RequestMapping("/places/{id}")
    public String placesSingle(@PathVariable("id") String id, PlacesParam placesParam, Integer recommend, Model model) {
        if (recommend == null) {
            placesParam.setId(id);
            PlacesDes placesDes = PlacesInfo.getPlacesSingleInfo(placesParam);
            model.addAttribute(placesDes);
            if (placesDes == null) return "msg";
        } else {
            PlacesDes placesDes = placesService.findPlaces(id);
            model.addAttribute(placesDes);
        }
        //旅游新闻资讯
        List<News> newsList = newsService.findNewsRecommend("4", 0, pageSize_news);
        model.addAttribute(newsList);
        return "places-single";
    }

}
