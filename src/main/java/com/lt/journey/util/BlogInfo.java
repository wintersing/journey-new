package com.lt.journey.util;

import java.util.List;
import java.util.Properties;

import org.springframework.ui.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.commons.utils.CommonsUtils;
import com.lt.commons.utils.HttpRequest;
import com.lt.journey.exception.MessageException;
import com.lt.journey.model.Blog;
import com.lt.journey.model.BlogDes;
import com.lt.journey.model.BlogParam;

public class BlogInfo {

	private static final String url = CommonsUtils.getProperty("Blog_Url");
	private static final String apikey = CommonsUtils.getProperty("IDataAPI_APIKEY");

	public static <T> List<T> getBlogInfo(BlogParam blogParam, Model model, Class<T> clazz) throws MessageException {
		//拼接参数

		//发送Get请求
		String ret = HttpRequest.sendGet(url, spliceParam(blogParam));
		if (ret == null) {
//			throw new MessageException("Search No Result");
		}

		JSONObject dataObj = JSON.parseObject(ret);
		if (dataObj.getString("retcode").equals("100002")) {
			throw new MessageException("Search No Result");
		}
		String blogStr = dataObj.getJSONArray("data").toString();
		
		List<T> blogList = JSONObject.parseArray(blogStr, clazz);

		String cityid = blogParam.getCityid();
		for (T blog : blogList) {
			if (blog instanceof Blog) {
				Blog blogtemp = (Blog) blog;
				blogtemp.setCityid(cityid);
				blogtemp.setCity(CommonsUtils.unicodeToString(blogtemp.getCity()));
				blogtemp.setPosterScreenName(CommonsUtils.unicodeToString(blogtemp.getPosterScreenName()));
			} else if(blog instanceof BlogDes) {
				BlogDes blogtemp = (BlogDes) blog;
//				System.out.println(blogtemp == blog);
				blogtemp.setCityid(cityid);
				blogtemp.setCity(CommonsUtils.unicodeToString(blogtemp.getCity()));
				blogtemp.setPosterScreenName(CommonsUtils.unicodeToString(blogtemp.getPosterScreenName()));
//				String string = CommonsUtils.unicodeToString(blogtemp.getContent()).replaceAll("\\n", "\\\\n");
//				blogtemp.setContent(string);
			}
		}
		
		if (model != null) {
			model.addAttribute("blogList", blogList);
		}
		
		return blogList;
	}

	private static String spliceParam(BlogParam blogParam){
        StringBuffer param = new StringBuffer();
        param.append("apikey=").append(apikey).append("&cityid=").append(blogParam.getCityid())
                .append("&sort=").append(blogParam.getSort()).append("&pageToken=").append(blogParam.getPageToken());
        return param.toString();
    }
	

	public static BlogDes getBlogDesInfo(BlogParam blogParam) {

		String ret = HttpRequest.sendGet(url, spliceParam(blogParam));
//		String dataStr = CommonsUtils.unicodeToString(ret);
//		System.out.println(dataStr);
		JSONObject dataObj = JSON.parseObject(ret);
		JSONArray blogList = dataObj.getJSONArray("data");

		//循环取出目标游记
		BlogDes blogDes = null;
		for (Object obj_ : blogList) {
			if (obj_ instanceof JSONObject) {
				JSONObject obj = (JSONObject) obj_;
				String id = obj.getString("id");
				if (blogParam.getId().equals(id)) {
					blogDes = JSONObject.parseObject(obj+"", BlogDes.class);
					break;
				}
			}
		}

		return blogDes;
	}

}










