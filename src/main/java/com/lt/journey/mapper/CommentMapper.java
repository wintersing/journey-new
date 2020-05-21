package com.lt.journey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lt.journey.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

	void addComment(Comment comment);

	@Select("select * from comment where parent=#{parent} AND parentID=#{id} order by publishDate Desc limit #{offset}, #{pageSize}")
	List<Comment> findComment(@Param("parent") String parent, @Param("id") String id, @Param("offset") int offset, @Param("pageSize") int pageSize);

	@Select("select count(*) from comment")
	int findCount();

}
