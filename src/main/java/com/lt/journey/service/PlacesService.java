package com.lt.journey.service;

import java.util.List;

import com.lt.journey.model.Places;
import com.lt.journey.model.PlacesDes;
import com.lt.journey.model.PlacesParam;

public interface PlacesService {

	void addPlaces(List<? extends Object> placesList);

	String findCityidByCityName(String cityName);

	List<Places> findPlacesRecommend(String recommend, int offset, int pageSize);

	int findCount(String recommend);

	String findCityidByCityName_hotel(String string);

	PlacesDes findPlaces(String id);

    List<Places> findPlaces(PlacesParam placesParam);
}
