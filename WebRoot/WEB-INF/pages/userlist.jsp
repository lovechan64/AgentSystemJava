<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	系统配置管理\ <a href="/userlist.action1">用户管理</a>
	<s:if test="configType==2">
		<a href="/servicetype.action">角色权限配置</a>
	</s:if>
	<s:if test="configType==3">
		<a href="/userlist.action?pager.page=1&user.roleId=1&user.isStart=1">用户管理</a>
	</s:if>
	<s:if test="configType==4">
		<a href="/appurl.action">关键词审核</a>
	</s:if>

</div>
<div class="container">


 


 






	<div class="addUserDivClass addback" id="addUserDiv">
		<form>
			<ul>
				<li class="lititle">添加代理商用户信息</li>

				<li>登录帐号:<input id="a_userCode" type="text"
					name="user.userCode" /><span>*</span>
				</li>

				<li>登录名称:<input id="a_userName" type="text"
					name="user.userName" /><span>*</span>
				</li>
				<li>登录密码:<input id="a_userPassword" value="123456"
					type="password" name="user.userPassword" /><span>默认密码初始密码为123456</span>
				</li>
				<li>角色:<s:select id="a_roleId" list="roleList" headerKey="" headerValue="请选择"
						name="user.roleId" listKey="id" listValue="roleName"></s:select>
				</li>
				<li>是否启用:<select id="a_isStart" >
						<option value="1" selected="selected">启用</option>
						<option value="0">停用</option>

				</select> <input type="button" id="addUserSubmit" value="保存" /> <input
					type="button" id="cancleAdd" value="取消" /></li>

			</ul>

		</form>




	
	
	
	</div>
	 
	<div class="addUserDivClass modifyback" id="modifyUserDiv">
			<form>
			 
		<ul>
	<li class="lititle">修改用户信息<input   type="hidden" id="userid"></li>
 <li>登录帐号:<input id="m_userCode" type="text"
					name="user.userCode" /><span>*</span>
				</li>

				<li>登录名称:<input id="m_userName" type="text"
					name="user.userName" /><span>*</span>
				</li>
				<li>登录密码:<input id="m_userPassword"  
					type="password" name="user.userPassword" /><span>*</span>
				</li>
				<li>角色:<s:select id="m_roleId" list="roleList" headerKey="" headerValue="请选择"
						name="user.roleId" listKey="id" listValue="roleName"></s:select><span>*</span>
				</li>
				<li>是否启用:<select id="m_isStart" >
						<option value="1" selected="selected">启用</option>
						<option value="0">停用</option>
<span>*</span>
				</select> <input type="button" id="modifyUserSubmit" value="保存" /> <input
					type="button" id="cancleModify" value="取消" /></li>

			</ul>
	</form>
	
	
	
	
	
	
	
	
	</div>    
		<%-- 
<s:if test="configType==1||configType==2||configType==6||configType==7||configType==5"> --%>


		<div class="addUserDiv">
			<input type="button" id="addUser" value="添加">
		</div>
		<div>
			<form action="/userlist.action" method="post">
				用户名称:<input type="text" name="uname"
					value="<s:property value="uname"/>"> 角色:
				<s:select list="roleList" headerKey="" headerValue="请选择"
					name="user.roleId" listKey="id" listValue="roleName"></s:select>
				是否启用:
				<s:select list="#{'1':'启用','0':'未启用' }" name="user.isStart"></s:select>
				<input type="submit" value="查询">
			</form>

		</div>
		<table>
			<thead>
				<tr>
					<th>登录账号</th>
					<th>用户名称</th>
					<th>角色</th>
					<th>创建时间</th>
					<%-- 
<s:if test="configType==2||configType==7"> <th>配置数值</th>  </s:if> --%>



					<th>是否启用</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<s:iterator value="pager.items" status="st">
					<tr>
						<%-- <td><s:property value="#st.index+1"/></td> --%>

						<td><s:property value="userCode" />
						</td>
						<td><s:property value="userName" />
						</td>
						<td><s:property value="roleName" />
						</td>


						<td><s:date name="creationTime" format="yyyy-MM-dd  hh-mm-ss" />
						</td>
						<%-- <s:if test="configType==2||configType==7"><td><s:property value="configValue"/></td></s:if>
			 --%>

						<td><s:if test="isStart==1">启用</s:if>
							<s:else>停用</s:else>
						</td>
						<td><span class="modifyUser" isstart="<s:property value="isStart"  />"
			uname="<s:property value="userName"  />"
			 roleid="<s:property value="roleId"  />"
			ucode="<s:property value="userCode"  />"
 			userpassword="<s:property value="userPassword"  />"
			 uid="<s:property value="id" />"  >修改</span>
							<span
						 	
		uname="<s:property value="userName"  />"
			 roleid="<s:property value="roleId"  />"
						 uid="<s:property value="id" />"  
			 class="deleteUser">删除</span>
							<span<%-- 	
			uname="<s:property value="uName"  />"
			
						 uid="<s:property value="id" />" 
			 <%-- class="deleteUser" --%>>预付款</span>
							<span<%-- 	
			uname="<s:property value="uName"  />"
			
						 uid="<s:property value="id" />" --%>
			<%--  class="deleteUser" --%>><a href="javascript:ymPrompt.win('/loglist.action?user.id=<s:property value="id" />',1000,500,'LOG日志',null,null,null,true)">LOG日志</a></span>

						</td>


					</tr>
				</s:iterator>
			</tbody>
		</table>

		<div class="pagination pagination-centered">
			<ul>
			<li><a href="/userlist.action?pager.page=1&user.roleId=<s:property value="user.roleId" />&uname=<s:property value="uname" />&user.isStart=<s:property value="user.isStart" />">首页</a></li>
			
			<s:if test="pager.prevPages!=null">
			<s:iterator value="pager.prevPages"  var='num' >
				<li><a href="/userlist.action?pager.page=<s:property value="#num" />&user.roleId=<s:property value="user.roleId" />&uname=<s:property value="uname" />&user.isStart=<s:property value="user.isStart" />"><s:property value="#num" /></a></li>
			</s:iterator></s:if>
			<li class="active">
			<a href="#"><s:property value="pager.page" /></a>
			</li>
			
			<s:if test="pager.nextPages!=null">
			
			<s:iterator value="pager.nextPages" var="num">
					<li><a href="/userlist.action?pager.page=<s:property value="#num" />&user.roleId=<s:property value="user.roleId" />&uname=<s:property value="uname" />&user.isStart=<s:property value="user.isStart" />"><s:property value="#num" /></a></li>
			
			</s:iterator></s:if>
			
			
			
			
			<li><a href="/userlist.action?pager.page=<s:property value="pager.pageCount" />&user.roleId=<s:property value="user.roleId" />&uname=<s:property value="uname" />&user.isStart=<s:property value="user.isStart" />">尾页</a></li>
			
			</ul>
		</div>



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
	<link rel="stylesheet" type="text/css" href="/css/userlist.css" />
	<script type="text/javascript" src="/js/userlist.js"></script>
 
 
	</body>
	</html>
	<s:debug></s:debug>