package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Price implements Serializable {
	private String leftNumber;
	private String seatStatus;
	private String price;
	private String stuPrice;
	private String seatName;
	private Detail[] detail;
//	private Integer seat;
//	private String promotionPrice;
//	private Integer resId;
//	private String priceMemo;
}
