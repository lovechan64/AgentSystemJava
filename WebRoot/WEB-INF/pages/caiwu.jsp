<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
系统管理\<a href="/caiwu.action">财务管理</a>
</div>
<div class="container">
<div class="serachuserdiv">
 <div>搜索用户:<input id="searchUserText" type="text">输入后自动搜索</div>

<div class="searchresult" id="searchresult"></div>
</div>

<div class="searchuserdiv ope">
<ul>
<li>操作类型:

<s:select 

headerKey="" headerValue="--请选择--"
id="zijintype" list="accountConfigList" listKey="configTypeValue" listValue="configTypeName"></s:select>
</li>

<li>操作资金:<input id="zijin" type="text">
<br>重要提示:输入的资金数,<b>正数(1000)</b>向账户输入1000元，<b>负数(-1000)</b>向账户减少1000元

</li>
<li>操作备注:
<textarea id="memo"></textarea>
</li>
<li> <input id="caiwuok" value="确定"  type="button"></li>
<li class="tip"><span id="systemtip">操作提示:输入的资金数,<b>正数(1000)</b>向账户输入1000元，<b>负数(-1000)</b>向账户减少1000元</span></li>
</ul>
 

</div>
</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/caiwu.css" />
<script type="text/javascript" src="/js/caiwu.js"></script>
</body>
</html>