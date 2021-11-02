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

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Order;
import entity.User;
import service.OrderService;
import service.ShopService;
import util.Pager;
@Controller
public class OrderController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private OrderService orderService;
	//private ShopService shopService;
	
	@RequestMapping("/orderAdd")
	public void add(Order s) throws IOException {

		orderService.add(s);
		
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

	@RequestMapping("/orderDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		orderService.deleteMore(Order.class,ids);
		
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

	@RequestMapping("/orderUpdate")
	public void update(Order Order,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        orderService.update(Order.class, Order);	
        
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

	@RequestMapping("/orderQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Order Order=orderService.queryById(Order.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Order", Order);
	}
	
	@RequestMapping("/orderQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qOrderId");
		String qpassword=request.getParameter("qUserId");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Order> pager=new Pager<Order>(orderService.getTotals(qusername,qpassword),page,rows);
		
		List<Order> list=orderService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	
	@RequestMapping("/addOrder")
	public void addOrder() throws IOException, ServletException {
        String allPrice=request.getParameter("allPrice");
		User user=(User)request.getSession().getAttribute("user");
		String trueName=user.getTrueName();
		String address=user.getAddress();
		int phone=user.getPhone();
		int postCode=user.getPostCode();
		
		request.setAttribute("allPrice", allPrice);
		request.setAttribute("trueName", trueName);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		request.setAttribute("postCode", postCode);
		request.getRequestDispatcher("front/order.jsp").forward(request, response);
	}
	
	@RequestMapping("/addOrder1")
	public void addOrder1() throws IOException, ServletException {
        //String allPrice=request.getParameter("allPrice");
        String recevieName=request.getParameter("recevieName");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String remark=request.getParameter("remark");
        String allPrice=request.getParameter("allPrice");
		User user=(User)request.getSession().getAttribute("user");
		int user_id=user.getUser_id();
		Order order=new Order();
		order.setUser_id(user_id);
		order.setOrder_username("通用商城订单");
		order.setRecevieName(recevieName);
		order.setAddress(address);
		order.setPhone(Integer.parseInt(phone));
		order.setOrderDate(new Date());
		order.setMessage(remark);
		order.setPrice(Integer.parseInt(allPrice));
		request.getSession().setAttribute("order",order);
        //orderService.add(order);
		request.getRequestDispatcher("front/payment.jsp").forward(request, response);
	}
	
	@RequestMapping("/addOrder2")
	public void addOrder2() throws IOException, ServletException {
		Order order=(Order)request.getSession().getAttribute("order");
		orderService.add(order);
		
		request.getRequestDispatcher("front/pay_success.jsp").forward(request, response);
	}
	
	@RequestMapping("/queryAllOrder")
	public void queryAllOrder() throws IOException, ServletException {
		try {
			User user=(User)request.getSession().getAttribute("user");
			List<Order> list=orderService.queryAll(user.getUser_id());
			request.setAttribute("order",list);
			request.setAttribute("trueName",user.getTrueName());
			
	        request.getRequestDispatcher("front/my_order.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("front/login.jsp");
		}
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
