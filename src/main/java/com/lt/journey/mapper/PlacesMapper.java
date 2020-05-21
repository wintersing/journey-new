package com.lt.journey.mapper;

import java.util.List;

import com.lt.journey.model.PlacesParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lt.journey.model.Places;
import com.lt.journey.model.PlacesDes;

@Repository
public interface PlacesMapper {
	void addPlaces(List<? extends Object> placesList);
	
	@Select("select cityid from places_city where cityName = #{cityName}")
	String findCityidByCityName(@Param("cityName") String cityName);

	@Select("select * from places where recommend = #{recommend} ORDER BY updatetime DESC limit #{offset}, #{pageSize}")
	List<Places> findPlacesRecommend(@Param("recommend") String recommend, @Param("offset") int offset, @Param("pageSize") int pageSize);

	@Select("select count(*) from places where recommend = #{recommend}")
	int findCount(@Param("recommend") String recommend);

	@Select("select cityid from hotel_city where cityName = #{cityName}")
	String findCityidByCityName_hotel(@Param("cityName") String cityName);

	PlacesDes findPlacesDes(@Param("id") String id);

    List<Places> findPlaces(@Param("placesParam")PlacesParam placesParam);
}
