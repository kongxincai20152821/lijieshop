package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.User;
import service.UserService;
import util.Pager;
@Controller
public class UserController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/userAdd")
	public void add(User s) throws IOException {

		userService.add(s);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "新增成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/userDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		userService.deleteMore(User.class,ids);
		
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "删除成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/userUpdate")
	public void update(User User,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        userService.update(User.class, User);	
        
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "修改成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/userQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		User User=userService.queryById(User.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("User", User);
	}
	
	@RequestMapping("/userQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qUserId");
		String qpassword=request.getParameter("qTrueName");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<User> pager=new Pager<User>(userService.getTotals(qusername,qpassword),page,rows);
		
		List<User> list=userService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("total", pager.totals);
		jo.put("rows", list);
		String s=JSON.toJSONString(jo);
		pw.write(s);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/userLogin")
	public String login(Map<String,Object> map) throws IOException, ServletException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	    User user=userService.queryUser(username,password);
	
		if(user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			session.setMaxInactiveInterval(60*30*30);
			
			return "redirect:goodsQueryAll";
		}
		return "redirect:front/login.jsp";
	}
	
	@RequestMapping("/register")
	public String register(Map<String,Object> map) throws IOException, ServletException {
		String username=request.getParameter("username");
		String trueName=request.getParameter("trueName");
		String password=request.getParameter("password");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		String postCode=request.getParameter("postCode");
		String IDcardType=request.getParameter("IDcardType");
		String IDcardNo=request.getParameter("IDcardNo");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		User user=new User();
		user.setUsername(username);
		user.setTrueName(trueName);
		user.setPassword(password);
		user.setCity(city);
		user.setAddress(address);
		user.setPostCode(Integer.parseInt(postCode));
		user.setIDcardType(Integer.parseInt(IDcardType));
		user.setIDcardNo(Integer.parseInt(IDcardNo));
		user.setPhone(Integer.parseInt(phone));
		user.setEmail(email);
		user.setDiscount_id(1);
		user.setBalance(0);
		user.setUser_state(1);
		try {
	       userService.add(user);
		}catch(Exception e) {
			return "redirect:front/register.jsp";
		}
		return "redirect:front/login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(Map<String,Object> map) throws IOException, ServletException {
        request.getSession().removeAttribute("user");
		return "redirect:front/login.jsp";
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
