package com.lt.journey.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.lt.journey.model.News;
import com.lt.journey.model.NewsParam;
import com.lt.journey.service.NewsService;
import com.lt.journey.util.NewsInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NewTest {
	
	@Autowired
	private NewsService newsService;

	@Test
	public void name12() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  
		Date date=sdf.parse("5/29/2019"); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    String string = dateFormat.format(date);
	    System.out.println(string); 
	}
	

	@Test
	public void name112() throws ParseException {
	    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); 
	}
	
	@Test
	public void name() {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date());
		long endTime = calendar.getTimeInMillis();
		calendar.add(Calendar.DATE, -15);
		long startTime = calendar.getTimeInMillis();
		
		NewsParam newsParam = new NewsParam();
		newsParam.setCatLabel2("建筑");
		String time = ""+startTime/1000L+","+endTime/1000L;
		newsParam.setCreateDateRange(time);
		newsParam.setPublishDateRange(time);
		newsParam.setSize("50");
		List<News> newsList = NewsInfo.getNewsInfo(newsParam, null);
		
		newsService.addNews(newsList);
	}

//	@Test
	public void name1() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance(); 
		c.setTime(new Date());
        Date m = c.getTime();
        String mon = dateFormat.format(m);
        System.out.println(m.getTime());
        System.out.println(c.getTimeInMillis());
        System.out.println(mon);
        c.add(Calendar.DATE, -30);
        m = c.getTime();
        mon = dateFormat.format(m);
        System.out.println(m.getTime());
        System.out.println(mon);
	}
}
