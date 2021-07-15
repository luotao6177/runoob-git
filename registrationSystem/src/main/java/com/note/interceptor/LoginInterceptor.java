package com.note.interceptor;

 
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��¼��֤��������
 */
public class LoginInterceptor implements HandlerInterceptor{

 
	/**
	 * Handlerִ�����֮������������
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {
			//System.out.println("afterCompletion run!");
	}


	/**
	 * Handlerִ��֮��ModelAndView����֮ǰ�����������
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
			//System.out.println("postHandle run!");
	}

 

	/**
	 * Handlerִ��֮ǰ�����������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//System.out.println("preHandle run!");
		return true;
	}
}

