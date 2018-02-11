<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/views/common/taglib.jsp"%>

<html >
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>${systemNameView}-组织机构管理</title>
	<%@ include file="/views/common/resources.jsp"%>
	<link href="${basePath}static/js/common/easyui/themes/bootstrap/easyui.css" rel="stylesheet"> 
	<link href="${basePath}static/js/common/easyui/themes/icon.css" rel="stylesheet">
	<script src="${basePath}static/js/common/easyui/jquery.easyui.min.js"></script>
	<script src="${basePath}static/js/common/easyui/locale/easyui-lang-zh_CN.js"></script>

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
		.cs_container{
			padding: 15px 0;
		}
	</style>
</head>
<!-- END HEAD -->
<body>
    <%@ include file="/views/common/head.jsp"%>
	<input  type="hidden" id="currentDeptId" value="${currentDeptId }"/>
	<input  type="hidden" id="currentUserName" value="${currentUserName }"/>
	
	<div class="container-fluid">
	<%-- <div class="notice-box">
		<div class="cs-retcrumb">
	        <span class="glyphicon glyphicon-home"></span>
			<a href="${basePath}rest/index">首页</a>
			<span>/</span>
			<a class="active">组织机构管理</a>
		</div>
	</div> --%>
	<div class="cs_wrapper">
	<div class="cs_container">
	
	<div class="task_form nomarginright nopaddingleft" style="margin-right:0;padding-top:0;">
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
						<th data-options="field:'deptId',hidden:true"></th>
						<th data-options="field:'parentId',hidden:true"></th>
						<th data-options="field:'deptName'" width="250" style="height:30px;">部门名称</th>
						<!-- <th data-options="field:'deptNumber'" width="200">部门编号</th>
						<th data-options="field:'description'" width="200">描述</th> -->
						<th data-options="field:'tel'" width="200">电话</th>
						<th data-options="field:'deptState',formatter:function(v){
									   if(v=='1'){
									      return '启用';
									   }else{
									      return '禁用';
									   }
									}"
							width="100">状态</th>
					</tr>
				</thead>
			</table>
		<!-- /.col -->
		</div>	
	
	</div>
	</div>
	</div>

	<!--新增部门-->
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
					<h4 class="modal-title" id="gridSystemModalLabel">新增模块</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="addForm">
						<!-- #section:elements.form -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								<span style="color:red">*</span>部门名称</label>

							<div class="col-sm-9">
								<input type="hidden" name="parentId" id="parentIdAdd"> 
								<input type="hidden" name="parentName" id="parentNameAdd"> 
								<input type="text" name="deptName"  class="form-control" id="deptNameAdd" placeholder="请输入部门名称"/>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								部门编号</label>

							<div class="col-sm-9">
								 <input type="text" name="deptNumber" class="form-control input-sm" placeholder="请输入部门编号"/>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								联系电话</label>

							<div class="col-sm-9">
								 <input type="text" name="tel" class="form-control" placeholder="请输入手机号码"/>
							</div>
						</div>
						<!-- 
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								职位</label>

							<div class="col-sm-9">
								 <input type="text" name="positionName" class="form-control input-sm" placeholder="请输入职位名称"/>
							</div>
						</div>
						 
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述</label>

							<div class="col-sm-9">
								<textarea class="form-control" rows="3" name="description"
									id="descriptionAdd"></textarea>
							</div>
						</div>
						-->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">状态</label>

							<div class="col-sm-9">
								<select name="deptState" class="form-control" id="isValidAdd">
									<option value="1">生效</option>
									<option value="0">失效</option>
								</select>
							</div>
						</div>
						<div class="clearfix form-actions">
						   	  <div class="col-sm-8  col-sm-offset-3">
						   	        
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

	<!--编辑部门-->
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
					<h4 class="modal-title" id="gridSystemModalLabel">编辑部门</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="editForm">
						<!-- #section:elements.form -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								部门名称</label>

							<div class="col-sm-9">
								<input type="hidden" name="deptId" id="deptIdEdit">
								<input type="hidden" name="deptLevel" id="deptLevelEdit">
								<input type="text" name="deptName" class="form-control" id="deptNameEdit" />
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								部门编号</label>

							<div class="col-sm-9">
								<input type="text" name="deptNumber" id="deptNumberEdit" />
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								联系电话</label>

							<div class="col-sm-9">
								<input type="text" name="tel" class="form-control" id="telEdit" />
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述</label>

							<div class="col-sm-9">
								<textarea class="form-control" rows="3" name="description"
									id="descriptionEdit"></textarea>
							</div>
						</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">状态</label>

							<div class="col-sm-9">
								<select name="deptState" class="form-control" id="deptStateEdit">
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
						</div>
						<div class="clearfix form-actions">
						   	  <div class="col-sm-8  col-sm-offset-3">
						   	       
						            
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
			changeMenuColor("systemli","deptManage");
			
			 init();
			 $(window).resize(function(){
				 //浏览器宽度改变的时候重设表格宽度
				 $('#datagrid').datagrid('resize', {
	                width: $(".databorder").width(),
	            }).datagrid('resize', {
	                width: $(".databorder").width(),
	            });
			 });
			 
			 var validateAdd = $("#addForm").validate({
		         focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
		         onkeyup: false,   
		         rules:{
		        	 deptName:{
		                 required:true
		             },
		             tel:{
		            	 mobile:true
		             }
		         },
		         messages:{
		        	 deptName:{
		                 required:"部门名称为必填项",
		                
		             },
		             tel:{
		            	 mobile:"手机格式不正确"
		             }
		         },
		         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
		        	 $.ajax({
							url : "${basePath}rest/dept/saveDept",
							type : "POST",
							data : $("#addForm").serialize(),
							success : function(data, stat) {
								if (data.state) {
									$.messager.alert('提示', "保存成功", 'info');
									$('#addModal').modal('hide');//
									init();
									//$("#datagrid").treegrid("reload");
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
		        	 deptName:{
		                 required:true
		             },
		             tel:{
		            	 mobile:true
		             }
		         },
		         messages:{
		        	 deptName:{
		                 required:"部门名称为必填项",
		                
		             },
		             tel:{
		            	 mobile:"手机格式不正确"
		             }
		         },
		         submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
		        	 $.ajax({
							url : "${basePath}rest/dept/editDept",
							data : $("#editForm").serialize(),
							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
							success : function(data, stat) {
								if (data.state) {
									$.messager.show({title : '提示',msg : '保存成功',showType : 'show'});
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
						//rownumbers : true,
						animate : true,
						collapsible : false,
						fitColumns : true,
						url : "${basePath}rest/dept/getTree/null",
						singleSelect : true,
						idField : 'deptId',
						treeField : 'deptName',
						border : false,
						headerHeight : 40,
						onBeforeExpand : function(row) {
							if (row) {
								$("#datagrid").treegrid('options').url = '${basePath}rest/dept/getTree/'+ row.deptId;
							}
						},
						onBeforeEdit : function(row) {
						},
						onAfterEdit : function(row, changes) {
						},
						onLoadSuccess : function() {
						},
						onClickRow : function(row){
							$('#datagrid').treegrid('toggle', row.deptId);
						}
					});
		}
		//删除模块
		function actionBtnDel() {
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$.messager.confirm('提示','你是否将要删除 <'+node.deptName+'>部门？',function(r) {
					if (r) {
						$.ajax({
									url : "${basePath}rest/dept/delDept/"+ node.deptId,
									contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
									success : function(data,stat) {
										if (data.state) {
											$.messager.alert('提示','删除成功','info');
										} else {
											$.messager.alert('提示',data.msg,'info');
										}
										$("#datagrid").treegrid('options').url = "${basePath}rest/dept/getTree/null";
										$("#datagrid").treegrid("reload");
									},
									failure : function() {
										$("#datagrid").treegrid('options').url = "${basePath}rest/dept/getTree/null";
										$("#datagrid").treegrid("reload");
									}
						});
					}
				});
			} else {
				$.messager.alert('提示', '你没有选择任何部门！', 'info');
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
				$("#parentIdAdd").val(node.deptId);
				$("#parentNameAdd").val(node.deptName);
			} else {
				/* $.messager.confirm('提示', '你没有选择任何部门节点，是否将要创建顶级部门？',
						function(r) {
							if (r) {
								$("#addModal").modal({
									keyboard : false,
									backdrop : 'static'
								});
							}
						}); */
				$.messager.confirm('提示', '你没有选择任何部门节点',
					function(r) {
					});
			}
		}
		//编辑模块弹窗
		function editModule() {
			$('#editForm')[0].reset();//重置
			var node = $("#datagrid").treegrid('getSelected');
			var currentDeptId = $("#currentDeptId").val();
			var currentUserName = $("#currentUserName").val();
			if (node) {
				//只能对当前用户所在部门，或者其下级部门进行编辑
				if((currentUserName != 'admin') && ((node.deptId == currentDeptId) || (node.parentId == currentDeptId))){
					editMuduleModal(node);
				}else if(currentUserName == 'admin'){//系统管理员都可以编辑
					editMuduleModal(node);
				}else{
					$.messager.alert('提示', '只能对您所在部门或下属部门进行修改！');
				}
				
			} else {
				$.messager.alert('提示', '请选择需要编辑的模块！');
			}
		}
		
		function editMuduleModal(node){
			$("#editModal").modal({
				keyboard : false,
				backdrop : 'static'
			});
			$("#deptIdEdit").val(node.deptId);
			$("#deptNameEdit").val(node.deptName);
			$("#deptNumberEdit").val(node.deptNumber);
			$("#descriptionEdit").val(node.description);
			$("#deptLevelEdit").val(node.deptLevel);
			$("#telEdit").val(node.tel);
		}
	</script>
</body>
</html>