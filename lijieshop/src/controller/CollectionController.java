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

import entity.Collection;
import entity.Goods;
import entity.User;
import service.CollectionService;
import service.GoodsService;
import util.Pager;
@Controller
public class CollectionController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private CollectionService collectionService;
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("/collectionAdd")
	public void add(Collection s) throws IOException {

		collectionService.add(s);
		
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

	@RequestMapping("/collectionDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		collectionService.deleteMore(Collection.class,ids);
		
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

	@RequestMapping("/collectionUpdate")
	public void update(Collection Collection,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        collectionService.update(Collection.class, Collection);	
        
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

	@RequestMapping("/collectionQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Collection Collection=collectionService.queryById(Collection.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Collection", Collection);
	}
	
	@RequestMapping("/collectionQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qCid");
		String qpassword=request.getParameter("qUserId");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Collection> pager=new Pager<Collection>(collectionService.getTotals(qusername,qpassword),page,rows);
		
		List<Collection> list=collectionService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	
	@RequestMapping("/collectionDelete")
	public String delete() throws IOException {
		String cid=request.getParameter("cid");
		String goods_id=request.getParameter("goods_id");
		
		collectionService.delete(Integer.parseInt(cid));
		request.setAttribute("goods_id", goods_id);
        return "redirect:queryAll";
	}
	
	@RequestMapping("/collection")
	public String collection() throws IOException, ServletException {
		String goods_id=request.getParameter("goods_id");
		Goods goods=(Goods)goodsService.queryById(Goods.class, Integer.parseInt(goods_id));
		User user=(User)request.getSession().getAttribute("user");
		Collection c=new Collection();
	    c.setGoods_id(goods.getGoods_id());
	    c.setUser_id(user.getUser_id());
	    c.setGoodsName(goods.getGoodsName());
	    c.setPrice(goods.getPrice());
	    c.setNewPrice(goods.getNewPrice());
	    c.setIntroduce(goods.getIntroduce());
	    c.setLogo_path(goods.getLogo_path());
	    
		collectionService.add(c);
		
		return "redirect:queryAll";
	}
	
	@RequestMapping("/queryAll")
	public void queryAll() throws IOException, ServletException {
		try {
			User user=(User)request.getSession().getAttribute("user");
			List<Collection> collection=collectionService.queryAll(user.getUser_id());
			request.setAttribute("collection",collection);
			request.getRequestDispatcher("front/collection.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("front/login.jsp");
		}
	}
	
	
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
