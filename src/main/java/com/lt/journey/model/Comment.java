package com.lt.journey.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comment implements Serializable {
	private int id;
	private String parent;
	private String parentID;
	private String avatarUrl;
	private String commenterScreenName;
	private long publishDate;
	private String content;
}
