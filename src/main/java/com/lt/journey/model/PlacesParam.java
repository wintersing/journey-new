package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlacesParam implements Serializable {
	private String cityid;
	private String cityName;
	private String id;
	private String kw;
	private String pageToken;
    //(人气最高：1，距离最近：2)
	private String sort = "1";
	private String lon;
	private String lat;
    //是否有下一页(0：没有，1：有)
	private String hasNext;
}
