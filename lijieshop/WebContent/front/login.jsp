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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>用户登录</title>
<link href="<%=basePath %>/front/css/common.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath %>/front/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body style="">
<!-- 頭部 -->
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="#">
				<img src="<%=basePath %>/front/images/logo.jpg" alt="商城">
			</a>
		</div>
	</div>
	<div class="span9">
        <div class="headerAd">
					<img src="images/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
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
					<a >购物指南</a>
					|
				</li>
				<li>
					<a>关于我们</a>
					
				</li>
			</ul>
		</div>
		<div class="cart">
			<a href="/car.jsp">购物车</a>
		</div>
		<div class="phone">
			客服热线:
			<strong>李先生/13633074324</strong>
		</div>
	</div>
</div>	

<!-- 登錄區 -->
<div class="container login">
		<div class="span12">
            <div class="ad">
					<img src="<%=basePath %>front/images/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">
        </div>		
      </div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>用户登录</strong>
					</div>
					<form   method="post" novalidate="novalidate" action="<%=basePath %>userLogin">
						<table>
							<tbody>
							  <tr>
							    <span style="margin-left: 20px;">${msg}</span>
								<th>
										用户账号:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" maxlength="20" placeholder="请输入用户账号">
								</td>
							</tr>
							<tr>
								<th>
									用户密码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off" placeholder="请输入用户密码">
								</td>
							</tr>
							<tr>
								<th>
								</th>
								<td>
									<input type="submit"  value="登 录">
								</td>
							</tr>
							<tr class="register">
								<th>&nbsp;
									
								</th>
								<td>
									<dl>
										<dt>还没有注册账号？</dt>
										<dd>
											立即注册即可体验在线购物！
											<a href="register.jsp">立即注册</a>
										</dd>
									</dl>
								</td>
							</tr>
						</tbody></table>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="images/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势" /></div>	
	</div>
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
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>