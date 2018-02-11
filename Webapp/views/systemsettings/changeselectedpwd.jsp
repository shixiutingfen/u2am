<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<base href="${basePath}">
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<jsp:include page="/views/common/resources.jsp" flush="true"/> 
	</head>
<body class="cs_layer">
<input type="hidden" id="currentUserName" value="${currentUsername }"/>
   <div class="modal-body">
   	  <div class="row">
   	  <!-- 发件主体  富文本 -->
   	  	<form id="addMailForm" class="form-horizontal" method="post">
	   	  	 <div class="col-sm-12">
	   	  	    <div class="row">
			    	<div class="col-sm-9">
			        	<div class="form-group">
			            	<label class="col-sm-6 control-label">用户名：</label>
			                <div class="col-sm-6">
			                    <input type="hidden" id="userId" value="${userId}"/>
			                	<input type="text" id="username" name="username" readonly class="form-control" style="width:300px;" value="${username}"/>
			                </div>
			            </div>
			        </div>
			    </div>
				  <!--   <div class="row">
				    	<div class="col-sm-9">
				        	<div class="form-group">
				            	<label class="col-sm-6 control-label"><span style="color:red">*</span>旧密码：</label>
				                <div class="col-sm-6">
				                	<input type="password" id="oldpassword" name="oldpassword" class="form-control" style="width:300px;" placeholder="请输入旧密码" />
				                </div>
				            </div>
				        </div>
				    </div> -->
			    
			    <div class="row" style="margin-top: 10px;">
			    	<div class="col-sm-9">
			        	<div class="form-group">
			            	<label class="col-sm-6 control-label"><span style="color:red">*</span>新密码：</label>
			                <div class="col-sm-6">
			                	<input type="password" id="newpassword" name="newpassword"  class="form-control" style="width:300px;" placeholder="请输入新密码" />
			                </div>
			            </div>
			        </div>
			    </div>
			    <div class="row" style="margin-top: 10px;">
			    	<div class="col-sm-9">
			        	<div class="form-group">
			            	<label class="col-sm-6 control-label"><span style="color:red">*</span>确认密码：</label>
			                <div class="col-sm-6">
			                	<input type="password" id="confirmpassword" name="confirmpassword"  class="form-control" style="width:300px;" placeholder="请重新输入新密码" />
			                </div>
			            </div>
			        </div>
			    </div>
			    <div class="row">
			    	<div class="col-sm-12" style="text-align: center;">
			        	<div class="form-group">
		            		<button class="btn btn-primary" type="button" id="sendBtn">
								<i class="ace-icon glyphicon glyphicon-ok bigger-110"></i>
								保存
							</button>
		            		<button class="btn btn-default" type="button" id="backBtn">
								<i class="ace-icon glyphicon glyphicon-remove bigger-110"></i>
								关闭
							</button>
			            </div>
			        </div>
			    </div>
	   	  	 </div>
   	  	 </form>
   	  	 
   	  </div>
   </div>
</body>
<script>
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	$(function(){
		
		//发送按钮
		$("#sendBtn").click(function(){
			var userId=$("#userId").val();
			var oldpassword = $("input[name=oldpassword]").val();
			var newpassword = $("input[name=newpassword]").val();
			var confirmpassword = $("input[name=confirmpassword]").val();
			if($("#currentUserName").val() != 'admin'){
				if(!$.trim(oldpassword)){
					layer.alert('旧密码不能为空!');
					return; 
				}
			}
			if(!$.trim(newpassword)){
				layer.alert('新密码不能为空!');
				return;
			}
			if(!$.trim(confirmpassword)){
				layer.alert('确认密码不能为空!');
				return;
			}
			if(newpassword != confirmpassword){
				layer.alert('新密码与确认密码不一致!');
				return;
			}
			if(oldpassword == newpassword){
				layer.alert('新密码不能与旧密码一致!');
				return;
			}
			//表单提交验证
			$.ajax({ 
     			url: '${basePath}rest/user/saveSelectedNewPwd',
     	        type: "POST" , 
     	        dataType: 'json',
     	        data: {
     	        	userId:userId,
     	        	oldpassword: oldpassword,
     	        	newpassword: newpassword,
     	        	confirmpassword: confirmpassword
     	        },
     	        success : function(data) {
     				if(data.status){
     					layer.alert('修改成功!',{
     						  title:'提示',
     						  btn: ['确定'] //按钮
     						}, function(){
     							parent.layer.close(index);
     							layer.closeAll('dialog');
     						}, function(){
     							layer.close();
     						});
     					
     				}else{
     					layer.alert('修改失败,'+data.msg);
     				}
     			},
     			failure : function() {
     				layer.alert('操作超时!');
     			}
     	     });
		});
		
		//返回按钮
		$("#backBtn").click(function(){
			parent.layer.close(index);
		});
		
	});
</script>
</html>