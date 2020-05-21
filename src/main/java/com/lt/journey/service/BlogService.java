package com.lt.journey.service;

import java.util.List;

import com.lt.journey.model.Blog;
import com.lt.journey.model.BlogDes;

public interface BlogService {

	void addBlog(List<BlogDes> blogDesList);

	List<Blog> findBlog(String recommend, int i, int pageSize);

	int findBlogCount();

	BlogDes findBlogDes(String id);

}
