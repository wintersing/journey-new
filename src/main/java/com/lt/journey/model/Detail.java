package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Detail implements Serializable {
	private String price;
	private String promotionPrice;
	private String seatName;
//	private Integer seat;
}
