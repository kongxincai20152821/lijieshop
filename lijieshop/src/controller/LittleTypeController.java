package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.LittleType;
import entity.Type;
import service.LittleTypeService;
import util.Pager;
@Controller
public class LittleTypeController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private LittleTypeService littleTypeService;
	
	@RequestMapping("/littleTypeAdd")
	public void add(LittleType s) throws IOException {

		littleTypeService.add(s);
		
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

	@RequestMapping("/littleTypeDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		littleTypeService.deleteMore(LittleType.class,ids);
		
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

	@RequestMapping("/littleTypeUpdate")
	public void update(LittleType LittleType,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        littleTypeService.update(LittleType.class, LittleType);	
        
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

	@RequestMapping("/littleTypeQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		LittleType LittleType=littleTypeService.queryById(LittleType.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("LittleType", LittleType);
	}
	
	@RequestMapping("/littleTypeQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qLittleId");
		String qpassword=request.getParameter("qLittleName");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<LittleType> pager=new Pager<LittleType>(littleTypeService.getTotals(qusername,qpassword),page,rows);
		
		List<LittleType> list=littleTypeService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	
	@RequestMapping("/queryLittleType")
	@ResponseBody
	public List<Map<String,Object>> queryLittleType() {
		List<LittleType> littleType=littleTypeService.queryAll();
		
		List<Map<String,Object>> list1=new ArrayList<Map<String,Object>>();
		for(LittleType ltype:littleType) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id",ltype.getLtype_id());
			map.put("value",ltype.getLtype_name().toString());
			list1.add(map);
		}
		return list1;
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
