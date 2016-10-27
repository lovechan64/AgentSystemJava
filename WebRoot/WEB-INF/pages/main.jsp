<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/inc/head.jsp"></jsp:include>
<div class="mbxnav">
代理商管理\当前帐号信息
</div>
<div class="container">
	<div class="userInfo">
	<ul>
		<li> <b>您好！ <s:property value="currentUser.userName" />
		</b>
		您上次登录的时间<s:date name="currentUser.lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/>
		</li>
	<li>
	您当前帐号的余额: <s:property value="account.money" />
	<a href="/accountdetail.action">查看账号的明细</a>
	</li>
	
	
	</ul>
	
	
	</div>



</div>
<jsp:include page="/inc/foot.jsp"></jsp:include>

</body>
</html>