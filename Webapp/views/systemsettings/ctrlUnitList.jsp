<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html >
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
        <title>${systemNameView}-组织机构管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
<jsp:include page="/views/common/header.jsp" flush="true"/>
<link rel="icon" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon"/>
 <link rel="bookmark" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon"/>
<link href="<%=basePath%>static/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="<%=basePath%>static/easyui/themes/icon.css" rel="stylesheet">
<script src="<%=basePath%>static/easyui/jquery.easyui.min.js"></script>
<script src="<%=basePath%>static/easyui/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
	.datagrid-header .datagrid-cell span, .tree-title, .datagrid-cell{
		font-size: 14px;
	}
	.datagrid-header-row{
		font-weight: bold;
	}
	.datagrid-header-row td, .datagrid-row td{
		height : 35px;
	}
</style>
</head>
<!-- END HEAD -->
<body >
	<div class="notice-box">
		<div class="cs-retcrumb">
	             	<i class="fa fa-home" aria-hidden="true"></i>
			<a href="<%=basePath%>rest/index">个人平台</a>
			<span>/</span>
			<a class="active">辖区管理</a>
		</div>
	</div>
	
	<div class="container-fluid">
	<div class="cs_wrapper">
	<div class="cs_container">
	
	<div class="task_form nomarginright" style="margin-right:0;">
            <form class="form-inline" id="con_from">
				
				<button class="btn btn-default" type="button"
					data-toggle="modal" onclick="addDept()">
					<i class="fa fa-plus" aria-hidden="true"></i> 新增
				</button>
				<button class="btn btn-default" type="button"
					onclick="editModule()">
					<i class="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑
				</button>
				<button class="btn btn-default" type="button"
					onclick="actionBtnDel()">
					<i class="fa fa-remove" aria-hidden="true"></i> 删除
				</button>
				
            </form>
        </div>
	
		<div class="databorder">
			<table id="datagrid">
				<thead>
					<tr>
						<th data-options="field:'id',hidden:true"></th>
						<th data-options="field:'unitName'" width="250">辖区名称</th>
						<!-- <th data-options="field:'unitNumber'" width="200">辖区编号</th> -->
						<th data-options="field:'description'" width="200">描述</th>
						<!-- 
						<th data-options="field:'unitState',formatter:function(v){
									   if(v=='1'){
									      return '启用';
									   }else{
									      return '禁用';
									   }
									}"
							width="100">状态</th> -->
					</tr>
				</thead>
			</table>
				
		</div>
	</div>
	</div>
	</div>

	<!--新增辖区-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" id="addModal"
		role="dialog" aria-labelledby="myLargeModalLabel"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" style="width: 500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">新增辖区</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="addForm">
						<!-- #section:elements.form -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<span style="color:red">*</span>辖区名称</label>

							<div class="col-sm-8">
								<input type="hidden" name="parentId" id="parentIdAdd"> 
								<input type="hidden" name="parentName" id="parentNameAdd"> 
								<input type="text" name="unitName"  class="form-control" id="unitNameAdd" placeholder="请输入辖区名称"/>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								辖区编号：</label>

							<div class="col-sm-8">
								 <input type="text" name="unitNumber" class="form-control input-sm" placeholder="请输入辖区编号"/>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述：</label>

							<div class="col-sm-8">
								<textarea class="form-control" rows="3" name="unitDescription"
									id="unitDescriptionAdd"></textarea>
							</div>
						</div>
						<div class="clearfix form-actions">
						   	  <div class="text-center">
						   	        <!-- <input  type="submit" class="btn btn-primary" value="保存"/> -->
						            <button class="btn btn-primary" type="submit">
										<i class="ace-icon fa fa-check bigger-110"></i>
										保存
									</button>
						            <button class="btn btn-default" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										重置
									</button>
									<button class="btn btn-default" type="button" data-dismiss="modal">
										<i class="ace-icon fa fa-close bigger-110"></i>
										关闭
									</button>
						            
						    </div>
					    </div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--编辑辖区-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1"
		id="editModal" role="dialog" aria-labelledby="myLargeModalLabel"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" style="width: 500px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">编辑辖区</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="editForm">
						<!-- #section:elements.form -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								辖区名称：</label>

							<div class="col-sm-8">
								<input type="hidden" name="id" id="idEdit">
								<input type="hidden" name="unitLevel" id="unitLevelEdit">
								<input type="hidden" name="longNumber" id="longNumberEdit">
								<input type="text" name="unitName" id="unitNameEdit" class="form-control"/>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								辖区编号：</label>

							<div class="col-sm-8">
								<input type="text" name="unitNumber" id="unitNumberEdit" class="form-control input-sm"/>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述：</label>

							<div class="col-sm-8">
								<textarea class="form-control" rows="3" name="unitDescription"
									id="unitDescriptionEdit"></textarea>
							</div>
						</div>
						<div class="clearfix form-actions">
						   	  <div class="text-center">
						   	        <!-- <input  type="submit" class="btn btn-primary" value="保存"/> -->
						            
						            <button class="btn btn-primary" type="submit">
										<i class="ace-icon fa fa-check bigger-110"></i>
										保存
									</button>
									
						            <button class="btn btn-default" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										重置
									</button>
									
									<button class="btn btn-default" type="button" data-dismiss="modal">
										<i class="ace-icon fa fa-close bigger-110"></i>
										关闭
									</button>
						    </div>
					    </div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!--新增模块-->
	<script type="text/javascript">
		jQuery(function($) {
			changeMenuColor("systemli");
			init();
			 var validateAdd = $("#addForm").validate({
		         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
		         onkeyup: false,   
		         rules:{
		        	 unitName:{
		                 required:true
		             },
		             unitNumber:{
		            	 required:true
		             }
		         },
		         messages:{
		        	 unitName:{
		                 required:"辖区名称为必填项",
		                
		             },
		             unitNumber:{
		            	 required:"辖区编号为必填项"
		             }
		         },
		         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
		        	 $.ajax({
							url : "<%=basePath%>rest/dept/saveCtrl",
							type : "POST",
							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
							data : $("#addForm").serialize(),
							success : function(data, stat) {
								if (data.state) {
									$.messager.alert('提示', "保存成功", 'info');
									$('#addModal').modal('hide');//
									init();
								} else {
									$.messager.alert('提示', data.msg, 'info');
								}
							},
							failure : function() {
								$.messager.alert('提示', '操作超时！');
							}
		     	     });
		         }
		                   
		     }); 
			 var validateEdit = $("#editForm").validate({
		         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
		         onkeyup: false,   
		         rules:{
		        	 unitName:{
		                 required:true
		             },
		             unitNumber:{
		            	 required:true
		             }
		         },
		         messages:{
		        	 unitName:{
		        		 required:"辖区名称为必填项",
		                
		             },
		             unitNumber:{
		            	 required:"辖区编号为必填项"
		             }
		         },
		         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
		        	 $.ajax({
							url : "<%=basePath%>rest/dept/editCtrl",
							data : $("#editForm").serialize(),
							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
							success : function(data, stat) {
								if (data.state) {
									$.messager.alert('提示','保存成功','info');
									$('#editModal').modal('hide');//
									init();
								} else {
									$.messager.alert('提示', data.msg, 'info');
								}
							},
							failure : function() {
								$.messager.alert('提示', '操作超时！');
							}
						});
		         }
		                   
		     }); 
			
		});
		function init(){
			$("#datagrid").treegrid(
					   {
						fit : false,
						nowrap : false,
						rownumbers : true,
						animate : true,
						collapsible : false,
						fitColumns : true,
						url : "<%=basePath%>rest/dept/getCtrlTree/null",
						singleSelect : true,
						idField : 'id',
						treeField : 'unitName',
						border : false,
						onBeforeExpand : function(row) {
							if (row) {
								$("#datagrid").treegrid('options').url = '<%=basePath%>rest/dept/getCtrlTree/'+ row.id;
							}
						},
						onBeforeEdit : function(row) {
						},
						onAfterEdit : function(row, changes) {
						},
						onLoadSuccess : function() {
						},
						onClickRow : function(row){
							$('#datagrid').treegrid('toggle', row.id);
						}
					});
		}
		//删除模块
		function actionBtnDel() {
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$.messager.confirm('提示','你是否将要删除 <'+node.unitName+'>辖区？',function(r) {
					if (r) {
						$.ajax({
									url : "<%=basePath%>rest/dept/delCtrl/"+ node.id,
									contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
									success : function(data,stat) {
										if (data.state) {
											$.messager.alert('提示','删除成功','info');
										} else {
											$.messager.alert('提示',data.msg,'info');
										}
										$("#datagrid").treegrid('options').url = "<%=basePath%>rest/dept/getCtrlTree/null";
										$("#datagrid").treegrid("reload");
									},
									failure : function() {
										$("#datagrid").treegrid('options').url = "<%=basePath%>rest/dept/getCtrlTree/null";
										$("#datagrid").treegrid("reload");
									}
						});
					}
				});
			} else {
				$.messager.alert('提示', '你没有选择任何辖区！', 'info');
			}
		}
		//新增模块弹窗
		function addDept() {
			$('#addForm')[0].reset();
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$("#addModal").modal({
					keyboard : false,
					backdrop : 'static'
				});
				$("#parentIdAdd").val(node.id);
				$("#parentNameAdd").val(node.unitName);
			} else {
				$.messager.confirm('提示', '你没有选择任何辖区节点，是否将要创建顶级辖区？',
						function(r) {
							if (r) {
								$("#addModal").modal({
									keyboard : false,
									backdrop : 'static'
								});
							}
						});
			}
		}
		//编辑模块弹窗
		function editModule() {
			$('#editForm')[0].reset();//重置
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$("#editModal").modal({
					keyboard : false,
					backdrop : 'static'
				});
				$("#idEdit").val(node.id);
				$("#unitNameEdit").val(node.unitName);
				$("#unitNumberEdit").val(node.unitNumber);
				$("#unitDescriptionEdit").val(node.unitDescription);
				$("#unitLevelEdit").val(node.unitLevel);
				$("#longNumberEdit").val(node.longNumber);
			} else {
				$.messager.alert('提示', '请选择需要编辑的模块！');
			}
		}
	</script>
</body>
</html>