package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogParam implements Serializable {
	private String pageToken;
	private String cityid;
	private String id;
	private String sort;
	private String DaysMin;
	private String DaysMax;
	private String Month;
	private String company;
	private String recommend;
	private String kw;
}
