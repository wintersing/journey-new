package com.lt.journey.util;

import java.util.List;
import java.util.Properties;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lt.commons.utils.CommonsUtils;
import com.lt.commons.utils.HttpRequest;
import com.lt.journey.model.News;
import com.lt.journey.model.NewsParam;

public class NewsInfo {

	private static final String url = CommonsUtils.getProperty("News_Url");
	private static final String apikey = CommonsUtils.getProperty("IDataAPI_APIKEY");

	public static List<News> getNewsInfo(NewsParam newsParam, Model model) {
		//拼接参数
		StringBuffer param = new StringBuffer();
		param.append("apikey=").append(apikey).append("&size=").append(newsParam.getSize())
		.append("&catLabel2=").append(newsParam.getCatLabel2()).append("&publishDateRange=")
		.append(newsParam.getPublishDateRange()).append("&createDateRange=").append(newsParam.getCreateDateRange())
		.append("&sourceType=").append(newsParam.getSourceType()).append("&sentiment=").append(newsParam.getSentiment());
		if (newsParam.getPageToken_news() != null && !newsParam.getPageToken_news().equals("")) {
			param.append("&pageToken=").append(newsParam.getPageToken_news());
		}
		//发送get请求
		String ret = HttpRequest.sendGet(url, param.toString());
		//处理返回数据
		JSONObject dataObj = JSON.parseObject(ret);
		String newsListStr = dataObj.getJSONArray("data").toString();
		List<News> newsList = JSONObject.parseArray(newsListStr, News.class);
		
		if (model != null) {
			model.addAttribute("newsList", newsList);
			
			String pageToken = dataObj.getString("pageToken");
			model.addAttribute("pageToken_news", pageToken);
		}
//		System.out.println(newsList);
		return newsList;
	}

}
