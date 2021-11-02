package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  this.response=response;
		  this.request=request;
	  } 
 
  @RequestMapping("/upload")
  public String uploadFile(@RequestParam("file")MultipartFile files[]) throws IllegalStateException, IOException {
	  String path=request.getSession().getServletContext().getRealPath("/upload/");
	  //String path=request.getContextPath()+"/images/";
	  for(MultipartFile file:files) {
		  if(!file.isEmpty()) {
			  System.out.println("鏂囦欢鍚嶇О锛�"+file.getOriginalFilename()+"\n鏂囦欢璺緞锛�"+path);
			  //鏂囦欢淇濆瓨
			  file.transferTo(new File(path,file.getOriginalFilename()));
		  }
	  }
	  return "admin/index.jsp";
  }  
  //閲嶅畾鍚�
  /*@ExceptionHandler
  public ModelAndView exceptionAndError(Exception ex) throws IllegalStateException, IOException {
	  ModelAndView mav=new ModelAndView("redirect:exception.jsp");
	  //mav.addObject("exception",ex);
	  return mav;
  }*/
}
