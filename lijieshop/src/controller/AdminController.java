package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import entity.Admin;
import entity.AdminRole;
import entity.Menu;
import entity.RoleMenu;
import service.AdminRoleService;
import service.AdminService;
import service.MenuService;
import service.RoleMenuService;
import util.MenuTree;
import util.Pager;
@Controller
public class AdminController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private RoleMenuService roleMenuService;
	
	@Resource
	private MenuService menuService;
	
	@Resource
	private AdminRoleService adminRoleService;
	
	@RequestMapping("/adminAdd")
	public void add(Admin s) throws IOException {

		adminService.add(s);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "鏂板鎴愬姛!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/adminDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		adminService.deleteMore(Admin.class,ids);
		
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "鍒犻櫎鎴愬姛!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/adminUpdate")
	public void update(Admin admin,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        adminService.update(Admin.class, admin);	
        
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "淇敼鎴愬姛!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/adminQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Admin admin=adminService.queryById(Admin.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Admin", admin);
	}
	
	@RequestMapping("/adminQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Admin> pager=new Pager<Admin>(adminService.getTotals(qusername,qpassword),page,rows);
		
		List<Admin> list=adminService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	
	@RequestMapping("/adminLogin")
	public void adminLogin() throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String userrole=request.getParameter("userrole");
		
		Admin admin=adminService.queryAdmin(username,password);
		if(admin!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			session.setMaxInactiveInterval(60*30*30);
			AdminRole ar=adminRoleService.query(admin.getAdmin_id(),Integer.parseInt(userrole));
			session.setAttribute("userrole",userrole);
			if(ar!=null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter pw=response.getWriter();
				JSONObject jo=new JSONObject();
				jo.put("state",0);
				jo.put("userrole",userrole);
				String s=JSON.toJSONString(jo);
				pw.write(s);
				pw.flush();
				pw.close();
			}
		}
	}
	
	@RequestMapping("/adminLogout")
	public String adminLogout() throws ServletException, IOException {
		request.getSession().removeAttribute("admin");
		return "redirect:admin/login.jsp";
	}
	
	@RequestMapping("/MenuTreequery2")
	public void MenuTreequery2() throws IOException, SQLException {
		String userrole = request.getParameter("userrole");
		int userrole1 = 0;
		if (userrole == null || userrole.equals("")) {
			userrole = "1";
			userrole1 = Integer.parseInt(userrole);
		} else {
			userrole1 = Integer.parseInt(userrole);
		}
		List<Menu> menu = new ArrayList<Menu>();
		List<RoleMenu> list = roleMenuService.queryByRoleId(userrole1);
		for(int i=0;i<list.size();i++) {
			RoleMenu m=list.get(i);
			int mid = m.getMid();
			Menu list1 = menuService.queryByMid(mid);
			menu.add(list1);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		MenuTree mt = new MenuTree();
		mt.setList(menu);
		String json = mt.getSys_MenuTreeJson();
		System.out.println(json);
		pw.write(json);
		pw.flush();
		pw.close();
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
