<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link id='theme' rel='stylesheet' href='/humane/themes/original.css'/>
<script src='/humane/humane.js'></script>
<link rel="stylesheet" type="text/css" href="/css/loglist.css" />
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="/css/public.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/public.js"></script>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
</head>
<body>
<div class="mbxnav">
帐号:[<s:property value="user.userCode" />]LOG操作日志
</div>

<div class="container">
	<div class="seracheruserdiv ope">
		<ul>
			<li>
				<form action="/loglist.action" method="post">
					 
				<input hidden="hidden" id="userId" name="user.id" value="<s:property value="user.id" />">
				操作时间:<input 
				class="Wdate"
				size="15"
				readonly="readonly"
				onclick="WdatePicker()"
				type="text" name="logs.operateDatetime" value="<s:date name='logs.operateDatetime'
				format='yyyy-MM-dd'
				 />">
				 <input type="submit" value="查询">
				</form>
			</li>
		</ul>
		<table>
			<tr>
			<td>登录帐号</td>
			<td>操作信息</td>
			<td>操作时间</td>
<%-- 			<s:iterator value="logsList">
			<tr>
			<td><s:property value="userName" /></td>
			<td><s:property value="operateInfo" /></td>
			<td><s:date   name='operateDatetime' format='yyyy-MM-dd' /></td>
			</tr>
		 
			
			</s:iterator> --%>
			
			
						<s:iterator value="pager.items">
			<tr>
			<td><s:property value="userName" /></td>
			<td><s:property value="operateInfo" /></td>
			<td><s:date   name='operateDatetime' format='yyyy-MM-dd' /></td>
			</tr>
		 
			
			</s:iterator>
			</tr>
		</table>
		
		<div class="pagination pagination-centered">
			<ul>
			<li><a href="/loglist.action?pager.page=1&user.id=<s:property value="user.id" />&logs.operateDatetime=<s:date   name='operateDatetime' format='yyyy-MM-dd' />">首页</a></li>
			
			<s:if test="pager.prevPages!=null">
			<s:iterator value="pager.prevPages"  var='num' >
				<li><a href="/loglist.action?pager.page=<s:property value="#num" />&user.id=<s:property value="user.id" />&logs.operateDatetime=<s:date   name='operateDatetime' format='yyyy-MM-dd' />"><s:property value="#num" /></a></li>
			</s:iterator></s:if>
			<li class="active">
			<a href="#"><s:property value="pager.page" /></a>
			</li>
			
			<s:if test="pager.nextPages!=null">
			
			<s:iterator value="pager.nextPages" var="num">
					<li><a href="/loglist.action?pager.page=<s:property value="#num" />&user.id=<s:property value="user.id" />&logs.operateDatetime=<s:date   name='operateDatetime' format='yyyy-MM-dd' />"><s:property value="#num" /></a></li>
			
			</s:iterator></s:if>
			
			
			
			
			<li><a href="/loglist.action?pager.page=<s:property value="pager.pageCount" />&user.id=<s:property value="user.id" />&logs.operateDatetime=<s:date   name='operateDatetime' format='yyyy-MM-dd' />">尾页</a></li>
			
			</ul>
		</div>
	</div>

</div>
</body>
</html>
