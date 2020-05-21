package com.lt.journey.service.impl;

import java.util.List;

import com.lt.journey.model.PlacesParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.GeoPointMapper;
import com.lt.journey.mapper.PlacesMapper;
import com.lt.journey.model.Places;
import com.lt.journey.model.PlacesDes;
import com.lt.journey.service.PlacesService;


@Service("placesService")
public class PlacesServiceImpl implements PlacesService {
	
	@Autowired
	private GeoPointMapper geoPointMapper;

	@Autowired
	private PlacesMapper placesMapper;

	@Override
	public void addPlaces(List<? extends Object> placesList) {
		geoPointMapper.addGeoPoint(placesList);
		placesMapper.addPlaces(placesList);
	}

	@Override
	public String findCityidByCityName(String cityName) {
		return placesMapper.findCityidByCityName(cityName);
	}

	@Override
	public List<Places> findPlacesRecommend(String recommend, int offset, int pageSize) {
		return placesMapper.findPlacesRecommend(recommend, offset, pageSize);
	}

	@Override
	public int findCount(String recommend) {
		return placesMapper.findCount(recommend);
	}

	@Override
	public String findCityidByCityName_hotel(String cityName) {
		return placesMapper.findCityidByCityName_hotel(cityName);
	}

	@Override
	public PlacesDes findPlaces(String id) {
		return placesMapper.findPlacesDes(id);
	}

    @Override
    public List<Places> findPlaces(PlacesParam placesParam) {
        return placesMapper.findPlaces(placesParam);
    }

}
