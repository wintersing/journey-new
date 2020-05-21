package com.lt.journey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.TrainMapper;
import com.lt.journey.service.TrainService;

@Service("trainService")
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainMapper trainMapper;

	@Override
	public String findCityCode(String cityName) {
		return trainMapper.findCityCode(cityName);
	}

}
