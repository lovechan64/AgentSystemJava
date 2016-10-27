<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
	代理商管理\当前账号信息\ <a href="/accountdetail.action">查看账号明细</a>

</div>
<div class="container">
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>财务类型</th>
				<th>账务资金</th>
				<th>账户余额</th>
				<th>备注信息</th>
				<th>明细时间</th>
			</tr>
		</thead>
		<tbody>

			<s:iterator value="pager.items" status="st">
				<tr>
					<td><s:property value="#st.index+1" />
					</td>

					<td><s:property value="detailTypeName" /></td>
					<td>￥<s:property value="money" /></td>
					<td>￥<s:property value="accountMoney" /></td>
					<td><s:property value="memo" /></td>

					<td><s:date name="detailDateTime" format="yyyy-MM-dd  hh-mm-ss" />
					</td>
					</tr>
			</s:iterator>
		</tbody>
	</table>

	<div class="pagination pagination-centered">
		<ul>
			<li><a
				href="/accountdetail.action?pager.page=1&user.roleId=<s:property value="user.roleId" />&uname=<s:property value="uname" />&user.isStart=<s:property value="user.isStart" />">首页</a>
			</li>

			<s:if test="pager.prevPages!=null">
				<s:iterator value="pager.prevPages" var='num'>
					<li><a
						href="/accountdetail.action?pager.page=<s:property value="#num" />"><s:property
								value="#num" />
					</a>
					</li>
				</s:iterator>
			</s:if>
			<li class="active"><a href="#"><s:property
						value="pager.page" />
			</a></li>

			<s:if test="pager.nextPages!=null">

				<s:iterator value="pager.nextPages" var="num">
					<li><a
						href="/accountdetail.action?pager.page=<s:property value="#num" />"><s:property
								value="#num" />
					</a>
					</li>

				</s:iterator>
			</s:if>




			<li><a
				href="/accountdetail.action?pager.page=<s:property value="pager.pageCount" />">尾页</a>
			</li>

		</ul>
	</div>



 

</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/accountdetail.css" />



</body>
</html>
<s:debug></s:debug>