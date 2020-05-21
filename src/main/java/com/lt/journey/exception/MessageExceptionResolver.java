package com.lt.journey.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MessageExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler,	Exception e) {
		ModelAndView mav = new ModelAndView();
		
//		System.out.println(e.getMessage());
        e.printStackTrace();
		if (e instanceof MessageException) {
			mav.addObject("msg", e.getMessage());
			mav.setViewName("msg");
		}else {
			mav.addObject("msg", "Server Internal Error");
			mav.setViewName("msg");
		}
		
		return mav;
	}

}
