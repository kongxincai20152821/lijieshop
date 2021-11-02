package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Goods;
import service.GoodsService;
import util.Pager;
@Controller
public class GoodsController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goodsAdd")
	public void add(Goods s) throws IOException {
        
		goodsService.add(s);
		
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

	@RequestMapping("/goodsDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		goodsService.deleteMore(Goods.class,ids);
		
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

	@RequestMapping("/goodsUpdate")
	public void update(Goods Goods,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        goodsService.update(Goods.class, Goods);	
        
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

	@RequestMapping("/goodsQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Goods Goods=goodsService.queryById(Goods.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Goods", Goods);
	}
	
	@RequestMapping("/admin/goodsQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qGoodsId=request.getParameter("qGoodsId");
		String qGoodsName=request.getParameter("qGoodsName");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Goods> pager=new Pager<Goods>(goodsService.getTotals(qGoodsId,qGoodsName),page,rows);
		
		List<Goods> list=goodsService.queryByPage(pager.sp,pager.pageSize,qGoodsId,qGoodsName);
		map.put("qGoodsId", qGoodsId);
		map.put("qpassword", qGoodsName);
		
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
	
	@RequestMapping("/goodsQueryAll")
	public void queryAll() throws IOException, ServletException {
		//Pager<Goods> pager=new Pager<Goods>(goodsService.getTotals());
		
		List<Goods> list1=goodsService.queryByType(1);
		List<Goods> list2=goodsService.queryByType(2);
		List<Goods> list3=goodsService.queryByType(3);
		List<Goods> list4=goodsService.queryByType(4);
		List<Goods> list5=goodsService.queryByType(5);
		List<Goods> list6=goodsService.queryByType(6);
		//List<Goods> list1=goodsService.queryByType1();
		System.out.println(list1);
		request.setAttribute("goods1",list1);
		request.setAttribute("goods2",list2);
		request.setAttribute("goods3",list3);
		request.setAttribute("goods4",list4);
		request.setAttribute("goods5",list5);
		request.setAttribute("goods6",list6);
		request.getRequestDispatcher("front/center.jsp").forward(request, response);
	}
	
	@RequestMapping(value="/goodsDetail",method=RequestMethod.GET)
	public String goodsDetail(String id,ModelMap map) throws ServletException, IOException {	
		Goods goods=goodsService.queryById(Goods.class,id);
		map.addAttribute("goods", goods);
		
		request.getSession().setAttribute("goods",goods);
		return "front/detail";
	}
	
	@RequestMapping("/goodsShop")
	public void goodsShop(String id,int number) throws ServletException, IOException {	
		Goods goods=goodsService.queryById(Goods.class,id);
		request.setAttribute("goods",goods);
		System.out.println(number);
		request.setAttribute("number",number);
		request.getRequestDispatcher("front/car.jsp").forward(request, response);
	}
	
	@RequestMapping("/goodsBuy")
	public void goodsBuy(String id) throws ServletException, IOException {	
		Goods goods=goodsService.queryById(Goods.class,id);
		request.setAttribute("goods",goods);
		request.getRequestDispatcher("front/order.jsp").forward(request, response);
	}
	@RequestMapping("/goodsOrder")
	public void goodsOrder(String id,int order) throws ServletException, IOException {	
		Goods goods=goodsService.queryById(Goods.class,id);
		request.setAttribute("goods",goods);
		request.setAttribute("order",order);
		request.getRequestDispatcher("front/order_address.jsp").forward(request, response);
	}
	@RequestMapping("/goodsPay")
	public void goodsPay(String id,int order) throws ServletException, IOException {	
		Goods goods=goodsService.queryById(Goods.class,id);
		request.setAttribute("goods",goods);
		request.setAttribute("order",order);
		request.getRequestDispatcher("front/payment.jsp").forward(request, response);
	}
	
	@RequestMapping("/searchGoods")
	public void searchAll(String type,String context) throws IOException, ServletException {
		String currentPage=request.getParameter("currentPage");
		int type1=Integer.parseInt(type);
		if("".equals(currentPage)||currentPage==null||currentPage=="0") {
			currentPage="1";
		}
		int sp=Integer.parseInt(currentPage);
		int pageSize=20;
		String goodsName=null;
		int price=0;
		List<Goods> list=null;
		int totals=0;
		if(type1==1) {
			goodsName=context;
			list=goodsService.queryByCondition(goodsName,price,sp,pageSize);
			totals=goodsService.queryTotals(goodsName,price);
		}
		if(type1==2) {
			if(!"".equals(price)) {
				try {
			      price=Integer.parseInt(context);
				}catch(Exception e) {
					response.sendRedirect("front/searchError.jsp");
				}
			}
			list=goodsService.queryByCondition(goodsName,price,sp,pageSize);
			totals=goodsService.queryTotals(goodsName,price);
		}
		int pageCounts=totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		if(sp>pageCounts) {
			sp=pageCounts;
		}
		if(sp<=0) {
			sp=1;
		}
		request.setAttribute("goods", list);
		request.setAttribute("totals", totals);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		request.setAttribute("type1", type1);
		request.getRequestDispatcher("front/searchResult.jsp").forward(request, response);
	}
	
	@RequestMapping("/moreGoods")
	public void moreGoods(String type) throws IOException, ServletException {
		List<Goods>	list=goodsService.queryByType(Integer.parseInt(type));
		request.setAttribute("goods", list);
		request.getRequestDispatcher("front/searchResult.jsp").forward(request, response);
	}
	
	@RequestMapping("/login1")
	public String login1() throws IOException, ServletException {
		return "redirect:front/login.jsp";
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
