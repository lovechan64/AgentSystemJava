<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	代理商管理\ <a href="/customlist.action">代理商客户管理</a>\查看客户信息
 

</div>
<div class="container">
<form id="cform" action="/modifycustom.action" method="post">
<div class="subtitle">基本信息</div>
<div class="info1">
	<ul>
		<li>企业名称:<input type="hidden" id="contactsList" value="contactsList"><s:property value="custom.customName"/></li>
		<li>企业类型:<s:property value="custom.customStatus"/>
		 <input type="hidden" name="custom.customTypeName" id="customtypename2" >
		 
		</li>
		<li>企业主页:<s:property value="custom.siteUrl"/></li>
		<li>状态:<s:if test="custom.customStatus==1">启用</s:if><s:else>停用</s:else></li>
	
	
	
	</ul>
</div>
<div class="subtitle">门户信息</div>

 
<div  class="info2">
  
<ul>
<li>法人代表:<s:property value="custom.bossName"/></li>
<li>注册日期:<s:date   name='custom.regDatetime' format='yyyy-MM-dd' /></li>
<li>证件类型:<s:property value="custom.cardTypeName"/>
<input type="hidden" name="custom.cardTypeName" >
 


</li>
<li>证件号码:<s:property value="custom.cardNum"/></li>
<li>国家:<s:property value="custom.country"/></li>
<li>省份:<s:property value="area.father"/>
	 

</li>
 
<li>公司传真:<s:property value="custom.companyFax"/></li>

<li>城市:<s:property value="area.areaId"/>
 


</li>
<li>公司电话:<s:property value="custom.companyTel"/></li>
<li>区:<s:property value="area.area"/>
 


</li>
<li>公司地址:<s:property value="custom.companyAddress"/></li>
<li></li>

</ul>
 
<div  >备注:<textarea readonly="readonly" name="custom.memo"    rows="2" cols="50"><s:property value="custom.memo"/></textarea></div>
 
</div>

 
<div class="info3">
	<table>
		
		<tbody id="addtr" >
		<s:iterator value="contactsList" >
				<th>姓名:<s:property value="contactName"/></th><br/>
				<th>电话:<s:property value="contactTel"/></th><br/>
				<th>传真:<s:property value="contactFax"/></th><br/>
				<th>邮箱:<s:property value="contactEmail"/></th><br/>
				<th>职务:<s:property value="contactRole"/></th><br/>
			 
			  
			 
		
		
		</s:iterator>
		
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
	<%-- <script type="text/javascript" src="/js/chakancustom.js"></script> --%>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script> 
 
	</body>
	</html>
	<s:debug></s:debug>