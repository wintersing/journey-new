package com.lt.journey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.journey.model.Blog;
import com.lt.journey.model.Hotel;
import com.lt.journey.model.Places;
import com.lt.journey.service.BlogService;
import com.lt.journey.service.HotelService;
import com.lt.journey.service.PlacesService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private PlacesService placesService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private BlogService blogService;
	
	private static final int pageSize = 8;
	
	private static final int pageSize_blog = 5;
	
	@RequestMapping
	public String indexView(Model model) {
		List<Places> placesList = placesService.findPlacesRecommend("1",0,pageSize);//(1-主页推荐，2-目的地推荐)
		List<Hotel> hotelList = hotelService.findHotelRecommend("1",0,pageSize);
		List<Blog> blogList = blogService.findBlog("1",0,pageSize_blog);
		model.addAttribute(placesList);
		model.addAttribute(hotelList);
		model.addAttribute(blogList);
		
		return "index";
	}
	//target/classes
}
