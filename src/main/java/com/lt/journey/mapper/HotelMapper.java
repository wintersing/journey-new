package com.lt.journey.mapper;

import java.util.List;

import com.lt.journey.model.HotelParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.lt.journey.model.Hotel;
import com.lt.journey.model.HotelDes;

@Repository
public interface HotelMapper {

	void addHotel(List<? extends Object> hotelList);
	
	@Select("select * from hotel where recommend = #{recommend} ORDER BY updatetime DESC limit #{offset}, #{pageSize}")
	List<Hotel> findHotelRecommend(@Param("recommend") String recommend, @Param("offset") int offset, @Param("pageSize") int pageSize);

	List<Hotel> findHotelDes(@Param("id") String id);

	@Select("select count(*) from hotel where recommend = 2")
	int findHotelCount();

//	@Select("select cityid from hotel_city where cityName = #{cityName }")
//	public String findCityidByCityName(@Param("cityName")String cityName);

	@Select("select * from hotel where id = #{id }")
	HotelDes findHotel(@Param("id") String id);

    List<Hotel> findHotels(@Param("hotelParam") HotelParam hotelParam);
}
