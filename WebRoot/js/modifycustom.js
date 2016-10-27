var contactcount=0;
$().ready(function(){
	mover(1);
	contactcount=	$("#contactcount").val();
//	$("#regdate").val(new Date().format("yyyy-MM-dd"));
	
	
	
	$("#customprovince").change(function(){
		$("#customcity").empty();
		$("#customcity").append("<option value='' selected='selected'>--请选择--</option>");

		$("#customarea").empty();
		$("#customarea").append("<option value='' selected='selected'>--请选择--</option>");
	
		var s_city=$("#customprovince").val();
	$.post("/loadcity.action",{"province.provinceId":s_city},function(result){
		if(result!=""){
			for(var i=0;i<result.length;i++)
				$("#customcity").append("<option value='"+result[i].cityId+"'>"+result[i].city+"</option>");
			
		}else{
			humane.error("城市加载失败！");
			
		}
		
	},'json');
	});
	

	var province=$("#customprovince").val();
	var city=$("#city").val();
	var  area=$("#area").val();
	if(province!=""&&city!=""){
		
		$.post("/loadcity.action",{"province.provinceId":province},function(result){
			if(result!=""){
				for(var i=0;i<result.length;i++){
					if(city==result[i].cityId)
					$("#customcity").append("<option selected='selected' value='"+result[i].cityId+"'>"+result[i].city+"</option>");
					else
					$("#customcity").append("<option value='"+result[i].cityId+"'>"+result[i].city+"</option>");
					
				}
				
					
					
					
					
					
			}else{
				humane.error("城市加载失败！");
				
			}
			
		},'json');
		
		
	}
	
	
	
	$("#customcity").change(function(){
		$("#customarea").empty();
		$("#customarea").append("<option value='' selected='selected'>--请选择--</option>");
	var s_city=$("#customcity").val();
	$.post("/loadarea.action",{"city.cityId":s_city},function(result){
		if(result!=null){
			for(var i=0;i<result.length;i++)
				$("#customarea").append("<option value='"+result[i].areaId+"'>"+result[i].area+"</option>");
			
		}else{
			humane.error("区域加载失败！");
			
		}
		
	},'json');
	
	 });
	
	
	
	$("#customtype").change(function(){
		$("#customtypename").val($("#customtype option:selected").text());
	});
	
	$("#customcardType").change(function(){
		$("#customcardtypename").val($("#customcardType option:selected").text());
	});
	
	
	
	
	
	
	
/*	
	$("#addcontact").click(function(){
		var str="<tr><td><input type='text' name='contactsList["+contactcount+"].contactName'></td>" +		
		"<td><input type='text' name='contactsList["+contactcount+"].contactTel'></td>" +
		"<td><input type='text' name='contactsList["+contactcount+"].contactFax'></td>" +
		"<td><input type='text' name='contactsList["+contactcount+"].contactEmail'></td>" +
		"<td><input type='text' name='contactsList["+contactcount+"].contactRole'></td>" +
		"<td onclick='delTr(this)' ><a href='javascript:void(0)'>删除</a></td></tr>" ;
		
		$("#addtr").append(str);
		
		contactcount++;
		
		
		
	});
	*/
	
	
	
	
	
	$("#cardnum").blur(function(){
		var t=$("#cardnum").val();
		if(!checkValidateNum(t))
			humane.error("证件号码请输入数字！");
		
	});
	
	 
	 
	 

		if(area!=""&&city!=""){
			
			$.post("/loadarea.action",{"city.cityId":city},function(result){
				if(result!=""){
					for(var i=0;i<result.length;i++)
					
						
						if(area==result[i].areaId)
							  $("#customarea").append("<option  selected='selected' value='"+result[i].areaId+"'>"+result[i].area+"</option>");
						 else
						  $("#customarea").append("<option value='"+result[i].areaId+"'>"+result[i].area+"</option>");
					 
				}else{
					humane.error("区域加载失败！");
					
				}
				
			},'json');
			
		}
		
		
	 	
});


function addContact(){
	var str="<tr><td><input type='text' name='contactsList["+contactcount+"].contactName'></td>" +		
	"<td><input type='text' name='contactsList["+contactcount+"].contactTel'></td>" +
	"<td><input type='text' name='contactsList["+contactcount+"].contactFax'></td>" +
	"<td><input type='text' name='contactsList["+contactcount+"].contactEmail'></td>" +
	"<td><input type='text' name='contactsList["+contactcount+"].contactRole'></td>" +
	"<td onclick='delTr(this)' ><a href='javascript:void(0)'>删除</a></td></tr>" ;
	
	$("#addtr").append(str);
	
	contactcount++;
	
	
}

 

function checkValidateNum(value){
	var reg=new RegExp("^[0-9]*$");
	if(reg.test(value))
		return true;
	else
		return false;
	
	
}


function delTr(obj){
	$(obj).parent().remove();
}
function checksave(){
	var customname=$.trim($("#customname").val());
	var customtypename=$("#customtypename").val();
	if(customname.length==0){
		humane.error("客户名称不能为空");
		return;
	}
 if(customtypename==null){
		humane.error("客户类型不能为空");
		return;
	} 
/*	$.post("/isexitcustomname.action",{"custom.customName":customname},
	
	function(result){
		if(result=="peat"){
			humane.error("对不起，该客户名称已存在");
			
		}else if(result=="nopeat"){
			$("#cform").submit();
			
		}
		
		
	},"html");*/
 $("#mform").submit();
	
}