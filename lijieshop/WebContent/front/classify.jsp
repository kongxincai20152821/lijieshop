<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品分类页面</title>
<style type="text/css">
 #content{
	 width:12%;
	 float:left;
	 height:300px;
	 padding:1%;
 }
</style>
</head>
<body class="easyui-layout" fit="true">
	<div fit="true">
	     <table fit="true" border="1"> 
	         <tr id="header">
	            <th>综合</th>
	            <th>人气</th>
	            <th>新品</th>
	            <th>销量</th>
	            <th>价格</th>
	            <th><input></th>
	            <th><input></th>
	         </tr>
	         <tr id="content">
	            <td>
                  <ul>
		            <li id="li1"><a href="#"><img alt="" src="images/2.jpg"></a></li>
		            <li><a href="">商品介绍</a></li>
		            <li>
		               <dl>
		                  <dd>评价</dd>
		                  <dd>已卖出</dd>
		                  <dd>剩余</dd>
		                  <dd>价格</dd>
		               </dl>
		            </li>
		          </ul>
	            </td>
	            <td>2</td>
	            <td>3</td>
	            <td>4</td>
	            <td>5</td>
	            <td>6</td>
	         </tr>
	     </table>
	</div>
</body>
</html>