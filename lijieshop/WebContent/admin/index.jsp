<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<style type="text/css">
    *{
        margin:0;
        padding:0;
        list-style: none;
    }
	#top{
		width:100%;
		height:100%;
		line-height:10px;
		margin-top: 0px
	}
      #login{
	     float:right;
	     width:40%;
	     height:100%;
	     line-height:20px;
	     font-size:12pt;
	  }
	  #login li{
	     float:left;
	     padding:10px;
	     margin-top:15px
	  }
	  #login li a{
	   color:blue;
	   text-decoration:none;
	   font-weight:bold;
	  }
	  #login li a:hover{
	   color:black;
	   text-decoration:underline;
	  }
	  #welcome{
	   text-align:center;
	   font-size: 20px;
	  }
</style>
<script type="text/javascript">
	
	$(function(){
		     var userrole='<%=request.getParameter("userrole")%>';
			 $("#nav").tree({
				 url:"../MenuTreequery2?userrole="+userrole,/* 跳转到MenuTreeController */
				 method:'get',
				 onClick: function(node){// 在用户点击的时候提示
				 	var title = node.text;
					var url = node.attributes.url;
					if(title&&url!=''){
						if($('#tt').tabs('exists',title)){//选项页存在
							$('#tt').tabs('select',title);//选中
						}else{
							$('#tt').tabs('add',{    
							    title:title,    
							    content:"<iframe src='"+url+"' style='width: 100%;height: 100%' frameborder='0'></iframe>",
							    closable:true 
							});
						}
					}
				 }
			 });
	});	
</script>
</head>
<body class="easyui-layout">
	<div id="cc" class="easyui-layout" fit="true">   
	    <div data-options="region:'north',split:false,border:false" style="height:8%;width:90%">
	    	<div id="top">
		       <ul id="login">
			        <li>
				        <c:if test="${admin.ausername==null }">
				              <strong>【您还未登录】</strong> 
				        </c:if>
				        <c:if test="${admin.ausername!=null }">
				                              欢迎<strong style="color:red">【${admin.ausername }】</strong>登录
				        </c:if>
			        </li>
			         <c:if test="${admin==null }">
				        <li><a href="login.jsp">登录</a></li>
			        </c:if>
			        <li><a href="#">联系客服</a></li>
			        <li><a href="#">网站其他功能</a></li>
			        
			        <li>
			              <a href="../adminLogout">
			                     <c:if test="${admin==null }"></c:if>
			                     <c:if test="${admin!=null }">退出</c:if>
			              </a>
			        </li>
		       </ul>
            </div>
	    </div> 
	      
	    <div data-options="region:'south',border:false,split:false" style="height:100px;">
	        网站备案
	    </div>
	       
	    <div data-options="region:'west',title:'导航菜单',iconCls:'icon-save',split:false" style="width:150px;">
	       <c:if test="${admin!=null }">
		    	<ul class="easyui-tree" fit="true" id="nav">
	          	</ul>
           </c:if>
	    </div>   
	    
	    <div data-options="region:'center'">
	    	<div id="tt" class="easyui-tabs" fit="true" border="false">   
			    <div title="欢迎页" id="welcome">   
			         	欢迎使用XXX系统后台管理界面！ 
			    </div>
			</div>
	    </div>   
	</div>
</body>
</html>