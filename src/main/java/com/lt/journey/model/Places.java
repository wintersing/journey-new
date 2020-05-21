package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Places implements Serializable {
	private String[] imageUrls;		
	private String location;
	private Double rating;
	private String id;
	private String updatetime;
	private String city;
	private String country;
	private String title;
	private String subtitle;
	private Double price;
	private String openingHours;
}
