package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class News implements Serializable {
	private String id;
	private String title;
	private String url;
	private String updatetime;
	private String catLabel2;
	private String recommend="0";	//1-酒店列表推荐,2-酒店查找,3-酒店详情推荐,4-景点详情推荐
}
