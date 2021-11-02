<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>商城</title>
<link href="front/css/common.css" rel="stylesheet" type="text/css"/>
<link href="front/css/product.css" rel="stylesheet" type="text/css"/>
<script src="front/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$("#increase").click(function(e){
			var val = $("#number").val();
			$("#number").val(++val);
		});
		$("#decrease").click(function(e){
			var val = $("#number").val();
			if(val > 1){
				$("#number").val(--val);
			}
		});	
	});	 
</script>
</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="front/images/logo.jpg" alt="商城" />
			</a>
		</div>
	</div>
	<div class="span9">
          <div class="headerAd">
					<img src="front/images/header.jpg" alt="正品保障" title="正品保障" height="50" width="320" />
          </div>	
    </div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<c:if test="${sessionScope.frontuser!=null}">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="javascript:void()">${sessionScope.frontuser}</a>|
					</li>
				</c:if>	
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a href="./index.htm">[退出]</a>|
				</li>
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
			<a href="<%=basePath %>/front/car.jsp">购物车</a>
		</div>
		<div class="phone">
			客服热线:
			<strong>13633074324</strong>
		</div>
	</div>
</div> 
<div class="container productContent">
		<div class="span6">
		</div>
		<div class="span18 last">
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" rel="gallery">
						<div class="zoomPad">
						   <img style="opacity: 1;" title="" class="medium" src="front/${goods.logo_path}"/>
						   <div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div>
						   <div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow">
							   <div style="width: 368px;" class="zoomWrapper">
								       <div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div>
									   <div style="width: 0%; height: 0px;" class="zoomWrapperImage">
									       <img src="front/${goods.logo_path}" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"/>
									   </div>
						       </div>
						       <div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div>
						    </div>
						</div>
					</a>
			</div>
			<div class="name">${goods.goodsName}</div>
			<div class="sn">
				<div>编号：${goods.goods_id}</div>
			</div>
			<div class="info">
				<dl>
					<dt>现价:</dt>
					<dd>
						<strong>￥：${goods.newPrice}元/份</strong>
							原 价：
							<del>￥${goods.price}元/份</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
				<div class="action">
					<form action="<%=basePath %>addShop" method="post">
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
							<input type="hidden" name="logo_path" value="${goods.logo_path}"/>
							<input type="hidden" name="newPrice" value="${goods.newPrice}"/>
							<input type="hidden" name="goodsName" value="${goods.goodsName}"/>
							<input type="hidden" name="goods_id" value="${goods.goods_id}"/>
								<input id="number" name="number" value="1" maxlength="4" onpaste="return false;" type="text"/>
								<div>
									<span id="increase" class="increase">&nbsp;</span>
									<span id="decrease" class="decrease">&nbsp;</span>
								</div>
							</dd>
							<dd>
								件
							</dd>
						</dl>
					    <input id="addCart" class="addCart" value="加入购物车" type="submit"/>
					</form>
				</div>
				<div id="bar" class="bar">
					<ul>
							<li id="introductionTab">
								 商品介绍
							</li>
							<li id="introductionTab">
								<a href="queryAllComment?goods_id=${goods.goods_id }">客户留言</a>
							</li>
							<li id="introductionTab">
								<a href="front/addComment.jsp">发表评论</a>
							</li>
					</ul>
				</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div>
						${goods.introduce}
					</div>
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
			<img src="front/images/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"/>
        </div>
    </div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
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
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2016 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>