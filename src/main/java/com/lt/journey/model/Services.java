package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Services implements Serializable {
	private String price;
	private String name;
	private String saleCount;
	private String id;
	private String marketPrice;
}
