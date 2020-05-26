package com.dhf.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dhf.model.User;

public class AuthInterceptor extends HandlerInterceptorAdapter{
  @Override
public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
	  HandlerMethod handlerMethod = (HandlerMethod) handler;
	  String methodName=handlerMethod.getMethod().getName();
	  if(!methodName.equals("index")&&!methodName.equals("login")){
		  HttpSession session=request.getSession(true);
		  User loginUser=(User)session.getAttribute("loginUser");
		  if(loginUser==null){
			  response.sendRedirect(request.getContextPath()+"/");
		  }
	  }
	  return super.preHandle(request, response, handler);
}
}
