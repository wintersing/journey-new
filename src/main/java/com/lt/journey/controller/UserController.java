package com.lt.journey.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.commons.utils.CommonsUtils;
import com.lt.journey.model.User;
import com.lt.journey.service.UserService;

import com.lt.journey.util.SMSUtils;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 生成随机验证码
	 * @return
	 */
	private static String SMSrandom() {
		return String.valueOf((int)(111111+Math.random()*888889));
	}
	
	/**
	 * 校验手机号
	 * @param mobile
	 * @return
	 */
	private static boolean isMobile(String mobile) {
		Pattern pattern = Pattern.compile("^((1[34578][0-9])|(14[57]))\\d{8}$");
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}
	
	/**
	 * 校验用户名
	 * @param str
	 * @return
	 */
	private static boolean isMatcher(String str) {
		Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_-]{5,19}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	//注册
	@RequestMapping("/registerView")
	public String registerView(Model model, HttpServletRequest req) {
		model.addAttribute("reqURI", req.getRequestURI());
		return "login-register";
	}

	//登陆
	@RequestMapping("/loginView")
	public String loginView(Model model, HttpServletRequest req) {
		model.addAttribute("reqURI", req.getRequestURI());
		return "login-register";
	}

	@RequestMapping(value = "/sendSMScode", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String sendSMScode(User user, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject ret = null;
			if (!isMobile(user.getPhone())) {
				jsonObject.put("status", false);
				jsonObject.put("msg", "客官，请输入正确的手机号！");
				return jsonObject.toString();
			}
			User _user = userService.findUserByPhone(user.getPhone());
	
			if (_user != null) {
				jsonObject.put("status", false);
				jsonObject.put("msg", "客官，该手机号已注册！");
				return jsonObject.toString();
			}
			//发送验证码
			String random = SMSrandom();
			String tpl_value = "#code#=" + random;
			System.out.println(tpl_value);
			ret = SMSUtils.sendSMSCode(user.getPhone(), tpl_value);
//			ret = new JSONObject();
//			ret.put("error_code", 0);
			if (ret.getInteger("error_code") == 0) {
				request.getSession().setAttribute("code", random);
				jsonObject.put("status", true);
				jsonObject.put("msg", "验证码发送成功！");
				return jsonObject.toJSONString();
			} else {
				jsonObject.put("status", false);
				jsonObject.put("msg", "验证码发送失败，请稍后尝试！");
				return jsonObject.toJSONString();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			jsonObject.put("status", false);
			jsonObject.put("msg", "验证码发送失败，请稍后尝试！"); 
			return jsonObject.toJSONString();
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String register(User user, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		if (!isMatcher(user.getUsername()) || !isMatcher(user.getPassword())) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "请输入正确的用户名或密码！"); 
			return jsonObject.toString();
		}
		if (!isMobile(user.getPhone())) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "请输入正确的手机号码！"); 
			return jsonObject.toString();
		}
		
		User _user = userService.findUserByUsername(user.getUsername());
		
		if (_user != null) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "客官，该用户名已注册！");
			return jsonObject.toString();
		}
		
		if (!req.getSession().getAttribute("code").equals(user.getCode())) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "客官，您的验证码错误！");
			return jsonObject.toString();
		}
		req.getSession().removeAttribute("code");
		user.setCreateTime(CommonsUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		userService.addUser(user);
		req.getSession().setAttribute("user_session", user);
		jsonObject.put("status", true);
		jsonObject.put("msg", "注册成功！");
		return jsonObject.toString();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(User user, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		if (!isMatcher(user.getUsername()) || !isMatcher(user.getPassword())) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "请输入正确的用户名或密码！"); 
			return jsonObject.toString();
		}
		
		User _user = userService.findUserByUsername(user.getUsername());
		if (_user == null) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "用户名或密码错误！！");
			return jsonObject.toString();
		}
		
		if (!_user.getPassword().equals(user.getPassword())) {
			jsonObject.put("status", false);
			jsonObject.put("msg", "用户名或密码错误！");
			return jsonObject.toString();
		}
		
		req.getSession().setAttribute("user_session", _user);
		jsonObject.put("status", true);
		jsonObject.put("msg", "注册成功！");
		return jsonObject.toString();
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}
	
}