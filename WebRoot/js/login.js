function validateLoginUserFunc(){
	var flag=false;
	var usercode=$.trim($("#usercode").val());
	var userpassword=$.trim($("#password").val());
	if(usercode==""||usercode==null){
		
		$("#usercode").focus();
		alert("账号不能为空!");
	}else if(userpassword==""||userpassword==null){
		
		
		$("#password").focus();
		alert("密码不能为空!");
		
	}else{
		$.ajax({
			
			url:"/validateLoginUser.action",
			type:'post',
			async:false,
			dataType:'html',
			data:{'user.userCode':usercode,'user.Password':userpassword},
			success:function(data){
				if("noexitusercode"==data ){
					alert("对不起，账号不存在");
				}else if("errorpwd"==data ){
					alert("对不起，密码错误");
					
				}else if("failed"==data ){
					alert("对不起，系统错误");
					
				}else if("success"==data ){
					 flag=true;
					
				}
				
			}
			
			
			
		});
		flag=true;
	}
	
	
	
	
}