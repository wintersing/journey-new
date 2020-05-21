package com.lt.journey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.BlogMapper;
import com.lt.journey.model.Blog;
import com.lt.journey.model.BlogDes;
import com.lt.journey.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public void addBlog(List<BlogDes> blogList) {
		blogMapper.addBlog(blogList);
	}

	@Override
	public List<Blog> findBlog(String recommend, int i, int pageSize) {
		return blogMapper.findBlog(recommend, i, pageSize);
	}

	@Override
	public int findBlogCount() {
		return blogMapper.findBlogCount();
	}

	@Override
	public BlogDes findBlogDes(String id) {
		return blogMapper.findBlogDes(id);
	}

}
