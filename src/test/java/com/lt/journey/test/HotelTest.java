package com.lt.journey.test;


import java.util.List;

import com.lt.journey.model.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.journey.exception.MessageException;
import com.lt.journey.model.HotelDes;
import com.lt.journey.model.HotelParam;
import com.lt.journey.service.HotelService;
import com.lt.journey.util.HotelInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HotelTest {

	@Autowired
	private HotelService hotelService;

	@Test
	public void name() throws MessageException {
		HotelParam hotelParam = new HotelParam();
//		hotelParam.setCity("宁波");
//		hotelParam.setLevel("五星级/豪华");
		List<Hotel> hotelList = HotelInfo.getHotelInfo(hotelParam, null);
		hotelService.addHotel(hotelList);
//		System.out.println(hotelList);
	}
}