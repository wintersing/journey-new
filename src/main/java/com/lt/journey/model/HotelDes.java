package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class HotelDes implements Serializable {
	private String id;					//酒店id
	private String brandName;			//品牌名称
	private String updatetime;
	private GeoPoint geoPoint;
	private String openingHours;
	private String rating;
	private String[] tags;
	private String[] facilities;		//屋内设施
	private String[] infrastructures;	//酒店设施
	private String[] assistServices;	//服务
	private String city;
	private String description;
	private String price;
	private String level;
	private String[] telephones;
	private String district;			//地区
	private String address;
	private String title;
	private String[] imageUrls;
	private String recommend = "0";
}
