package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import entity.Admin;
import entity.User;

public class CheckUserLoginInterceptor  extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex==null) {
			response.sendRedirect(request.getContextPath()+"/front/login.jsp");
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String s=request.getRequestURI();
		if(s.indexOf("images")>=0||s.indexOf("js")>=0||s.indexOf("css")>=0) {
			return true;
		}
		if(s.indexOf("comment")>=0||s.indexOf("collection")>=0||s.indexOf("admin")>=0||s.indexOf("order")>=0||s.indexOf("discount")>=0||s.indexOf("goods")>=0||s.indexOf("littleType")>=0||s.indexOf("orderDetail")>=0||s.indexOf("shop")>=0||s.indexOf("superType")>=0||s.indexOf("user")>=0) {
			return true;
		}
		if(s.indexOf("userLogin")>=0||s.indexOf("register")>=0||s.indexOf("goodsQueryAll")>=0||s.indexOf("goodsDetail")>=0||s.indexOf("adminLogin")>=0||s.indexOf("adminLogout")>=0||s.indexOf("MenuTreequery2")>=0) {
			return true;
		}
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/front/login.jsp");
			return false;
		}
		return true;
	}
   
}
