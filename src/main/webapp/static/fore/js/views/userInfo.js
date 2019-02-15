var userFlag = false;

$(document).ready(function(){
	//查询登录用户
	$.ajax({
		url:"readUserinfo",
		data:{
	    	"id":$("#id").val()
	    },
		type:'post',
		dataType:"json",
		success: function(msg){	
			if(msg.tag!=null){
				$("#loginName").val(msg.tag.loginName);
				$("#loginPwd").val(msg.tag.loginPwd);
				$("#email").val(msg.tag.email);
				$("#address").val(msg.tag.address);
				$("#phone").val(msg.tag.phone);
				$("#trueName").val(msg.tag.trueName);
			}
		}
	});
	
	//查看用户名是否存在
	$("#loginName").blur(function(){	
		if($("#loginName").val()==null || $("#loginName").val()==""){						
			$("#msg").text("用户名不能为空");
		}else{
			$.ajax({
				url:"checkUserExist",
				data:{
			    	"loginName":$("#loginName").val()
			    },
				type:'post',
				dataType:"json",
				success: function(msg){	
					if(msg.tag==null || msg.tag.id==$("#id").val()){
						$("#msg").text("");
						userFlag = true;
					}else{
						$("#msg").text("用户名已存在！");
						userFlag = false;
					}
				}
			});
		}																	
    });	
	
	//修改用户信息
	$("#editbtn").click(function(){
		$.ajax({
			url:"editUserinfo",
			data:{
				"id":$("#id").val(),
		    	"loginName":$("#loginName").val(),
		    	"loginPwd":$("#loginPwd").val(),
		    	"trueName":$("#trueName").val(),
		    	"email":$("#email").val(),
		    	"phone":$("#phone").val(),
		    	"address":$("#address").val()
		    },
			type:'post',
			dataType:"json",
			success: function(msg){	
				if(msg==1){
					swal("修改成功!");
				}else{
					alert(msg);
					swal("修改失败!");
				}
			}
		});
	});
	
	/*
		$("#loginName").blur(function(){	
			if($("#loginName").val()==null || $("#loginName").val()==""){						
				$("#msg").text("用户名不能为空");
			}																		
	    });*/
		
});
