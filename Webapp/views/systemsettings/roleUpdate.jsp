<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" /> 
	</head>
<body class="cs_layer">
   <div class="modal-body roleUpdatebody">
   	  <form class="form-horizontal" method="post" id="modifyRoleForm">
	    <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
	        <div class="col-sm-5">
	            <div class="form-group">
	            	<label class="col-sm-3 control-label"><span style="color:red">*</span>角色名称</label>
	                <div class="col-sm-9">
	                     <input type="hidden" name="roleId" id="roleId" value="${sysRole.roleId}" />
	                	<input type="text" name="roleName" id="roleName" value="${sysRole.roleName}"  class="form-control" placeholder="请输入角色名称" autofocus/>
	                </div>
	            </div>
	        </div>
	    
	    	<div class="col-sm-5">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">立即生效</label>
	                <div class="col-sm-9">
	                	<select class="form-control input-sm" value="${sysRole.state}"  name="state" id="state">
                        	<option value="1">是</option>
                            <option value="2">否</option>
                        </select>
	                </div>
	            </div>
	         </div>
	     </div>
	    <!-- 结束1 -->
	    <!-- 开始2 -->  
	      <div class="row">
	    	<div class="col-sm-5">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">角色描述</label>
	                <div class="col-sm-9">
	                	<textarea class="form-control" name="roleRemark" id="roleRemark">${sysRole.roleRemark}</textarea>
	                </div>
	            </div>
	        </div>
	        
	         <div class="col-sm-5">
	        	<div class="form-group">
	            	<label class="col-sm-3 control-label">是否部门管理员</label>
	                <div class="col-sm-9">
	                	<select class="chosen-select form-control" name="roleSign"  id = "roleSign" value="${sysRole.roleSign}" data-hide-disabled="true" name="state">
	                	    <c:if test="${sysRole.roleSign=='admin'}">
	                	       <option value="oper">否</option>
                        	  <option value="admin" selected="selected">是</option>
	                	    </c:if>
	                	     <c:if test="${sysRole.roleSign!='admin'}">
	                	        <option value="oper" selected="selected">否</option>
                        	   <option value="admin">是</option>
	                	     </c:if>
	                	   
                        </select>
	                </div>
	            </div>
	         </div>
	    </div>
	    
	       <!-- 设置角色 -->
	     <h5 class="page-header" style="padding:10px; margin:0px; margin-bottom:15px;">权限列表</h5>
	       <div class="row">
	         <div class="col-sm-12">
	        	<div class="form-group">
	            	<label class="col-sm-1 control-label"><span style="color:red">*</span>选择权限</label>
	                <div class="col-sm-11">
	                  <table width="100%" border="1" cellspacing="1" cellpadding="0" class="table table-bordered">
	                     <c:forEach items="${permiMuneList}" varStatus="status" var="permiMenu">
	                     <tr style="height:40px;">
	                       <td width="20%" style="font-family: Tahoma;font-size: 14px;">
	                        <c:if test="${permiMenu.actionId == 0}">
	                          <label class="checkbox-inline allcheck"><input type="checkbox" name="chkItem"  checked="checked" value="${permiMenu.permissionId}"/>${permiMenu.permissionName}</label>
	                        </c:if>
	                          <c:if test="${permiMenu.actionId != 0}">
	                          <label class="checkbox-inline allcheck"><input type="checkbox" name="chkItem" value="${permiMenu.permissionId}"/>${permiMenu.permissionName}</label>
	                        </c:if>
	                       </td>
	                       <td width="80%" style="font-family: Tahoma;font-size: 14px;">
	                         <label class="checkbox-list">
	                         <c:forEach items="${permissionList}" var="permi">
	                          <c:if test="${permi.permissionSign==permiMenu.resourceId }">
	                              <c:if test="${permi.actionId == 0}">
	                               <label class="checkbox-inline"><input type="checkbox" name="chkItem1" checked="checked" value="${permi.permissionId}"/>${permi.permissionName}</label>
	                               </c:if>
	                             <c:if test="${permi.actionId != 0}">
	                               <label class="checkbox-inline"><input type="checkbox" name="chkItem1" value="${permi.permissionId}"/>${permi.permissionName}</label>
	                             </c:if>
	                          </c:if>
	                         </c:forEach>
	                         </label>
	                       </td>
	                     </tr>
	                    </c:forEach>
	                  </table>
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

</body>
<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
 jQuery(function($) {
	 //关闭时清除内容
	 $("#modifyRoleModal").on("hidden.bs.modal", function() {
	      $(this).removeData("bs.modal");
	    });
	 
	  $('.chosen-select').chosen({allow_single_deselect: true});
	   // chkItem事件
	   $(".allcheck").bind("click", function(){
		   var checkval = $(this).find("input[type='checkbox']").prop('checked');
		   var val = $(this).find("input[type='checkbox']").prop("value"); 
		   $(this).parent().next().children().each(function()
			 {
			   $(this).find("input[type='checkbox']").prop('checked', checkval);
			 });
		
	    });
	 
	 var validate = $("#modifyRoleForm").validate({
         //debug: true, //调试模式取消submit的默认提交功能   
         //errorClass: "label.error", //默认为错误的样式类为：error   
         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
         onkeyup: false,   
         rules:{
             roleName:{
                 required:true,
                 maxlength:128
             },
             roleRemark:{
            	 required:false,
            	 maxlength:512
             }
         },
         messages:{
        	 roleName:{
                 required:"角色名称为必填项",
                 maxlength:"角色名称最多128位长度"
             },
             roleRemark:{
            	 maxlength:"描述最多512位长度"
             }
         },
         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form 
        	 
        	 var permissionIds = "";
             var hasChecked = false;
        	
             $("[name='chkItem']:checkbox").each(function() {
            	 if ($(this).prop('checked'))
       			 {
        		   hasChecked = true;
       			   permissionIds += $(this).val() +',';
       			 } 
             });
             
        	 $("[name='chkItem1']:checkbox").each(function() {
        		 if ($(this).prop('checked'))
       			 {
        		   hasChecked = true;
       			   permissionIds += $(this).val() +',';
       			 }
        		
        	 });
        	 
             if(!hasChecked){
            	 layer.alert( '请选择权限!');
              }
             
          
        	 $.ajax({ 
     			url : '<%=basePath%>rest/role/update?permissionIds='+permissionIds,
     	        type : "POST" , 
     	        dataType:'json',
     	        data : $("#modifyRoleForm").serialize(),
     	        success : function(data) {
     				if (data.state) {
     					layer.alert('编辑成功!');
     					parent.$("#roletable").trigger("reloadGrid");//自动刷新grid
	          			parent.layer.close(index);
     				} else {
     					layer.alert( data.msg);
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