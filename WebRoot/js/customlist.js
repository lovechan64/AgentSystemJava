$().ready(function(){
	mover(1);
	
	
	$("#addCustomBtn").click(function(){
		location.href="/addcustom.action";
	});
	
	
	
	
	/*
			class="modifycustomStatus" 
			customstatus="<s:property value="customStatus"  />"
			
						 uid="<s:property value="id"*/
	
	
	
	
	
/*	
	$(".modifycustomStatus").click(function(){
		var obj=$(this);
		
	var customStatus=	obj.attr("customstatus");
	 var id=  obj.attr("uid");
 
		 
		 $.post("/modifyCustomStatus.action",
			
			 
			{"custom.id":id,"custom.customStatus":customStatus},function(result){
				
				
				
				
				if(result=="success"){
					 window.location.reload(true);
					
				}else  {
					humane.error("对不起，修改失败");
					
				}
				
			} 
		 ,"html");
	 
		
	 
	});*/
})	;