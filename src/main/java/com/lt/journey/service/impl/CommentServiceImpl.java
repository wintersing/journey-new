package com.lt.journey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.journey.mapper.CommentMapper;
import com.lt.journey.model.Comment;
import com.lt.journey.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public void addComment(Comment comment) {
		commentMapper.addComment(comment);
	}

	@Override
	public List<Comment> findComment(String parent, String id, int offset, int pageSize) {
		return commentMapper.findComment(parent, id, offset, pageSize);
	}

	@Override
	public int findCount() {
		return commentMapper.findCount();
	}

}
