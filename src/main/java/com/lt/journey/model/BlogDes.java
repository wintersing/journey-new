package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogDes implements Serializable {
	private String content;
	private String commentCount;
	private String id;
	private String cityid;
	private String imageUrls;
	private String likeCount;
	private String updatetime;
	private String avatarUrl;
	private String viewCount;
	private String city;
	private String title;
	private String publishDateStr;
	private String posterScreenName;
	private String recommend = "0";
}
