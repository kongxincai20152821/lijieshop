<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
	#ff{
		width:30%;
		height:auto;
		text-align:center;
		margin:auto;
		margin-top:10%
	}
	#td{
	    text-align:right
	}
	#select{
		width:100%;
		height:25px
	}
	#usertable{
	  margin:auto;
	  padding-top:10%
	}
</style>
<script type="text/javascript">
   $(function(){
	   $("#loginbtn").click(function(){
		   $("#ff").form('submit',{
			   url:'../adminLogin',/*跳转到AdminController  */
			   success:function(date){
				   var date=JSON.parse(date);
				   if(date.state==0){
					   location.href="index.jsp?userrole="+date.userrole;
				   }else{
					   $.messager.alert("提示信息","登录失败!","info");
				   }
			   }
		   });
	   });
	   
   });

</script>
</head>
<body style="background:pink;">
   <form action="#"  id="ff">
     <table class="" id="usertable">
                <tr><td  id="td">用户名称：</td><td><input  class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入用户名称'" name="username"></td></tr>
                <tr><td  id="td">用户密码：</td><td> <input class="easyui-passwordbox" data-options="prompt:'请输入用户密码'" name="password"></td></tr>
                <tr><td  id="td">用户角色：</td>
                   <td> 
                      <select name="userrole" id="select">
                         <option value="1">管理员</option>
                         <option value="2">商店老板</option>
                         <option value="3">普通员工</option>
                      </select>
                   </td>
                </tr>
                <tr><td id="td"><a id="loginbtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a></td>
                <td id="td"><a id="registerbtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">注册</a></td></tr>
     </table>
   </form>
</body>
</html>