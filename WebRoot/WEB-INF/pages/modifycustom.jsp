<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	代理商管理\ <a href="/customlist.action">代理商客户管理</a>\修改客户信息
  

</div>
<div class="container">
<form id="cform" action="/modifycustom.action" method="post">
<div class="subtitle">基本信息</div>
<div class="info1">
	<ul>
		<li>企业名称:<input type="hidden" id="contactsList" value="contactsList"><input value="<s:property value="custom.customName"/>" name="custom.customName" id="customname" type="text"></li>
		<li>企业类型:
		 <input type="hidden" name="custom.customTypeName22" id="customtypename2" >
		<s:select  id="customtypename"
		 value="custom.customTypeName" name="custom.customTypeName"
		 listKey="configTypeValue" listValue="configTypeName" list="customTypeList"></s:select>
		</li>
		<li>企业主页:<input name="custom.siteUrl" value="<s:property value="custom.siteUrl"/>" type="text"></li>
		<li>状态:<select   name="custom.customStatus"  >
				<option value="1"    <s:if test="custom.customStatus==1">selected="selected"</s:if>     >启用</option>
				<option value="0"  <s:else>selected="selected"</s:else> >停用</option>
			
			</select></li>
	
	
	
	</ul>
</div>
<div class="subtitle">门户信息</div>

 
<div  class="info2">
  
<ul>
<li>法人代表:<input type="text" name="custom.bossName" value="<s:property value="custom.bossName"/>"></li>
<li>注册日期:<input type="text" name="custom.regDatetime" value="<s:property value="custom.regDatetime"/>"></li>
<li>证件类型:
<input type="hidden" name="custom.cardTypeName" >
<s:select  
		headerKey="" headerValue=""
		 listKey="configTypeValue" listValue="configTypeName" list="cardTypeList"></s:select>


</li>
<li>证件号码:<input type="text" name="custom.cardNum" value="<s:property value="custom.cardNum"/>"></li>
<li>国家:<input type="text" name="custom.country" value="<s:property value="custom.country"/>"></li>
<li>省份:

	<s:select  name="custom.province" id="customprovince"
		headerKey="" headerValue=""
		 listKey="provinceId" listValue="province" list="provinceList"></s:select>

</li>
 
<li>公司传真:<input type="text" name="custom.companyFax" value="<s:property value="custom.companyFax"/>"></li>

<li>城市:
<select name="custom.city" id="customcity">
<option value="<s:property value="custom.city"/>"><s:property value="custom.city"/></option>
</select>


</li>
<li>公司电话:<input type="text" name="custom.companyTel" value="<s:property value="custom.companyTel"/>"></li>
<li>区:
<select name="custom.area" id="customarea">
<option value="custom.area"><s:property value="custom.area"/></option>

 






</select>


</li>
<li>公司地址:<input type="text" name="custom.companyAddress" value="<s:property value="custom.companyAddress"/>"></li>
<li></li>

</ul>
 
<div  >备注:<textarea name="custom.memo"    rows="2" cols="50"><s:property value="custom.memo"/></textarea></div>
 
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
	<script type="text/javascript" src="/js/modifycustom.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script> 
 
	</body>
	</html>
	<s:debug></s:debug>