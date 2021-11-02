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
    <script type="text/javascript">
	    $(function(){
				window.location.href="../goodsQueryAll"; 	//直接跳转到首页
	    })
	</script>
    <script type="text/javascript" src="front/js/jquery-1.11.0.js" ></script>
	<script src="front/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="front/js/js.js" ></script>
    <link rel="stylesheet" type="text/css" href="front/css/style.css"/>
	
	<style>
	  div .item img{
	    width:100%
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
	     width:60%;
	     height:100%;
	     line-height:60px
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
	  #left{
	     line-height:20px;
	     overflow:hidden;
	  }
	  #left a{
	      text-decoration:none;
	  }
	  #right{
	     line-height:20px;
	     overflow:hidden;
	  }
	  #right a{
	      text-decoration:none;
	  }
	</style>
</head>
<body class="easyui-layout" style="height:5000px;width:1600px;margin-left:0px;text-align:center">  
    <div style="width:100%;height:50px;margin-left:100px">
       <ul>
         
       </ul>
       <ul style="" id="login">
	        <li>
	        <c:if test="${user.username==null }">
	              <strong>【您还未登录】</strong> 
	        </c:if>
	        <c:if test="${user.username!=null }">
	                              欢迎<strong style="color:red">【${user.username }】</strong>登录</li>
	        </c:if>
	        <c:if test="${user==null }">
		        <li><a href="login1">登录</a></li>
		        <li><a href="front/register.jsp">注册</a></li>
	        </c:if>
	        <c:if test="${user!=null }">
	        </c:if>
	        <li><a href="queryAll">我的收藏夹</a></li>
	        <li><a href="queryAllShop">我的购物车</a></li>
	        <li><a href="queryAllOrder">查询我的订单</a></li>
	        <li><a href="#">联系客服</a></li>
	        <li><a href="#">网站其他功能</a></li>
	        
	        <li><a href="<%=basePath %>logout">
	                     <c:if test="${user==null }"></c:if>
	                     <c:if test="${user!=null }">退出</c:if>
	              </a></li>
       </ul>
    </div>
	    <div data-options="region:'center',split:false" style="position: relative;z-index:5;">
	       <div  style="width:100%;font-size:13pt;text-align:center;margin-top:40px">
	          <form action="searchGoods">
				<span style="height:80%;width:10%;font-size:13pt;"><strong>查找类型:</strong></span>
				<select class="easyui-combobox" name="type" style="height:80%;width:10%;font-size:13pt;">
				   <option value="1">按名称查找</option>
				   <option value="2">按价格查找</option>
				</select>
				<input type="text" class="easyui-textbox" name="context" style="height:80%;width:30%;font-size:13pt;background:write;" value="${qname==null?'':qname  }">&nbsp;&nbsp;
				<input type="submit" class="iconCls:'icon-search'" value="搜索" style="height:80%;width:5%;font-size:13pt;">
		      </form>
		  </div>
       <div style="width:100%;height:370px;margin-top:50px;overflow:hidden">
       <!-- 左侧 商品-->
          <div id="left" style="width:25%;float:left;height:100%;text-align:center;">
             <h3>商家推荐</h3>
             <table style="width:100%;height:100%;">
                 <tr>
	                  <th>商品图片</th>
	                  <th>商品名称</th>
	                  <th>商品介绍</th>
	                  <th>商品价格</th>
                  </tr>
                <c:forEach items="${goods1 }" var="g1">
		                   <tr>
			                  <td><a href="goodsDetail?id=${g1.goods_id }"><img alt="" src="/lijie_shop/front/${g1.logo_path }" style="width:40px;height:40px"></a></td><td><a href="goodsDetail?id=${g1.goods_id }">${g1.goodsName }</a></td><td>${g1.introduce }</td><td>${g1.price }</td>
		                   </tr>
	                   
                </c:forEach>
             </table>
          </div>
          <!-- 中间轮播图 -->
          <div id="center" style="width:48%;float:left;height:100%;">
		    <div id="banner">
			  <div class="banner">
				<ul id="list">
					<li><a href="goodsDetail?id=1"><img src="front/images/lunbo/1.jpg"/></a></li>
					<li><a href="goodsDetail?id=1"><img src="front/images/lunbo/2.jpg"/></a></li>
					<li><a href="goodsDetail?id=1"><img src="front/images/lunbo/3.jpg"/></a></li>
					<li><a href="goodsDetail?id=1"><img src="front/images/lunbo/4.jpg"/></a></li>			
					<li><a href="goodsDetail?id=1"><img src="front/images/lunbo/5.jpg"/></a></li>
					<!--<li><img src="img/banner1.jpg"/></li>-->
				</ul>
				<ol>
					<li class="current">1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
				</ol>
			  </div>
            </div>
		  </div>
		  <!-- 右侧 商品-->
          <div id="right" style="width:25%;float:left;height:100%;text-align:center;">
             <h3>今日推荐</h3>
             <table style="width:100%;height:100%;">
                 <tr>
	                  <th>商品图片</th>
	                  <th>商品名称</th>
	                  <th>商品介绍</th>
	                  <th>商品价格</th>
                  </tr>
                <c:forEach items="${goods1 }" var="g1">
		                   <tr>
			                  <td><a href="goodsDetail?id=${g1.goods_id }"><img alt="" src="/lijie_shop/front/${g1.logo_path }" style="width:40px;height:40px"></a></td><td><a href="goodsDetail?id=${g1.goods_id }">${g1.goodsName }</a></td><td>${g1.introduce }</td><td>${g1.price }</td>
		                   </tr>
	                   
                </c:forEach>
             </table>
          </div>
       </div>
       <hr style="width:5px;" color="#33ffff">
       <!-- 商品展示 -->
       <!-- 热门商品 -->
       <div  style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
           <h3>热门商品</h3>
	         <c:forEach var="g" items="${goods1 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;overflow:hidden">
                  <ul id="hot"> 
                  <a href="goodsDetail?id=${g.goods_id }">
                  <a href="goodsDetail?id=${g.goods_id }">
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		                         <a href="goodsDetail?id=${g.goods_id }"><li>商品介绍:${g.introduce }</li></a>
		            <li>商品价格:${g.newPrice }&nbsp;｜<a href="collection?goods_id=${g.goods_id }">&nbsp;收藏</a></li>
		          </ul>
	          </div>
	         </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=1" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	        </div>
       </div>  
       <!-- 活动商品 -->
       <div style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
	        <h3>活动商品</h3>
	       <c:forEach var="g" items="${goods2 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;">
                  <ul>
                  <%-- <a href="<%=basepath %>goodsDetail?id=${g.goods_id }">
                  <a href="<%=basepath %>goodsDetail?id=${g.goods_id }"> --%>
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=2" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	         </div>
       </div> 
       <!-- 今日推荐 --> 
       <div style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
	        <h3>今日推荐</h3>
	       <c:forEach var="g" items="${goods3 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;">
                  <ul>
                  <%-- <a href="<%=basepath %>goodsDetail?id=${g.goods_id }">
                  <a href="<%=basepath %>goodsDetail?id=${g.goods_id }"> --%>
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=3" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	         </div>
       </div>  
       <!-- 猜你喜欢 -->
       <div style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
	       <h3>猜你喜欢</h3>
	       <c:forEach var="g" items="${goods4 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;">
                  <ul>
                  <%-- <a href="<%=basepath %>goodsDetail?id=${g.goods_id }">
                  <a href="<%=basepath %>goodsDetail?id=${g.goods_id }"> --%>
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=4" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	         </div>
       </div> 
       <!-- 二手 -->
       <div style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;">
	        <h3>二手商品</h3>
	       <c:forEach var="g" items="${goods5 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;">
                  <ul>
                  <%-- <a href="<%=basepath %>goodsDetail?id=${g.goods_id }">
                  <a href="<%=basepath %>goodsDetail?id=${g.goods_id }"> --%>
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=5" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	         </div>
       </div> 
       
       <!-- 其他-->
       <div style="width:100%;float:left;height:700px;text-align:center;padding-top:20px;margin-left:1%;z-index:6;position: relative;overflow:hidden">
	       <h3>其他商品</h3>
	       <c:forEach var="g" items="${goods6 }">
	          <div style="width:12%;float:left;height:300px;padding:1%;background:pink;">
                  <ul>
                  <a href="goodsDetail?id=${g.goods_id }">
                  <a href="goodsDetail?id=${g.goods_id }">
		            <a href="goodsDetail?id=${g.goods_id }"><li id="li1"><img alt="" src="/lijie_shop/front/${g.logo_path }"></li></a>
		            <a href="goodsDetail?id=${g.goods_id }"><li>${g.introduce }</li></a>
		            <li>${g.price }</li>
		          </ul>
	          </div>
	        </c:forEach>
	        <div style="width:12%;height:300px;padding:1%;background:pink;margin-top:320px;margin-left:1350px;z-index:7;position: absolute;">
                  <a href="moreGoods?type=6" style="font-size:15pt;line-height:200px;text-align:center"><strong>更多</strong></a>
	        </div>
       </div>
    </div> 
       <%@ include file="footer.jsp" %>
</body>
</html>