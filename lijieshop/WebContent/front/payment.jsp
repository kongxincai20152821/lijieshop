<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付页面</title>
<script type="text/javascript">
	function truePay(){
		   window.location.href="addOrder2";
	}
</script>
</head>
<body class="easyui-layout" fit="true">
   <div  fit="true">
     <div>
                   二维码
     </div>
     <button onclick="javascript:truePay()">确认支付</button>
   </div>
</body>
</html>