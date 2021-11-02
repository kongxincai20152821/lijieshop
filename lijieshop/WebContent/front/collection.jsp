<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ page import="cn.edu.nuc.shop.entiry.Forder"
   %> --%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%

/* Object exituser= session.getAttribute("frontuser"); */
//Forder forder = (Forder)session.getAttribute("forder");



%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>

<link href="front/css/common.css" rel="stylesheet" type="text/css">
<link href="front/css/cart.css" rel="stylesheet" type="text/css">


</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="front/images/logo.jpg" alt="商城">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="front/images/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
					<%-- <c:if test="${sessionScope.frontuser==null}">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="<%=basePath %>/user/login">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="<%=basePath %>/user/toregist">注册</a>|
				</li>
			</c:if>	 --%>
				<%-- <c:if test="${sessionScope.frontuser!=null}">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="javascript:void()">${sessionScope.frontuser}</a>|
					</li>
				</c:if>	 --%>
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a href="./index.htm">[退出]</a>|
				</li>
						<!-- <li>
							<a >会员中心</a>
							|
						</li> -->
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a href="<%=basePath %>/car.jsp">购物车</a>
		</div>
		<div class="phone">
			客服热线:
			<strong>96008/53277764</strong>
		</div>
	</div>
	<%-- <div class="span24">
	<ul class="mainNav">
						<li>
						<a href="<%=basePath %>/product/frontlist">首页</a>
						|
					</li>
					<li>
						<a >男士休闲</a>
						|
					</li>
					<li>
						<a >女士休闲</a>
						|
					</li>
					<li>
						<a>商城积分</a>
						|
					</li>
					<li>
						<a>儿童休闲</a>
						|
					</li>
					<li>
						<a>老人休闲</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					
		</ul>
	</div> --%>
	
</div>	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				
			</div>
				<table>
					<tbody><tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${collection}" var="collection">
						<tr>
							<td width="60">
								<input type="hidden" name="cid" value="${collection.cid}">
								<img src="/lijie_shop/front/${collection.logo_path}">
							</td>
							<td>
								<a target="_blank">${collection.goodsName}</a>
							</td>
							<td>
								￥${collection.price}
							</td>
							<td>
								<a href="collectionDelete?cid=${collection.cid}&goods_id=${collection.goods_id}" class="delete" >删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody></table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<c:if test="${sessionScope.forder==null}">
					<!-- <h1 style="margin: 50px 300px;">还没有添加商品！</h1> -->
				</c:if>
				<%-- <c:if test="${sessionScope.forder!=null}"> --%>
					<div class="total">
						<em id="promotion"></em>
						<%-- 商品金额: <strong id="effectivePrice">￥${allPrice}元</strong> --%>
					</div>
					<div class="bottom">
						<%-- <a href="clearShop" id="clear" class="clear">清空购物车</a>
						<a href="addOrder?allPrice=${allPrice}" id="submit" class="submit">提交订单</a> --%>
					</div>
				<%-- </c:if> --%>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="front/images/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2016 网上商城 版权所有</div>
	</div>
</div>
</body></html>