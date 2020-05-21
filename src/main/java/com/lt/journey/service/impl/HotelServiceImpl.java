package com.lt.journey.service.impl;

import java.util.List;

import com.lt.journey.model.HotelParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.GeoPointMapper;
import com.lt.journey.mapper.HotelMapper;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.Hotel;
import com.lt.journey.service.HotelService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelMapper hotelMapper;
	
	@Autowired
	private GeoPointMapper geoPointMapper;

	@Override
    @Transactional(rollbackFor = Exception.class)
	public void addHotel(List<? extends Object> hotelList) {
		geoPointMapper.addGeoPoint(hotelList);
        hotelMapper.addHotel(hotelList);
    }

	@Override
	public List<Hotel> findHotelRecommend(String recommend, int offset, int pageSize) {
		return hotelMapper.findHotelRecommend(recommend, offset, pageSize);
	}

	@Override
	public int findHotelCount() {
		return hotelMapper.findHotelCount();
	}

	@Override
	public HotelDes findHotel(String id) {
		return hotelMapper.findHotel(id);
	}

    @Override
    public List<Hotel> findHotel(HotelParam hotelParam) {
	    return hotelMapper.findHotels(hotelParam);
    }

}
