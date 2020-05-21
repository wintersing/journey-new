package com.lt.journey.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lt.journey.model.Places;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.lt.journey.exception.MessageException;
import com.lt.journey.model.PlacesDes;
import com.lt.journey.model.PlacesParam;
import com.lt.journey.service.PlacesService;
import com.lt.journey.util.PlacesInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-*.xml","classpath*:mybatis-config.xml" })
public class PlacesTest {
	@Autowired
	private PlacesService placesService;


	@Test
	public void name() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR_OF_DAY, 12);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	
	@Test
	public void name2() throws MessageException {
		String cityid = placesService.findCityidByCityName("韩国");
		PlacesParam placesParam = new PlacesParam();
		placesParam.setCityid(cityid);
		placesParam.setSort("1");
		List<Places> placesList = PlacesInfo.getPlacesInfo(placesParam, null);
		placesService.addPlaces(placesList);
	}
	
}


