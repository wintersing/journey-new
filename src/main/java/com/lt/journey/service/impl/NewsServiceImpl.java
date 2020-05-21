package com.lt.journey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.NewsMapper;
import com.lt.journey.model.News;
import com.lt.journey.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public void addNews(List<News> newsList) {
		newsMapper.addNews(newsList);
	}

	@Override
	public List<News> findNewsRecommend(String recommend, int i, int pageSize) {
		return newsMapper.findNewsRecommend(recommend, i, pageSize);
	}

}
