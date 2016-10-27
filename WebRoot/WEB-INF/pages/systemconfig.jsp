<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
系统配置管理\
<s:if test="configType==1"><a href="/caiwutype.action">财务类型</a></s:if>
<s:if test="configType==2"><a href="/servicetype.action">服务类型</a></s:if>
<s:if test="configType==3"><a href="/serviceyears.action">服务年限</a></s:if>
<s:if test="configType==4"><a href="/appurl.action">APP地址</a></s:if>
<s:if test="configType==5"><a href="/customtype.action">客户类型</a></s:if>
<s:if test="configType==6"><a href="/cardtype.action">证件类型</a></s:if>
<s:if test="configType==7"><a href="/youhuitype.action">优惠类型</a></s:if>

</div>
<div class="container">




<div class="modifySystemdiv addback" id="deleteSystemdiv">
		<ul>
			<li class="lititle">你正在进行删除操作<input type="hidden" id="deleteid"/><input type="hidden" id="deleteConfigType" value="<s:property value="configType"/>"/></li>
			
			
			
			
			<li>是否删除【<input type="text" readonly="readonly"  id="deleteConfigName" />
			】?</li> 

			
			
			
			<input type="button" id="deleteSystemConfigBtn" value="删除"/>
			<input type="button" id="cancleDeleteSystemConfigBtn" value="取消"/>
			</li>
			
		</ul>
	
	
	
	
	
	
	
	
	
	</div>











	<div class="modifySystemdiv addback" id="addSystemdiv">
		<ul>
			<li class="lititle">你正在进行添加操作<input type="hidden" id="addConfigType" value="<s:property value="configType"/>"/></li>
			<li>配置类型名称:<input type="text" id="addConfigName"/></li>

			<s:if test="configType==2||configType==7">
<li>配置项值:<input id="addConfigValue" type="text" /></li>
</s:if>
			<li>是否启用:<select id="addIsStartSelect">
				<option value="1" selected="selected">启用</option>
				<option value="0">停用</option>
			
			</select>
			
			
			<input type="button" id="addSystemConfigBtn" value="保存"/>
			<input type="button" id="cancleAddSystemConfigBtn" value="取消"/>
			</li>
			
		</ul>
	
	
	
	
	
	
	
	
	
	</div>

	<div class="modifySystemdiv modifyback" id="modifySystemdiv">
		<ul>
			<li class="lititle">你正在进行修改操作<input type="hidden" id="sid"/><input type="hidden" id="modifyConfigType" value="<s:property value="configType"/>"/></li>
			<li>配置类型名称:<input type="text" id="modifyConfigName"/></li>
<s:if test="configType==2||configType==7">
<li>配置项值:<input id="modifyConfigValue" type="text" /></li>
</s:if>
			
			<li>是否启用:<select id="modifyIsStartSelect">
				<option value="1" selected="selected">启用</option>
				<option value="0">停用</option>
			
			</select>
			
			
			<input type="button" id="modifySystemConfigBtn" value="保存"/>
			<input type="button" id="cancleModifySystemConfigBtn" value="取消"/>
			</li>
			
		</ul>
	
	
	
	
	
	
	
	
	
	</div>

<s:if test="configType==1||configType==2||configType==6||configType==7||configType==5">
  
	
		<div class="addSystemConfig">
			<input type="button" id="addsystemconfig" value="添加<s:property value="configTypeName"/>">
		</div>
	
		<table>
			<thead>
				<tr>
				<th>序号</th>
			<th>配置类型</th>
		 
<s:if test="configType==2||configType==7"> <th>配置数值</th>  </s:if>

 
			
			<th>是否启用</th>
			<th>操作</th>
			</tr>
			</thead>
		<tbody>
		
			<s:iterator value="systemConfigList" status="st">
			<tr>
				<td><s:property value="#st.index+1"/></td>
			<td><s:property value="configTypeName"/></td>
			
			<s:if test="configType==2||configType==7"><td><s:property value="configValue"/></td></s:if>
			
			
			<td><s:if test="isStart==1">启用</s:if><s:else>停用</s:else></td>
			<td>
			<span class="modifySystemBtn"
			isstart="<s:property value="isStart"  />"
			sname="<s:property value="configTypeName"  />"
			configtype="<s:property value="configType"  />"
			configvalue="<s:property value="configValue"  />"
			
			 sid="<s:property value="id" />">修改</span>
			<span 
			
			sname="<s:property value="configTypeName"  />"
			
						 sid="<s:property value="id" />"
			 class="deleteSystemBtn">删除</span>
			
			</td>
			
			
			</tr>
		</s:iterator>
		</tbody>
		</table>
	 
	
	</s:if><s:else>
	
	<div class="simpleconfig">
		
		<h3>
		
		<s:if test="configType==3">
		服务年限管理-填写最大的服务年限</s:if><s:else>
		APPURL管理-填写制作APP的系统的URL地址
		
		</s:else></h3>
		<input value="<s:property value="systemConfig.id"  />" type="hidden" id="simpleConfigId">
		<input type="hidden" id="configType" value="<s:property value="configType"  />">
		<ul>
			<li>配置名称:<input value="<s:property value="systemConfig.configTypeName"  />" type="text" id="simpleTypeName"></li>
			<li>配置数值:<input value="<s:property value="systemConfig.configValue"  />" type="text" id="simpleConfigValue"></li>
			<li><input value="保存" type="button" id="simpleBtn"></li>
		</ul>
	</div>
</s:else>

</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/systemconfig.css" />
<script type="text/javascript" src="/js/systemconfig.js"></script>
</body>
</html>
<s:debug></s:debug>