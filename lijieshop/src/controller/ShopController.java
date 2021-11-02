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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Goods;
import entity.Shop;
import entity.User;
import service.GoodsService;
import service.ShopService;
import service.UserService;
import util.Pager;
@Controller
public class ShopController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private ShopService shopService;
	private GoodsService goodsService;
	private UserService userService;
	
	@RequestMapping("/shopAdd")
	public void add(Shop s) throws IOException {

		shopService.add(s);
		
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

	@RequestMapping("/shopDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		shopService.deleteMore(Shop.class,ids);
		
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

	@RequestMapping("/shopUpdate")
	public void update(Shop Shop,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        shopService.update(Shop.class, Shop);	
        
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

	@RequestMapping("/shopQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Shop Shop=shopService.queryById(Shop.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Shop", Shop);
	}
	
	@RequestMapping("/shopQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qShopId");
		String qpassword=request.getParameter("qUserId");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Shop> pager=new Pager<Shop>(shopService.getTotals(qusername,qpassword),page,rows);
		
		List<Shop> list=shopService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	@RequestMapping(value="/addShop")
	public String add(String goods_id,String number,String goodsName,String newPrice,String logo_path) throws IOException {
		
		Shop shop=new Shop();
		User user=(User)request.getSession().getAttribute("user");
		if(user==null) {
			return "redirect:logout";
		}
        if(user!=null) {
        	shop.setUser_id(user.getUser_id());
        }
        shop.setGoods_id(Integer.parseInt(goods_id));
        shop.setGoodsName(goodsName);
        shop.setPrice(Integer.parseInt(newPrice));
        shop.setNumber(Integer.parseInt(number));
        shop.setLogo_path(logo_path);
		shopService.add(shop);
		return "forward:queryAllShop";
	}
	
	@RequestMapping("/queryAllShop")
	public void queryAllShop() throws IOException, ServletException {
		try{
			User user=(User)request.getSession().getAttribute("user");
			int user_id=user.getUser_id();
			
			List<Shop> shop=shopService.queryAllPrice(user_id);
			int allPrice=0;
			for(int i=0;i<shop.size();i++) {
				allPrice+=shop.get(i).getNumber()*shop.get(i).getPrice();
			}
			request.setAttribute("shop", shop);
			request.setAttribute("allPrice", allPrice);
			
			request.getRequestDispatcher("front/car.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("front/login.jsp");
		}
	}
	
	@RequestMapping("/shopDelete")
	public String delete(String shop_id) throws IOException {		
		shopService.delete(Integer.parseInt(shop_id));
        return "redirect:queryAllShop";
	}
	
	@RequestMapping("/clearShop")
	public String clearShop() throws IOException {	
		User user=(User)request.getSession().getAttribute("user");
		shopService.deleteShop(user.getUser_id());
        return "redirect:queryAllShop";
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
