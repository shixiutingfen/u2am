<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>修改用户信息</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	</head>
<body class="cs_layer">
   <div class="modal-body">
   	  <form class="form-horizontal" method="post" id="modifyUserForm">
				  <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">账号信息</h5>
				    <div class="row">
				         <div class="col-sm-5">
				        	<div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>账号</label>
				                <div class="col-sm-9">
				                	<input type="hidden" name="usernameold" id="usernameold" value="${sysUser.username}"/>
				                	<input type="text" name="username" id="username" value="${sysUser.username}" class="form-control" placeholder="请输入账号 " autofocus disabled="true"/>
				                </div>
				            </div>
				        </div>
				          <div class="col-sm-5">
				        		<div class="form-group">
				            	<label class="col-sm-3 control-label">状态</label>
				            	<div class="col-sm-9">
					                <select name="isvalid" id="isvalid" class="form-control" style="width:30%;">
					                		<option value="1" <c:if test="${sysUser.isvalid==1 }">selected="selected"</c:if>>正常</option>
					                		<option value="0" <c:if test="${sysUser.isvalid==0 }">selected="selected"</c:if>>停用</option>
					                </select>
				                </div>
				             </div>
				        </div>
				    </div>
				    <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">基本信息</h5>
					<div class="row">
					 <input type="hidden"  name="userId" id="userId" value="${sysUser.userId}" class="form-control" placeholder="请输入编号"/>
					
				        <div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>姓名</label>
				                <div class="col-sm-9">
				                	<input type="text" name="realName" id="realName" value="${sysUser.realName}"  class="form-control" placeholder="请输入姓名"/>
				                </div>
				            </div>
				        </div>
				          <div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label">手机号码</label>
				                <div class="col-sm-9">
				                <input type="text" name="tel" id="tel" value="${sysUser.tel}" class="form-control" placeholder="请输入手机号码"/>
				                </div>
				            </div>
				        </div>
				
				    </div>
				    <!-- 结束4 -->
				    <div class="row">
				       <div class="col-sm-5">
				        	<div class="form-group">
				            	<label class="col-sm-3 control-label">备注</label>
				                <div class="col-sm-9">
				                	<textarea style="height:60px;" class="form-control" name="remark" id="remark">${sysUser.remark}</textarea>
				                </div>
				            </div>
				        </div>
				        <div class="col-sm-5">
				        	<div class="form-group">
				            	<label class="col-sm-3 control-label"></label>
				                <div class="col-sm-9">
				                </div>
				            </div>
				        
				        </div>
				        
				    </div>
				   
				    <!-- 结束4 -->
				    <!-- 开始5 -->   
				    
				       <!-- 设置角色 -->
				     <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">角色信息</h5>
				       <div class="row">
				         <div class="col-sm-12">
				        	<div class="form-group">
				            	<label class="col-sm-1 control-label"><span style="color:red">*</span>选择角色</label>
				                <div class="col-sm-11">
				                 <label class="checkbox-list" style="display:block">
				                    <input type="hidden" id="roleId" name="roleId" value="${currentRoleId}"/>
				                	<c:forEach items="${roleList}" var="role">
				                	     <label class="checkbox-inline col-sm-2" style="margin-left:0"><input type="checkbox" name="chkItem" value="${role.roleId}"/>${role.roleName}</label>
                                    </c:forEach>
                                     </label>
				                </div>
				            </div>
				        </div>
				     </div>
				     
				    <!-- 结束5 -->
				   	<div class="clearfix form-actions">
					   	  <div class="text-center">
					   	        <!-- <input  type="submit" class="btn btn-primary" value="保存"/> -->
					            	<button class="btn btn-primary" type="submit">
										<i class="ace-icon glyphicon glyphicon-ok bigger-110"></i>
										保存
									</button>
					            
						            <button class="btn btn-default" type="reset">
										<i class="ace-icon glyphicon glyphicon-repeat bigger-110"></i>
										重置
									</button>
									
					            	<button class="btn btn-default" type="button" id="close">
										<i class="ace-icon glyphicon glyphicon-remove bigger-110"></i>
										关闭
									</button>
					    </div>
				    </div>
				    
				</form>
   </div>
   
   <!--组织机构-->
   <div class="modal fade bs-example-modal-lg" tabindex="-2" id="orgModal" role="dialog" aria-labelledby="myLargeModalLabel" data-backdrop="static" data-keyboard="false">
	  <div class="modal-dialog modal-lg" style="width:1200px;" >
	    <div class="modal-content">
	    </div>
	  </div>
  </div>
</body>
<script type="text/javascript">

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
 jQuery(function($) {
	 
	 	// 初始化checkbox
		var roleArray = $("#roleId").val().split(",");
	    $("[name='chkItem']").each(function(){
	    	for(i =0; i< roleArray.length; i++){
	    		if(roleArray[i] == $(this).val())
	    		{
	    			$(this).prop("checked",true);
	    			continue;
	    		}
	    	}
		    });
	    
	 //关闭时，清除内容
	 $("#modfiyUserModal").on("hidden.bs.modal", function() {
		      $(this).removeData("bs.modal");
	 });
	
	 var validate = $("#modifyUserForm").validate({
         //debug: true, //调试模式取消submit的默认提交功能   
         //errorClass: "label.error", //默认为错误的样式类为：error   
         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
         onkeyup: false,   
         rules:{
             username:{
                 required:true
             },
             tel:{
            	 mobile:true
             },
             chkItem:{
                 required:true
             },
             realName:{
            	 required:true
             }
         },
         messages:{
             username:{
                 required:"账号为必填项"
             },
             tel:{
            	 mobile:"手机格式不正确"
             },
			 realName:{
				 required:"姓名为必填项"
             },
             chkItem:{
            	 required:"请选择角色"
             }
         },
         errorPlacement : function(error, element) {
        	 if (element.is(":radio"))
        		 error.appendTo(element.parent().parent().parent());
        	 else if (element.is(":checkbox"))
        	 	error.appendTo(element.parent().parent());
        	 else
        		error.appendTo(element.parent());
        },
         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
        	
             var roleId ="";
             $("[name='chkItem']").each(function(){
        	    
        	     if($(this).attr("checked"))
        	   {
        	    	 roleId +=$(this).val()+",";
        	    
        	   }
        	   
        	    });
             $("#roleId").val(roleId);
             var username= $("#username").val();
        	 $.ajax({ 
     			url : '<%=basePath%>rest/user/update?currentRoleId='+roleId,
     	        type : "POST" , 
     	        dataType:'json',
     	        data : $("#modifyUserForm").serialize()+"&username="+username,
     	        success : function(data) {
     	        	
     				if (data.state) {
     					layer.alert('编辑成功!',{
      					  title:'提示',
      					  btn: ['确定'] //按钮
      					}, function(){
      						parent.$("#grid-table").trigger("reloadGrid");//自动刷新grid
		          			parent.layer.close(index);
      	    				 layer.closeAll('dialog');
      					}, function(){
      						layer.close();
      					});
     				} else {
     					layer.alert(data.msg);
     				}
     			},
     			failure : function() {
     				layer.alert('操作超时!');
     			}
     			
     	     });
         }
                   
     }); 
	 
	 $("#close").bind("click",function(){
		 parent.layer.close(index);
	 });
	 
 });
 
 </script>
</html>