<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	代理商管理\ <a href="/customlist.action">代理商客户管理</a>\添加客户信息
 

</div>
<div class="container">
<form id="cform" action="/addsavecustom.action" method="post">
<div class="subtitle">基本信息</div>
<div class="info1">
	<ul>
		<li>企业名称:<input name="custom.customName" id="customname" type="text"></li>
		<li>企业类型:
		 <input type="hidden" name="custom.customTypeName" id="customcustomtypename" >  
		<s:select  id="customtypename"  name="custom.customType" 
		headerKey="" headerValue="--请选择--"
		 listKey="configTypeValue" listValue="configTypeName" list="customTypeList"></s:select>
		</li>
		<li>企业主页:<input name="custom.siteUrl" type="text"></li>
		<li>状态:<select   name="custom.customStatus">
				<option value="1" selected="selected">启用</option>
				<option value="0">停用</option>
			
			</select></li>
	
	
	
	</ul>
</div>
<div class="subtitle">门户信息</div>

 
<div  class="info2">
  
<ul>
<li>法人代表:<input type="text" name="custom.bossName"></li>
<li>注册日期:<input id="regdate" type="text" name="custom.regDatetime"></li>
<li>证件类型:
<input type="hidden" name="custom.cardTypeName" >
<s:select  
		headerKey="" headerValue="--请选择--"
		 listKey="configTypeValue" listValue="configTypeName" list="cardTypeList"></s:select>


</li>
<li>证件号码:<input type="text" name="custom.cardNum"></li>
<li>国家:<input type="text" name="custom.country"></li>
<li>省份:

	<s:select  name="custom.province" id="customprovince"
		headerKey="" headerValue="--请选择--"
		 listKey="provinceId" listValue="province" list="provinceList"></s:select>

</li>
 
<li>公司传真:<input type="text" name="custom.companyFax"></li>

<li>城市:
<select name="custom.city" id="customcity">
<option value="">--请选择--</option>
</select>


</li>
<li>公司电话:<input type="text" name="custom.companyTel"></li>
<li>区:
<select name="custom.area" id="customarea">
<option value="">--请选择--</option>

 






</select>


</li>
<li>公司地址:<input type="text" name="custom.companyAddress"></li>
<li></li>

</ul>
 
<div  >备注:<textarea name="custom.memo" rows="2" cols="50"></textarea></div>
 
</div>


<div class="subtitle"><a id="addcontact" href="javascript:addContact()">添加一个联系人</a></div>
<div class="info3">
	<table>
		<thead>
		
		
		
		
		
		
		
		
		
		
		
		
		
		

			<tr>
				<th>姓名</th>
			<th>电话</th>
			<th>传真</th>
			<th>邮箱</th>
			<th>职务</th>
			<th>操作</th>
			 
			
			
			</tr>
		
		</thead>
		<tbody id="addtr">
		
		
		</tbody>
	
	</table>




</div>
<div class="goback">
<input type="button" value="保存" onclick="checksave();">
<input type="button" value="返回" onclick="history.go(-1)">

</div>

</form>
    
  
 
 
 
 
 
 
 

 
	</div>
	<jsp:include page="/inc/foot.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="/css/addcustom.css" />
	<script type="text/javascript" src="/js/addcustom.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script> 
 
	</body>
	</html>
	<s:debug></s:debug>