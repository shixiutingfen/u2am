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
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	</head>
<body class="cs_layer">
   <div class="modal-body">
   	  <form class="form-horizontal" method="post" id="addUserForm">
				  <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">账号信息</h5>
				    <div class="row">
				         <div class="col-sm-5">
				        	<div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>账号</label>
				                <div class="col-sm-9">
				                	<input type="text" name="username" class="form-control" placeholder="请输入账号 " autofocus/>
				                </div>
				            </div>
				        </div>
				    </div>
				    <div class="row">
				        <div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>密码</label>
				                <div class="col-sm-9">
				                 <input type="hidden" name="password" id="password"/>
				                <input type="password" name="password1" id="password1" class="form-control"  placeholder="请输入密码"/>
				                </div>
				            </div>
				        </div>
				        <div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>重复密码</label>
				                <div class="col-sm-9">
				                <input type="password" name="password2" class="form-control"  placeholder="请输入密码"/>
				                </div>
				            </div>
				        </div>
				    </div>
				    <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">基本信息</h5>
					<div class="row">
				        <div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label"><span style="color:red">*</span>姓名</label>
				                <div class="col-sm-9">
				                	<input type="text" name="realName"  class="form-control" placeholder="请输入姓名"/>
				                </div>
				            </div>
				        </div>
				 		<div class="col-sm-5">
				            <div class="form-group">
				            	<label class="col-sm-3 control-label">手机号码</label>
				                <div class="col-sm-9">
				                <input type="text" name="tel" class="form-control input-sm" placeholder="请输入手机号码"/>
				                </div>
				            </div>
				        </div>
				    </div>
				    <div class="row">
				       <div class="col-sm-5">
				        	<div class="form-group">
				            	<label class="col-sm-3 control-label">备注</label>
				                <div class="col-sm-9">
				                	<textarea style="height:60px;" class="form-control" name="remark"></textarea>
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
				    <!-- 开始5 -->   
				    
				       <!-- 设置角色 -->
				     <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">角色信息</h5>
				       <div class="row">
				         <div class="col-sm-12">
				        	<div class="form-group">
				            	<label class="col-sm-2 control-label" style="text-align: center;"><span style="color:red">*</span>选择角色</label>
				                <div class="col-sm-10">
				                 <label class="checkbox-list" style="display:block">
				                    <input type="hidden" id="roleId" name="roleId"/>
				                	<c:forEach items="${roleList}" var="role">
				                	      <c:if test="${role.roleId == 1 }">
				                	        <shiro:hasRole name="admin"> 
					                	        <c:if test="${userInfo.userId == 1}">
						                	        <label class="checkbox-inline col-sm-2" style="margin-left:0"><input type="radio" name="chkItem" value="${role.roleId}"/>${role.roleName}</label>
					                	        </c:if>
				                	        </shiro:hasRole>
				                	      </c:if>
				                	       <c:if test="${role.roleId != 1 }">
										  <label class="checkbox-inline col-sm-2" style="margin-left:0"><input type="radio" name="chkItem" value="${role.roleId}"/>${role.roleName}</label>
										  </c:if>
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
	 var validate = $("#addUserForm").validate({
         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
         onkeyup: false,   
         rules:{
             username:{
                 required:true
             },
             password1:{
            	 required:true,
            	 minlength:6,
            	 maxlength:30
             },
             password2:{
            	 equalTo:"#password1"
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
                 required:"账号为必填项",
                
             },
             password1:{
            	 required:"密码为必填项",
            	 minlength:"密码至少为6位长度",
            	 maxlength:"密码最多30位长度"	
             },
             password2:{
            	 equalTo:"两次密码不一致"
             },
             tel:{
            	 mobile:"手机格式不正确"
             },
             chkItem:{
            	 required:"请选择角色"
             },
             realName:{
                 required:"请输入姓名"
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
        	
        	 $('#password').val($('#password1').val());
             //判断角色是否选中
             if($("input[name=chkItem]:checked").length == 0){
            	 layer.alert('请选择角色!');
                return;
             }
             
             var roleId ="";
             $("[name='chkItem']").each(function(){
        	    
        	     if($(this).attr("checked"))
        	   {
        	    	 roleId +=$(this).val()+",";
        	    
        	   }
        	   
        	    });
            
             $("#roleId").val(roleId);
         	 $.ajax({ 
     			url : '<%=basePath%>rest/user/createUser',
     	        type : "POST" , 
     	        dataType:'json',
     	        data : $("#addUserForm").serialize(),
     	        success : function(data) {
     				if (data.state) {
     					layer.alert('新增用户成功!',{
      					  title:'提示',
      					  btn: ['确定'] //按钮
      					}, function(){
      						parent.$("#grid-table").trigger("reloadGrid");
                            parent.layer.close(index);
      	    				 layer.closeAll('dialog');
      					}, function(){
      						layer.close();
      					});
     					 
                        
                         //parent.layer.("#grid-table").trigger("reloadGrid");//自动刷新grid
     					//$("#datagrid").treegrid("reload");
     				} else {
     					layer.alert(data.msg);
     				}
     			},
     			failure : function() {
     				layer.alert( '操作超时!');
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