package com.lt.journey.service;

import java.util.List;

import com.lt.journey.model.Comment;

public interface CommentService {

	public void addComment(Comment comment);

	public List<Comment> findComment(String parent, String id, int offset, int pageSize);

	public int findCount();

}
