<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="/css/loglist.css" />
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
代理商管理\<a href="/mylogs.action">查看日志操作</a>
</div>
<div class="container">
	<div class="seracheruserdiv ope">
	 
		<table>
			<tr>
			<td>序号</td>
			<td>用户名称</td>
			<td>操作信息</td>
			<td>操作时间</td>
 
			
			
						<s:iterator value="pager.items" status="st">
			<tr>
			<td><s:property value="#st.index+1" /></td>
			<td><s:property value="userName" /></td>
			<td><s:property value="operateInfo" /></td>
			<td><s:date   name='operateDatetime' format='yyyy-MM-dd' /></td>
			</tr>
		 
			
			</s:iterator>
			</tr>
		</table>
		
		<div class="pagination pagination-centered">
			<ul>
			<li><a href="/mylogs.action?pager.page=1 ">首页</a></li>
			
			<s:if test="pager.prevPages!=null">
			<s:iterator value="pager.prevPages"  var='num' >
				<li><a href="/mylogs.action?pager.page=<s:property value="#num" /> "><s:property value="#num" /></a></li>
			</s:iterator></s:if>
			<li class="active">
			<a href="#"><s:property value="pager.page" /></a>
			</li>
			
			<s:if test="pager.nextPages!=null">
			
			<s:iterator value="pager.nextPages" var="num">
					<li><a href="/mylogs.action?pager.page=<s:property value="#num" /> "><s:property value="#num" /></a></li>
			
			</s:iterator></s:if>
			
			
			
			
			<li><a href="/mylogs.action?pager.page=<s:property value="pager.pageCount" /> ">尾页</a></li>
			
			</ul>
		</div>
	</div>



</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>

</body>
</html>