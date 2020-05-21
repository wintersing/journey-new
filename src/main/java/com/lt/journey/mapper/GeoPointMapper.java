package com.lt.journey.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GeoPointMapper {
	void addGeoPoint(List<? extends Object> journeyList);
}
