package com.lt.journey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lt.journey.model.News;

@Repository
public interface NewsMapper {

	public void addNews(List<News> newsList);

	@Select("select * from news where recommend = #{recommend} ORDER BY updatetime DESC limit #{i}, #{pageSize}")
	public List<News> findNewsRecommend(@Param("recommend") String recommend, @Param("i") int i, @Param("pageSize") int pageSize);

}
