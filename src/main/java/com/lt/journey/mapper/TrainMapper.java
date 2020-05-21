package com.lt.journey.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainMapper {
	
	@Select("select trainCityCode from train_city where cityName = #{cityName}")
	String findCityCode(@Param("cityName") String cityName);
}
