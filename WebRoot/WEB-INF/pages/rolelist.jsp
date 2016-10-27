<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
系统配置管理\


<%-- <s:if test="configType==1"> --%><a href="/rolelist.action">角色管理</a><%-- </s:if> --%>
<s:if test="configType==2"><a href="/servicetype.action">角色权限配置</a></s:if>
<s:if test="configType==3"><a href="/serviceyears.action">用户管理</a></s:if>
<s:if test="configType==4"><a href="/appurl.action">关键词审核</a></s:if>

</div>
<div class="container">




<div class="addRoleDivClass modifyback" id="deleteRolediv">
		<ul>
			<li class="lititle">你正在进行删除操作<input type="hidden" id="deleteid"/><input type="hidden" id="deleteConfigType" value="<s:property value="configType"/>"/></li>
			
			
			
			
			<li>是否删除【<input type="text" readonly="readonly"  id="deleteRoleName" />
			】?</li> 

			
			
			
			<input type="button" id="deleteRoleBtn" value="删除"/>
			<input type="button" id="cancleDeleteRoleBtn" value="取消"/>
			</li>
			
		</ul>
	
	
	
	
	
	
	
	
	
	</div>











	<div class="addRoleDivClass addback" id="addRolediv">
	<form>
		<ul>
			<li class="lititle">添加角色信息</li>
		
<li>角色名称:<input id="a_roleName" type="text" name="role.roleName"/></li>

			<li>是否启用:<select id="a_isStart" name="role.isStart">
				<option value="1" selected="selected">启用</option>
				<option value="0">停用</option>
			
			</select>
			
			
			<input type="button" id="addRoleBtn" value="保存"/>
			<input type="button" id="cancleAddRoleBtn" value="取消"/>
			</li>
			
		</ul>
	
	</form>
	
	
	
	
	
	
	
	</div>

	<div class="addRoleDivClass modifyback" id="modifyRoleDiv">
			<form>
			 
		<ul>
	<li class="lititle">修改角色信息<input   type="hidden" id="roleid"></li>
 <li>角色名称:<input id="m_roleName" type="text" name="role.roleName"/></li>
 
			<li>是否启用:<select id="m_isStart" name="role.isStart">
				<option value="1" selected="selected">启用</option>
				<option value="0">停用</option>
			
			</select>
			
			
			<input type="button" id="modifyRoleSubmit" value="保存"/>
			<input type="button" id="modifyCancle" value="取消"/>
			</li>
			
		</ul>
	
	</form>
	
	
	
	
	
	
	
	
	
	</div>
<%-- 
<s:if test="configType==1||configType==2||configType==6||configType==7||configType==5"> --%>
 
	
		<div class="addRoleDiv">
			<input type="button" id="addRole" value="添加" >
		</div>
	
		<table>
			<thead>
				<tr>
				<th>角色名称</th>
			<th>创建时间</th>
		 <%-- 
<s:if test="configType==2||configType==7"> <th>配置数值</th>  </s:if> --%>

 
			
			<th>是否启用</th>
			<th>操作</th>
			</tr>
			</thead>
		<tbody>
		
			<s:iterator value="roleList" status="st">
			<tr>
				<%-- <td><s:property value="#st.index+1"/></td> --%>
			
			<td><s:property value="roleName"/></td>
			<td><s:date name="creationTime" format="yyyy-MM-dd  hh-mm-ss"/></td>
			<%-- <s:if test="configType==2||configType==7"><td><s:property value="configValue"/></td></s:if>
			 --%>
			
			<td><s:if test="isStart==1">启用</s:if><s:else>停用</s:else></td>
			<td>
			<span class="modifyRole"
			isstart="<s:property value="isStart"  />"
			rolename="<s:property value="roleName"  />"
			
			
			 roleid="<s:property value="id" />">修改</span>
			<span 
			
			rolename="<s:property value="roleName"  />"
			
						 roleid="<s:property value="id" />"
			 class="deleteRole">删除</span>
			
			</td>
			
			
			</tr>
		</s:iterator>
		</tbody>
		</table>
	
	
<%-- 	</s:if><s:else>
	
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
</s:else> --%>

</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/rolelist.css" />
<script type="text/javascript" src="/js/rolelist.js"></script>
</body>
</html>
<s:debug></s:debug>