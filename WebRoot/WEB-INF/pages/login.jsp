<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/css/default.css" />
<link rel="stylesheet" type="text/css" href="/css/public.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代理商管理系统</title>
</head>
<body>
<div class="head">
	<h1>AgentSystem|代理商管理系统<span>v1.0</span></h1>

</div>
<div class="container">
	





<form action="/login.action" method="post" onsubmit="return validateLoginUserFunc()">
	<ul>
	
	
	<li>用户名：<input type="text"   name="user.userCode" id="usercode"> 
	<li>用户密码：<input type="password" name="user.userPassword" id="password"> 
	<li><input type="submit" value="登录">&nbsp;&nbsp;
	<input type="reset" value="重置">
	
	</ul>
</form>

</div>


<jsp:include page="/inc/foot.jsp"></jsp:include>
<div></div>
</body>
</html>