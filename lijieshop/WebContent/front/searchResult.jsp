<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城内容</title>
<script src="js/jquery-1.7.2.js"></script>
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<style>
  *{
	  padding:0;
	  margin:0;
	  background:pink;
  }
  div.item img{
    width:100%;
   }
  div#carousel-example-generic{
    width:80%;
    margin:0 auto;
  }
  li{
    list-style-type:none;
  }
  #li1 img{
     width:100%;
     height:250px;
  }
  #login{
     float:right;
     width:35%;
     height:100%;
     line-height:30px
  }
  #login li{
     float:left;
     padding:10px;
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
</style>
</head>
<body class="easyui-layout" style="width:1400px;margin:auto;text-align:center">  
       <!-- 商品展示 -->
       <div style="width:100%;float:left;height:600px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
           <h3>查找结果页</h3>
           <div style="width:90%;height:20px;text-align:right;">
               <a href="front/center.jsp">回到首页</a>
            </div>
	       <c:forEach var="g" items="${goods }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;overflow:hidden">
                  <ul>
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div id="page" style="width:100%;height:100px;float:left">
				总记录数：${totals }&nbsp;&nbsp;总页数：${pageCounts }&nbsp;&nbsp;当前页：${sp }&nbsp;&nbsp;
				<a href="searchGoods?currentPage=1&type=${type1 }">首页</a>&nbsp;&nbsp;
				<a href="searchGoods?currentPage=${sp-1 }&type=${type1 }">上一页</a>&nbsp;&nbsp;
				<form action="searchGoods?type=${type1 }" method="post" style="display: inline;">
					<input type="text" name="currentPage" size="4" value="${sp }">
				</form>
				<a href="searchGoods?currentPage=${sp+1 }&type=${type1 }">下一页</a>&nbsp;&nbsp;
				<a href="searchGoods?currentPage=${pageCounts }&type=${type1 }">末页</a>&nbsp;&nbsp;
		   </div>
       </div>   
</body>
</html>