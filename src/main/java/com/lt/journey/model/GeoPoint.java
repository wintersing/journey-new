package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GeoPoint implements Serializable {
	private String id;
	private String lon;
	private String lat;
}
