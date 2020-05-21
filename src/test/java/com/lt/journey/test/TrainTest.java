package com.lt.journey.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TrainTest {

    public static void main(String[] args) {

        String str = "{\"code\":200,\"data\":{\"count\":15,\"stores\":null,\"unsureStores\":null,\"trainTypeDetails\":[{\"trainType\":0,\"number\":12,\"trainTypeName\":\"G-\\u9ad8\\u94c1\"},{\"trainType\":2,\"number\":1,\"trainTypeName\":\"D-\\u52a8\\u8f66\"},{\"trainType\":3,\"number\":1,\"trainTypeName\":\"Z-\\u76f4\\u8fbe\"},{\"trainType\":5,\"number\":1,\"trainTypeName\":\"K-\\u666e\\u5feb\"}],\"streamId\":null,\"remark\":null,\"isFinish\":null,\"lastTime\":1589884428000,\"expire\":false,\"freshUrl\":null,\"reserveUrls\":null,\"crossURL\":null,\"origin\":null,\"list\":[{\"trainId\":1657,\"trainNum\":\"G57\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"07:15\",\"destArriveTime\":\"13:05\",\"duration\":350,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":355308650,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":355308652,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":6,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":355308648,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"5\\u5c0f\\u65f650\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":1619,\"trainNum\":\"G19\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"08:00\",\"destArriveTime\":\"12:38\",\"duration\":278,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":1723323211,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":1723323212,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":1723323210,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":1,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"4\\u5c0f\\u65f638\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"ticketbtn\",\"sellOut\":0},{\"trainId\":1655,\"trainNum\":\"G55\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"08:10\",\"destArriveTime\":\"13:53\",\"duration\":343,\"prices\":[{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":355362265,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":2,\"seatStatus\":\"\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":355362269,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":355362261,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"5\\u5c0f\\u65f643\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":16165,\"trainNum\":\"G165\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"08:30\",\"destArriveTime\":\"13:30\",\"duration\":300,\"prices\":[{\"leftNumber\":8,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":1388858188,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":1388858189,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":1388858187,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"5\\u5c0f\\u65f60\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":1641,\"trainNum\":\"G41\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"09:12\",\"destArriveTime\":\"15:48\",\"duration\":396,\"prices\":[{\"leftNumber\":8,\"seatStatus\":\"\",\"seat\":2,\"price\":1048.5,\"stuPrice\":null,\"promotionPrice\":1048.5,\"resId\":355176171,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":626,\"stuPrice\":null,\"promotionPrice\":626,\"resId\":355176173,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":3,\"seatStatus\":\"\",\"seat\":0,\"price\":1966,\"stuPrice\":null,\"promotionPrice\":1966,\"resId\":355176168,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":1,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"6\\u5c0f\\u65f636\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"ticketbtn\",\"sellOut\":0},{\"trainId\":1633,\"trainNum\":\"G33\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"09:40\",\"destArriveTime\":\"15:40\",\"duration\":360,\"prices\":[{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":1423573786,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":1423573787,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":1423573785,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"6\\u5c0f\\u65f60\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":16163,\"trainNum\":\"G163\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"10:45\",\"destArriveTime\":\"17:13\",\"duration\":388,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":1420220199,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":1420220200,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":1420220198,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"6\\u5c0f\\u65f628\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":1631,\"trainNum\":\"G31\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"11:00\",\"destArriveTime\":\"15:35\",\"duration\":275,\"prices\":[{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":355175982,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":355175984,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":355175981,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"4\\u5c0f\\u65f635\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":16167,\"trainNum\":\"G167\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"12:45\",\"destArriveTime\":\"18:38\",\"duration\":353,\"prices\":[{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":354639555,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":354639556,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":354639554,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"5\\u5c0f\\u65f653\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":1},{\"trainId\":16419,\"trainNum\":\"G419\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"13:24\",\"destArriveTime\":\"20:13\",\"duration\":409,\"prices\":[{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":2041653473,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":2041653474,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":2041653472,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"6\\u5c0f\\u65f649\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":1645,\"trainNum\":\"G45\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"15:25\",\"destArriveTime\":\"21:23\",\"duration\":358,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":353274188,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":353274189,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":353274187,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"5\\u5c0f\\u65f658\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0},{\"trainId\":1637,\"trainNum\":\"G37\",\"trainType\":0,\"trainTypeName\":\"\\u9ad8\\u94c1\",\"departStationName\":\"\\u5317\\u4eac\\u5357\",\"destStationName\":\"\\u676d\\u5dde\\u4e1c\",\"departDepartTime\":\"16:05\",\"destArriveTime\":\"22:07\",\"duration\":362,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":2,\"price\":907,\"stuPrice\":null,\"promotionPrice\":907,\"resId\":355176284,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":538.5,\"stuPrice\":null,\"promotionPrice\":538.5,\"resId\":355176287,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":13,\"seatStatus\":\"\",\"seat\":0,\"price\":1701,\"stuPrice\":null,\"promotionPrice\":1701,\"resId\":355176281,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u5546\\u52a1\\u5ea7\"}],\"durationDay\":1,\"departStationType\":0,\"destStationType\":1,\"saleStatus\":0,\"departStationId\":1175341,\"destStationId\":1176042,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"Y\",\"durationStr\":\"6\\u5c0f\\u65f62\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"ticketbtn\",\"sellOut\":0},{\"trainId\":35281,\"trainNum\":\"Z281\",\"trainType\":3,\"trainTypeName\":\"\\u76f4\\u8fbe\",\"departStationName\":\"\\u5317\\u4eac\",\"destStationName\":\"\\u676d\\u5dde\",\"departDepartTime\":\"19:10\",\"destArriveTime\":\"12:23\",\"duration\":1033,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":8,\"price\":192,\"stuPrice\":null,\"promotionPrice\":192,\"resId\":1975161338,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u786c\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":6,\"price\":372,\"stuPrice\":null,\"promotionPrice\":372,\"resId\":1975161337,\"detail\":[{\"seat\":14,\"price\":328,\"promotionPrice\":328,\"seatName\":\"\\u786c\\u5367\\u4e0a\"},{\"seat\":15,\"price\":328,\"promotionPrice\":328,\"seatName\":\"\\u786c\\u5367\\u4e2d\"},{\"seat\":6,\"price\":372,\"promotionPrice\":372,\"seatName\":\"\\u786c\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u786c\\u5367\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":5,\"price\":567.5,\"stuPrice\":null,\"promotionPrice\":567.5,\"resId\":1975161336,\"detail\":[{\"seat\":16,\"price\":515,\"promotionPrice\":515,\"seatName\":\"\\u8f6f\\u5367\\u4e0a\"},{\"seat\":5,\"price\":567.5,\"promotionPrice\":567.5,\"seatName\":\"\\u8f6f\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u8f6f\\u5367\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":9,\"price\":192,\"stuPrice\":null,\"promotionPrice\":192,\"resId\":1975161339,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u65e0\\u5ea7\"}],\"durationDay\":2,\"departStationType\":2,\"destStationType\":1,\"saleStatus\":0,\"departStationId\":1175342,\"destStationId\":1176044,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"N\",\"durationStr\":\"17\\u5c0f\\u65f613\\u5206\\u949f\",\"departStationTypeName\":\"\",\"destStationTypeName\":\"ticketbtn\",\"sellOut\":0},{\"trainId\":13717,\"trainNum\":\"D717\",\"trainType\":2,\"trainTypeName\":\"\\u52a8\\u8f66\",\"departStationName\":\"\\u5317\\u4eac\",\"destStationName\":\"\\u676d\\u5dde\",\"departDepartTime\":\"19:16\",\"destArriveTime\":\"08:47\",\"duration\":811,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":20,\"price\":605,\"stuPrice\":null,\"promotionPrice\":605,\"resId\":1994824379,\"detail\":[{\"seat\":23,\"price\":454,\"promotionPrice\":454,\"seatName\":\"\\u4e8c\\u7b49\\u5367\\u4e0a\"},{\"seat\":22,\"price\":454,\"promotionPrice\":454,\"seatName\":\"\\u4e8c\\u7b49\\u5367\\u4e2d\"},{\"seat\":20,\"price\":605,\"promotionPrice\":605,\"seatName\":\"\\u4e8c\\u7b49\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5367\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":19,\"price\":734,\"stuPrice\":null,\"promotionPrice\":734,\"resId\":1994824378,\"detail\":[{\"seat\":21,\"price\":574,\"promotionPrice\":574,\"seatName\":\"\\u4e00\\u7b49\\u5367\\u4e0a\"},{\"seat\":19,\"price\":734,\"promotionPrice\":734,\"seatName\":\"\\u4e00\\u7b49\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u4e00\\u7b49\\u5367\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":3,\"price\":302,\"stuPrice\":null,\"promotionPrice\":302,\"resId\":1986525910,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":9,\"price\":302,\"stuPrice\":null,\"promotionPrice\":302,\"resId\":1986552087,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u65e0\\u5ea7\"}],\"durationDay\":2,\"departStationType\":0,\"destStationType\":1,\"saleStatus\":0,\"departStationId\":1175342,\"destStationId\":1176044,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"N\",\"durationStr\":\"13\\u5c0f\\u65f631\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"ticketbtn\",\"sellOut\":0},{\"trainId\":20101,\"trainNum\":\"K101\",\"trainType\":5,\"trainTypeName\":\"\\u666e\\u5feb\",\"departStationName\":\"\\u5317\\u4eac\",\"destStationName\":\"\\u676d\\u5dde\",\"departDepartTime\":\"23:20\",\"destArriveTime\":\"20:24\",\"duration\":1264,\"prices\":[{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":8,\"price\":189.5,\"stuPrice\":null,\"promotionPrice\":189.5,\"resId\":354824990,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u786c\\u5ea7\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":6,\"price\":366,\"stuPrice\":null,\"promotionPrice\":366,\"resId\":354824987,\"detail\":[{\"seat\":14,\"price\":322.5,\"promotionPrice\":322.5,\"seatName\":\"\\u786c\\u5367\\u4e0a\"},{\"seat\":15,\"price\":322.5,\"promotionPrice\":322.5,\"seatName\":\"\\u786c\\u5367\\u4e2d\"},{\"seat\":6,\"price\":366,\"promotionPrice\":366,\"seatName\":\"\\u786c\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u786c\\u5367\"},{\"leftNumber\":99,\"seatStatus\":\"\\u6709\",\"seat\":5,\"price\":556,\"stuPrice\":null,\"promotionPrice\":556,\"resId\":354824984,\"detail\":[{\"seat\":16,\"price\":504.5,\"promotionPrice\":504.5,\"seatName\":\"\\u8f6f\\u5367\\u4e0a\"},{\"seat\":5,\"price\":556,\"promotionPrice\":556,\"seatName\":\"\\u8f6f\\u5367\\u4e0b\"}],\"priceMemo\":null,\"seatName\":\"\\u8f6f\\u5367\"},{\"leftNumber\":0,\"seatStatus\":\"\",\"seat\":9,\"price\":189.5,\"stuPrice\":null,\"promotionPrice\":189.5,\"resId\":354824993,\"detail\":[],\"priceMemo\":null,\"seatName\":\"\\u65e0\\u5ea7\"}],\"durationDay\":2,\"departStationType\":0,\"destStationType\":2,\"saleStatus\":0,\"departStationId\":1175342,\"destStationId\":1176044,\"startSaleTime\":\"\",\"canChooseSeat\":0,\"memo\":\"\",\"departureCityCode\":200,\"arrivalCityCode\":3402,\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\",\"upOrDown\":0,\"trainStartDate\":\"2020-05-20\",\"accessByIdcard\":\"N\",\"durationStr\":\"21\\u5c0f\\u65f64\\u5206\\u949f\",\"departStationTypeName\":\"ticketbtn\",\"destStationTypeName\":\"\",\"sellOut\":0}],\"allTrainType\":{\"list\":[{\"trainType\":0,\"trainTypeName\":\"G-\\u9ad8\\u94c1\",\"trainTypeCode\":\"G\",\"link\":\"\\/\\/huoche.tuniu.com\\/station_200_3402\\/G\"},{\"trainType\":3,\"trainTypeName\":\"Z-\\u76f4\\u8fbe\",\"trainTypeCode\":\"Z\",\"link\":\"\\/\\/huoche.tuniu.com\\/station_200_3402\\/Z\"},{\"trainType\":2,\"trainTypeName\":\"D-\\u52a8\\u8f66\",\"trainTypeCode\":\"D\",\"link\":\"\\/\\/huoche.tuniu.com\\/station_200_3402\\/D\"},{\"trainType\":5,\"trainTypeName\":\"K-\\u666e\\u5feb\",\"trainTypeCode\":\"K\",\"link\":\"\\/\\/huoche.tuniu.com\\/station_200_3402\\/K\"}],\"departureCityName\":\"\\u5317\\u4eac\",\"arrivalCityName\":\"\\u676d\\u5dde\"},\"filter\":{\"filter\":[{\"id\":\"trainTypes\",\"name\":\"\\u8f66\\u578b\",\"pros\":[{\"id\":0,\"name\":\"G-\\u9ad8\\u94c1\"},{\"id\":2,\"name\":\"D-\\u52a8\\u8f66\"},{\"id\":3,\"name\":\"Z-\\u76f4\\u8fbe\"},{\"id\":5,\"name\":\"K-\\u666e\\u5feb\"}]},{\"id\":\"seats\",\"name\":\"\\u5ea7\\u5e2d\",\"pros\":[{\"id\":0,\"name\":\"\\u5546\\u52a1\\u5ea7\"},{\"id\":2,\"name\":\"\\u4e00\\u7b49\\u5ea7\"},{\"id\":3,\"name\":\"\\u4e8c\\u7b49\\u5ea7\"},{\"id\":19,\"name\":\"\\u4e00\\u7b49\\u5367\"},{\"id\":20,\"name\":\"\\u4e8c\\u7b49\\u5367\"},{\"id\":5,\"name\":\"\\u8f6f\\u5367\"},{\"id\":6,\"name\":\"\\u786c\\u5367\"},{\"id\":8,\"name\":\"\\u786c\\u5ea7\"}]},{\"id\":\"departureStations\",\"name\":\"\\u51fa\\u53d1\\u8f66\\u7ad9\",\"pros\":[{\"name\":\"\\u5317\\u4eac\",\"id\":1175342},{\"name\":\"\\u5317\\u4eac\\u5357\",\"id\":1175341}]},{\"id\":\"arrivalStations\",\"name\":\"\\u5230\\u8fbe\\u8f66\\u7ad9\",\"pros\":[{\"name\":\"\\u676d\\u5dde\",\"id\":1176044},{\"name\":\"\\u676d\\u5dde\\u4e1c\",\"id\":1176042}]},{\"id\":\"departureTimes\",\"name\":\"\\u51fa\\u53d1\\u65f6\\u6bb5\",\"pros\":[{\"id\":\"18-24\",\"name\":\"18-24\\u70b9\"},{\"id\":\"12-18\",\"name\":\"12-18\\u70b9\"},{\"id\":\"6-12\",\"name\":\"6-12\\u70b9\"}]},{\"id\":\"arrivalTimes\",\"name\":\"\\u5230\\u8fbe\\u65f6\\u6bb5\",\"pros\":[{\"id\":\"18-24\",\"name\":\"18-24\\u70b9\"},{\"id\":\"12-18\",\"name\":\"12-18\\u70b9\"},{\"id\":\"6-12\",\"name\":\"6-12\\u70b9\"}]},{\"id\":\"departStationTypes\",\"name\":\"\\u662f\\u5426\\u59cb\\u53d1\",\"pros\":[{\"id\":0,\"name\":\"\\u59cb\\u53d1\"},{\"id\":2,\"name\":\"\\u8fc7\\u8def\"}]}],\"sort\":[{\"type\":2,\"id\":1,\"name\":\"\\u51fa\\u53d1\\u65f6\\u95f4\"},{\"type\":2,\"id\":3,\"name\":\"\\u8fd0\\u884c\\u65f6\\u95f4\"},{\"type\":2,\"id\":2,\"name\":\"\\u5230\\u8fbe\\u65f6\\u95f4\"},{\"type\":2,\"id\":4,\"name\":\"\\u4ef7\\u683c\"}]}}}";
        JSONObject dataObj = JSONObject.parseObject(str);
        System.out.println(dataObj);
        System.out.println(dataObj.getString("code"));
    }
}
