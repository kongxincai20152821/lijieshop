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

import entity.Comment;
import entity.Goods;
import entity.User;
import service.CommentService;
import util.Pager;
@Controller
public class CommentController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping("/commentAdd")
	public void add(Comment s) throws IOException {

		commentService.add(s);
		
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

	@RequestMapping("/commentDeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		commentService.deleteMore(Comment.class,ids);
		
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

	@RequestMapping("/commentUpdate")
	public void update(Comment Comment,String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
        commentService.update(Comment.class, Comment);	
        
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

	@RequestMapping("/commentQueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qusername=request.getParameter("qusername");
		String qpassword=request.getParameter("qpassword");
		
		Comment Comment=commentService.queryById(Comment.class,id);
		map.put("qusername", qusername);
		map.put("qpassword", qpassword);
		map.put("Comment", Comment);
	}
	
	@RequestMapping("/commentQueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		String qusername=request.getParameter("qCommentId");
		String qpassword=request.getParameter("qUserId");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		Pager<Comment> pager=new Pager<Comment>(commentService.getTotals(qusername,qpassword),page,rows);
		
		List<Comment> list=commentService.queryByPage(pager.sp,pager.pageSize,qusername,qpassword);
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
	
	@RequestMapping("/queryAllComment")
	public String queryAllComment() throws IOException, ServletException {
		String currentPage=request.getParameter("currentPage");
		String goods_id=request.getParameter("goods_id");
		if("".equals(currentPage)||currentPage==null||currentPage=="0") {
			currentPage="1";
		}
		if("".equals(goods_id)||goods_id==null||goods_id=="0") {
			goods_id="1000000000";
		}
		int sp=Integer.parseInt(currentPage);
		int pageSize=20;
		List<Comment> list=null;
		int totals=0;
		list=commentService.queryAllComment(Integer.parseInt(goods_id),sp,pageSize);
		totals=commentService.getCommentTotals(Integer.parseInt(goods_id));
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
		request.setAttribute("comment", list);
		request.setAttribute("totals", totals-1);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		return "front/comment";
	}
	
	@RequestMapping("/addComment")
	public String addComment() throws IOException {
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        HttpSession session=request.getSession();
        Comment c=new Comment();
        Goods goods=(Goods)session.getAttribute("goods");
        c.setGoods_id(goods.getGoods_id());
        session.removeAttribute("goods");
        User user=(User)session.getAttribute("user");
        if(user==null) {
        	response.sendRedirect("front/login.jsp");
        }
        c.setUser_id(user.getUser_id());
        c.setTitle(title);
        c.setContent(content);
        c.setPublish_time(new Date());
		commentService.add(c);
		
        return "front/comment";
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
