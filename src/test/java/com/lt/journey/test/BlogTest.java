package com.lt.journey.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.lt.journey.mapper.BlogMapper;
import com.lt.journey.mapper.CommentMapper;
import com.lt.journey.exception.MessageException;
import com.lt.journey.model.BlogDes;
import com.lt.journey.model.BlogParam;
import com.lt.journey.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lt.journey.util.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BlogTest {

	private static final Model model = null;

	@Autowired
	private BlogService blogService;

	@Autowired
    private BlogMapper blogMapper;

	@Autowired
	private CommentMapper commentMapper;

	@Test
	public void name() throws MessageException {
		BlogParam blogParam = new BlogParam();
//		blogParam.setId("100041");
		blogParam.setCityid("26");//1,1005,1096,360,26
		blogParam.setSort("0");
		blogParam.setPageToken("0");
//		List<Blog> blogList = BlogInfo.getBlogInfo(blogParam, model, Blog.class);
		List<BlogDes> blogDesList = BlogInfo.getBlogInfo(blogParam, model, BlogDes.class);
//		BlogDes blogList = BlogInfo.getBlogDesInfo(blogParam);
//		System.out.println(blogDesList);
		blogService.addBlog(blogDesList);
	}

    @Test
    public void fun() throws ParseException {
		String strDate = "Fri Mar 31 2017 00:00:00 GMT+0800 (中国标准时间)";
		strDate = strDate.replace("GMT", "").replaceAll("\\(.*\\)", "");
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss", Locale.ENGLISH);
		Date date = format.parse(strDate);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }


    @Test
    public void fun1(){
        System.out.println(blogMapper);
        System.out.println(commentMapper);
    }
}
