package com.lt.journey.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lt.journey.exception.MessageException;
import com.lt.journey.model.Blog;
import com.lt.journey.model.BlogDes;
import com.lt.journey.model.BlogParam;
import com.lt.journey.service.BlogService;
import com.lt.journey.util.BlogInfo;

@Controller
@RequestMapping("/")
public class BlogController {

	private static final int pageSize = 9;

	@Autowired
	private BlogService blogService;

	@RequestMapping("/blog")
	public String blogView(Model model, String pageToken, HttpServletRequest req) {
		if (pageToken == null || pageToken == "") {
			pageToken = "1";
		}
		List<Blog> blogList = blogService.findBlog("2", (Integer.parseInt(pageToken) - 1) * pageSize, pageSize);
		int count = blogService.findBlogCount();

		model.addAttribute(blogList);
		model.addAttribute("pageToken", pageToken);
		if (count > pageSize * Integer.parseInt(pageToken)) {
			model.addAttribute("hasNext", "1");
		} else {
			model.addAttribute("hasNext", "0");
		}

		model.addAttribute("reqURI", req.getRequestURI());

		return "blog";
	}

	@RequestMapping("/blog/{cityid}/{id}/{pageToken}") // cityid,pageToken,recommend
	public String blogView(@PathVariable("pageToken") String pageToken, @PathVariable("cityid") String cityid, @PathVariable("id") String id, Model model,
			BlogParam blogParam, HttpServletRequest req) throws MessageException {
	    //添加该城市(cityid)的推荐游记
//		blogParam.setSort("0");
//		BlogInfo.getBlogInfo(blogParam, model, Blog.class);
//        BlogDes blogDes = blogService.findBlogDes(id);
        List<Blog> blogList = blogService.findBlog("0",0,10);
        model.addAttribute(blogList);

		model.addAttribute("pageToken", pageToken);
		model.addAttribute("cityid", cityid);
		model.addAttribute("id", id);
		model.addAttribute("reqURI", req.getRequestURI());
		if (blogParam.getRecommend() != null) {
			model.addAttribute("recommend", blogParam.getRecommend());
		}
		return "blog-single";
	}

	@RequestMapping(value = "/blog/{id}", produces = "application/json; charset=utf-8") // cityid,pageToken,recommend
	@ResponseBody
	public String blogSingle(@PathVariable("id") String id, Model model, BlogParam blogParam) {
		if (!"1".equals(blogParam.getRecommend()) && !"2".equals(blogParam.getRecommend()) && !"0".equals(blogParam.getRecommend())) {
			blogParam.setId(id);
			blogParam.setSort("0");
			BlogDes blogDes = BlogInfo.getBlogDesInfo(blogParam);
			String blogDesStr = JSONObject.toJSONString(blogDes);
			return blogDesStr;
		} else {
			BlogDes blogDes = blogService.findBlogDes(id);
			String blogDesStr = JSONObject.toJSONString(blogDes);
			return blogDesStr;
		}
	}

}
