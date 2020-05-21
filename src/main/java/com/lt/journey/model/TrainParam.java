package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrainParam implements Serializable {
	private String departureDate; 		//发车日期-
	private String departureCityCode; 	//出发站码
	private String departureCityName; 	//出发站名-
	private String arrivalCityCode; 	//到达站码
	private String arrivalCityName; 	//到达站名-
	private Integer start;  			//起始值
	private Integer limit;				//数量
	private Integer page;				//第几页
	private Integer maxPage;			//总页数
}
