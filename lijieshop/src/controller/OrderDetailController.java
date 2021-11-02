package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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

import entity.OrderDetail;
import service.OrderDetailService;
import util.Pager;
@Controller
public class OrderDetailController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/orderDetailAdd")
	public void add(OrderDetail s) throws IOException {

		orderDetailService.add(s);
		
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

	@RequestMapping("/orderDetailDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		orderDetailService.deleteMore(OrderDetail.class,ids);
		
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

	@RequestMapping("/orderDetailUpdate")
	public void update(OrderDetail OrderDetail,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        orderDetailService.update(OrderDetail.class, OrderDetail);	
        
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

	@RequestMapping("/orderDetailQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		OrderDetail OrderDetail=orderDetailService.queryById(OrderDetail.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("OrderDetail", OrderDetail);
	}
	
	@RequestMapping("/orderDetailQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qOrderId");
		String qpassword=request.getParameter("qGoodsId");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<OrderDetail> pager=new Pager<OrderDetail>(orderDetailService.getTotals(qusername,qpassword),page,rows);
		
		List<OrderDetail> list=orderDetailService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
