<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>  
    <form action="../addComment" style="width:30%;height:400px;margin:auto;">
        <table>
	         <%-- <tr><td></td>&nbsp;&nbsp;&nbsp;&nbsp;<td><input type="hidden" name="goods_id" value="${goods_id }"></td></tr><br><br><br> --%>
	         <tr><td>评论标题:</td>&nbsp;&nbsp;&nbsp;&nbsp;<td><input type="text" name="title"></td></tr><br><br><br>
	         <tr><td>评论内容:</td>&nbsp;&nbsp;&nbsp;&nbsp;<td><textarea rows="10" cols="30" name="content"></textarea></td></tr>
	         <tr><td></td><td><input type="submit" value="发表"></td></tr>
        </table>
    </form>
</body>
</html>