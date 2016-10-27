<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	代理商管理\ <a href="/customlist.action">代理商客户管理</a>
 

</div>
<div class="container">

    
 
		<div class="addCustomDiv">
			<input type="button" id="addCustomBtn" value="添加">
		</div>
		<div>
			<form action="/customlist.action" method="post">
				客户名称:<input type="text" name="customsname"
					value="<s:property value="customsname"/>"> 
				 
				 
				<input type="submit" value="查询">
			</form>

		</div>
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>客户名称</th>
					<th>法人代表</th>
					<th>注册时间</th>


					<th>类型</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<s:iterator value="pager.items" status="st">
					<tr>
						 <td><s:property value="#st.index+1"/></td>  

						<td><s:property value="customName" />
						</td>
						<td><s:property value="bossName" />
						</td>
						
						<td><s:date name="regDatetime" format="yyyy-MM-dd  hh-mm-ss" />
						</td>
						
						
						
						
						<td><s:property value="customTypeName" />
						</td>


						
			
						<td><s:if test="customStatus==1">启用</s:if>
							<s:else>停用</s:else>
						</td>
						
							
					 
						
						
						
						
						
						<td>
						
						
					<span   > <a href="/chakancustom.action?custom.id=<s:property value="id" />">查看</a></span>
		 
						<span   > <a href="/modifycustom.action?custom.id=<s:property value="id" />">修改</a></span>
		 
 
							<span 	 class="modifycustomStatus" 
			customstatus="<s:property value="customStatus"  />"
			
						 uid="<s:property value="id" />"  
			<%--  class="deleteCustom" --%>><s:if test="customStatus==1">启用</s:if>
							<s:else>停用</s:else></span>
 
						</td>


					</tr>
				</s:iterator>
			</tbody>
		</table>

		<div class="pagination pagination-centered">
			<ul>
			<li><a href="/customlist.action?pager.page=1&customsname=<s:property value="customsname" />">首页</a></li>
			
			<s:if test="pager.prevPages!=null">
			<s:iterator value="pager.prevPages"  var='num' >
				<li><a href="/customlist.action?pager.page=<s:property value="#num" />&customsname=<s:property value="customsname" />"><s:property value="#num" /></a></li>
			</s:iterator></s:if>
			<li class="active">
			<a href="#"><s:property value="pager.page" /></a>
			</li>
			
			<s:if test="pager.nextPages!=null">
			
			<s:iterator value="pager.nextPages" var="num">
					<li><a href="/customlist.action?pager.page=<s:property value="#num" />&customsname=<s:property value="customsname" />"><s:property value="#num" /></a></li>
			
			</s:iterator></s:if>
			
			
			
			
			<li><a href="/customlist.action?pager.page=<s:property value="pager.pageCount" />&customsname=<s:property value="customsname" />">尾页</a></li>
			
			</ul>
		</div>


 
	</div>
	<jsp:include page="/inc/foot.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="/css/customlist.css" />
	<script type="text/javascript" src="/js/customlist.js"></script>
 
 
	</body>
	</html>
	<s:debug></s:debug>