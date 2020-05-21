package com.lt.journey.service;

import java.util.List;

import com.lt.journey.model.Hotel;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.HotelParam;

public interface HotelService {

	void addHotel(List<? extends Object> hotelList);

	List<Hotel> findHotelRecommend(String recommend, int offset, int pageSize);

	int findHotelCount();

//	String findCityidByCityName(String cityName);

	HotelDes findHotel(String id);

    List<Hotel> findHotel(HotelParam hotelParam);

}
