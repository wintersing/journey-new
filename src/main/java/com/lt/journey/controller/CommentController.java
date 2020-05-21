package com.lt.journey.controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lt.commons.utils.CommonsUtils;
import com.lt.commons.utils.HttpRequest;
import com.lt.journey.model.Comment;
import com.lt.journey.model.User;
import com.lt.journey.service.CommentService;

@Controller
@RequestMapping("/")
public class CommentController {

	private static final String url = CommonsUtils.getProperty("comment_url");
	private static final String apikey = CommonsUtils.getProperty("IDataAPI_APIKEY");

	private static final int pageSize = 10;

	@Autowired
	private CommentService commentService;

	// sight,post
	@RequestMapping(value = "/comment/{parent}/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getComment(@PathVariable("parent") String parent, @PathVariable("id") String id, String pageToken,
			String data) {
		if (data.equals("0")) {
			List<Comment> commentList = commentService.findComment(parent, id,
					(Integer.parseInt(pageToken) - 1) * pageSize, pageSize);
			if (commentList != null && commentList.size() > 0) {
				int count = commentService.findCount();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("data", commentList);
				jsonObject.put("retcode", "10000");
				if (count <= (Integer.parseInt(pageToken) - 1) * pageSize) {
					jsonObject.put("hasNext", true);
				} else {
					jsonObject.put("hasNext", false);
					jsonObject.put("hasNext_data", true);
				}
				String str = JSONObject.toJSON(jsonObject).toString();
//				System.out.println(str);
				return str;
			}

		}
		
		StringBuffer param = new StringBuffer();
		param.append("apikey=").append(apikey).append("&id=").append(id).append("&parent=").append(parent)
				.append("&pageToken=").append(pageToken);

		String dataStr = HttpRequest.sendGet(url, param.toString());
		if (dataStr == null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("retcode", "100002");
			return jsonObject.toString();
		}
//		System.out.println(dataStr);
		return CommonsUtils.unicodeToString(dataStr);
	}

	@RequestMapping(value = "/addComment", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addComment(Comment comment, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		User user = (User) req.getSession().getAttribute("user_session");
		if (user == null) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "请先登录！");
			return jsonObject.toString();
		}
		comment.setAvatarUrl("/images/avatar.jpg");
		comment.setCommenterScreenName(user.getUsername());
		comment.setPublishDate(new Date().getTime());
		commentService.addComment(comment);
		jsonObject.put("status", true);
		return jsonObject.toString();
	}

//	@RequestMapping(value = "/comment/hotel/{id}", produces = "application/json; charset=utf-8")
//	@ResponseBody
//	public String getHotelComment(@PathVariable("id") String id, String pageToken) {
//
//		StringBuffer param = new StringBuffer();
//		param.append("apikey=").append(apikey).append("&id=").append(id).append("&pageToken=").append(pageToken);
//
//		String dataStr = HttpRequest.sendGet(Hotel_comment_url, param.toString());
//
//		System.out.println(dataStr);
////		String string = CommonsUtils.unicodeToString(dataStr);
//		return dataStr;
//	}
}
