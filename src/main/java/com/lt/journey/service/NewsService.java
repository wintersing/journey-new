package com.lt.journey.service;

import java.util.List;

import com.lt.journey.model.News;

public interface NewsService {

	public void addNews(List<News> newsList);

	public List<News> findNewsRecommend(String string, int i, int pageSize);

}
