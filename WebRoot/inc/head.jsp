<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>    
<s:debug></s:debug>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link id='theme' rel='stylesheet' href='/humane/themes/original.css'/>
<script src='/humane/humane.js'></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 
<script type="text/javascript" src="/alertframe/ymPrompt.js"></script>


<link rel="stylesheet"  type="text/css" href="/alertframe/skin/simple_gray/ymPrompt.css" />
<link rel="stylesheet" type="text/css" href="/css/public.css" />
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/public.js"></script>

<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代理商管理系统</title>
</head>
<body>
<div class="head">
<ul>
	<li><h2>AgentSystem</h2>
	<li class="headfunc">
	
	<ul>
				 
	<li>欢迎:<s:property value="currentUser.userName" />
	<a id="modifypwdbtna" >修改密码</a><a href="/exit.action" >退出</a>
	</li>
	</ul>
	
	
	</li>

</ul>


	



</div>
<div id="menu">
<ul>
<s:iterator value="roleFunctions" status="sta">

<li class="m_line"><img src="/imgs/line1.gif"></li>
	
	<li  onmouseover="mover(<s:property value="#sta.index+1" />)" id="m_<s:property value="#sta.index+1" />" class="m_li"><a><s:property value="mainFunction.functionName" /></a></li>
	



</s:iterator>


</ul>

</div>
<!-- <div id="menu" class="menu">


<ul>
<li class="m_line"><img src="/imgs/line1.gif"></li>
	
	<li id="m_1" class="m_li"><a>代理商管理</a></li>
	
	
	<li class="m_line"><img src="/imgs/line1.gif"></li>
	
	<li id="m_4" class="m_li" onmouseover="mover(4)"><a>系统管理</a></li>
	<li class="m_line"><img src="/imgs/line1.gif"></li>
	
	<li id="m_5" class="m_li" onmouseover="mover(5)"><a>系统配置管理</a></li>
	
</ul></div> -->


<div class="subbox">
<ul class="smenu">
<s:iterator value="roleFunctions" status="sta">
<li id="s_<s:property value="#sta.index+1" />" class="s_li">
<s:iterator value="subFunctions"  >
 <a href="<s:property value="funcUrl" />"><s:property value="functionName" /></a>
</s:iterator>
</li>
</s:iterator>
	<!-- <li id="s_4" class="s_li_a">
	 <a href="/caiwutype.action">财务管理</a>
	 <a href="/rolelist.action">角色管理</a>
	 <a href="/permission.action">角色权限配置</a>
	 <a href="/userlist.action?pager.page=1&user.roleId=1&user.isStart=1">用户管理</a>
	 <a href="/customtype.action">关键词审核</a>


	  
	
	</li>
	<li id="s_5" class="s_li">
	 <a href="/caiwutype.action">财务类型</a>
	 <a href="/servicetype.action">服务类型</a>
	 <a href="/serviceyears.action">服务年限</a>
	 <a href="/appurl.action">APP地址</a>
	 <a href="/customtype.action">客户类型</a>
	 <a href="/cardtype.action">证件类型</a>
	<a href="/youhuitype.action">优惠类型</a>

	  
	
	</li>
 -->
</ul>
</div>


<div id="modifydiv" class="modifydiv">
<div class="modifTop">修改密码</div>
<div class="modifyPasswordContent">
	<ul>
		<li>请输入原密码:<input type="password" id="oldpwdtext"><span id="oldpwdtexttip">您本次登录的密码</span>
		<li>请输入新密码:<input type="password" id="newpwd"><span id="newpwdtip">新密码不少于6个字符</span>
		<li>请确认新密码:<input type="password" id="newpwd2"><span id="newpwd2tip">确认密码不少于6个字符</span>
		<li><input type="button" value="确认修改密码" id="modifypwdbtn"><input type="button" value="取消" id="modifypwdcancel">
	
	</ul>


</div>
<div></div>



</div>