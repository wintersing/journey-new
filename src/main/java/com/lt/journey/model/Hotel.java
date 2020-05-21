package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Hotel implements Serializable {
	private String[] imageUrls;
	private String updatetime;
	private String title;
	private String rating;
//	private String[] facilities;		//屋内设施
//	private String[] infrastructures;	//酒店设施
//	private DoodTagDist[] goodTagDist;	//正面标签分布
//	private String[] assistServices;	//服务
	private String price;
//	private String minPrice;
	private String description;
	private String city;
	private String id;
	private String district;			//地区
//	private String recommend = "0";
}
