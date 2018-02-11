<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${systemNameView}-菜单管理</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="MobileOptimized" content="320">
<%@ include file="/views/common/head.jsp"%>
<!-- easyui -->
<link href="<%=basePath%>static/js/common/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="<%=basePath%>static/js/common/easyui/themes/icon.css" rel="stylesheet">
<script src="<%=basePath%>static/js/common/easyui/jquery.easyui.min.js"></script>
<script src="<%=basePath%>static/js/common/easyui/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
.datagrid-header .datagrid-cell span, .tree-title, .datagrid-cell {
	font-size: 14px;
}

.datagrid-header-row {
	font-weight: bold;
}

.datagrid-header-row td, .datagrid-row td {
	height: 35px;
}

.cs_container {
	padding: 15px 0;
}
</style>
</head>
<body>


	<div class="container-fluid">
		<div class="cs_wrapper">
			<div class="cs_container">

				<div class="task_form nomarginright nopaddingleft"
					style="margin-right: 0; padding-top: 0;">

					<button class="btn btn-default" type="button" data-toggle="modal"
						onclick="addModule()">
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

				</div>
				<!-- 
								<button class="btn btn-white btn-primary btn-sm" type="reset">
									<i class="ace-icon glyphicon glyphicon-user"></i> 更换父节点
								</button>
								 -->
				<div class="databorder">
					<table id="datagrid">
						<thead>
							<tr>
								<th data-options="field:'moduleId',hidden:true"></th>
								<th data-options="field:'moduleName'" width="250">模块名称</th>
								<th data-options="field:'moduleNumber'" width="200">模块编号</th>
								<th data-options="field:'moduleUrl'" width="250">资源链接</th>
								<th data-options="field:'seq'" width="100">顺序编号</th>
								 <th data-options="field:'moduleState',formatter:function(v){
											   if(v=='1'){
											      return '启用';
											   }else{
											      return '关闭';
											   }
											}"
									width="100">状态</th>
								<!-- <th
									data-options="field:'isVisible',formatter:function(v){
											   if(v==1){
											      return '可见';
											   }else{
											      return '不可见';
											   }
											}"
									width="100">是否可见</th> -->
								<th data-options="field:'moduleIcon'" width="300">图标资源连接</th>
								<th data-options="field:'createTime'" width="150">创建时间</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->

	<!--新增模块-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" id="addModal"
		role="dialog" aria-labelledby="myLargeModalLabel"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" style="width: 500px;margin-top:100px;">
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
								模块名称</label>

							<div class="col-sm-9">
								<input type="hidden" name="moduleId" id="parentIdAdd"> <input
									type="text" name="moduleName" class="form-control"
									id="moduleNameAdd" autofocus />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								模块编号</label>

							<div class="col-sm-9">
								<input type="text" name="moduleNumber" class="form-control"
									id="moduleNumberAdd" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								模块资源链接</label>

							<div class="col-sm-9">
								<input type="text" name="moduleUrl" class="form-control"
									id="moduleUrlAdd" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								图片url</label>

							<div class="col-sm-9">
								<input type="text" name="moduleIcon" class="form-control"
									id="moduleIconAdd" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述</label>

							<div class="col-sm-9">
								<textarea class="form-control" rows="3" name="moduleDescription"
									id="moduleDescriptionAdd"></textarea>
							</div>
						</div>
						 <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">状态</label>
							<div class="col-sm-9">
								<select name="state" class="chosen-select form-control" id="stateAdd">
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								顺序编号</label>
							<div class="col-sm-9">
								<input class="form-control" rows="3" name="seq"
									id="seqAdd"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">首页菜单</label>
							<div class="col-sm-9">
								<select name="info1" class="chosen-select form-control" id="info1Add">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
						</div>
						<div class="clearfix form-actions">
							<div class="col-sm-8  col-sm-offset-3">

								<button class="btn btn-primary" type="submit">
									<i class="ace-icon fa fa-check bigger-110"></i> 保存
								</button>

								<button class="btn btn-default" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i> 重置
								</button>

								<button class="btn btn-default" type="button"
									data-dismiss="modal">
									<i class="ace-icon fa fa-close bigger-110"></i> 关闭
								</button>

							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!--编辑模块-->
	<div class="modal fade bs-example-modal-lg" tabindex="-1"
		id="editModal" role="dialog" aria-labelledby="myLargeModalLabel"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" style="width: 500px;margin-top:100px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="gridSystemModalLabel">编辑模块</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="editForm">
						<!-- #section:elements.form -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								模块名称</label>

							<div class="col-sm-9">
								<input type="hidden" name="moduleId" id="parentIdEdit">
								<input type="hidden" name="moduleLevel" id="moduleLevelEdit">
								<input type="text" name="moduleName" class="form-control"
									id="moduleNameEdit" autofocus />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								模块编号</label>

							<div class="col-sm-9">
								<input type="text" name="moduleNumber" class="form-control"
									id="moduleNumberEdit" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								模块资源链接</label>

							<div class="col-sm-9">
								<input type="text" name="moduleUrl" class="form-control"
									id="moduleUrlEdit" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								图片url</label>

							<div class="col-sm-9">
								<input type="text" name="moduleIcon" class="form-control"
									id="moduleIconEdit" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								描述</label>

							<div class="col-sm-9">
								<textarea class="form-control" rows="3" name="moduleDescription"
									id="moduleDescriptionEdit"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">
								顺序编号</label>

							<div class="col-sm-9">
								<input class="form-control" rows="3" name="seq"
									id="seqEdit"/>
							</div>
						</div>
						 <div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">状态</label>
							<div class="col-sm-9">
								<select name="state" class="chosen-select form-control" id="stateEdit">
									<option value="0">禁用</option>
									<option value="1">启用</option>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">案件菜单</label>
							<div class="col-sm-9">
								<select name="info1" class="chosen-select form-control" id="info1Edit">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
						</div> 
					</div>
						<div class="clearfix form-actions mgb15">
							<div class="col-sm-8  col-sm-offset-3">

								<button class="btn btn-primary" type="submit">
									<i class="ace-icon fa fa-check bigger-110"></i> 保存
								</button>

								<button class="btn btn-default" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i> 重置
								</button>

								<button class="btn btn-default" type="button"
									data-dismiss="modal">
									<i class="ace-icon fa fa-close bigger-110"></i> 关闭
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
			var IsCheckFlag;
			init();
			$(window).resize(function() {
				//浏览器宽度改变的时候重设表格宽度
				$('#datagrid').datagrid('resize', {
					width : $(".databorder").width(),
				}).datagrid('resize', {
					width : $(".databorder").width(),
				});
			});
			$('.chosen-select').chosen({
				allow_single_deselect : true
			});
			var validate = $("#addForm")
					.validate(
							{
								focusInvalid : false, //当为false时，验证无效时，没有焦点响应  
								onkeyup : false,
								rules : {
									moduleName : {
										required : true
									},
									moduleNumber : {
										required : true
									}
								},
								messages : {
									moduleName : {
										required : "模块名称为必填项",

									},
									moduleNumber : {
										required : "模块编号为必填项"

									}
								},
								submitHandler : function(form) { //表单提交句柄,为一回调函数，带一个参数：form   
									$.ajax({
												url : "${basePath}rest/module/saveModule",
												type : "POST",
												contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
												data : $("#addForm").serialize(),
												success : function(data, stat) {
													if (data.state) {
														$.messager.show({
															title : '提示',
															msg : '保存成功',
															showType : 'show'
														});
														$('#addModal').modal(
																'hide');
														init();
													} else {
														$.messager.alert('提示',data.msg,'info');
													}
												},
												failure : function() {
													$.messager.alert('提示',
															'操作超时！');
												}
											});
								}

							});
			var validateEdit = $("#editForm").validate(
							{
								focusInvalid : false, //当为false时，验证无效时，没有焦点响应  
								onkeyup : false,
								rules : {
									moduleName : {
										required : true
									},
									moduleNumber : {
										required : true
									}
								},
								messages : {
									moduleName : {
										required : "模块名称为必填项",

									},
									moduleNumber : {
										required : "模块编号为必填项"

									}
								},
								submitHandler : function(form) { //表单提交句柄,为一回调函数，带一个参数：form   
									$.ajax({
												url : "${basePath}rest/module/editModule",
												data : $("#editForm").serialize()+ "&moduleNameEncode="+ encodeURI($("#moduleNameEdit").val()),
												contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
												success : function(data, stat) {
													if (data.state) {
														$.messager.alert('提示',
																'编辑成功！');
														$('#editModal').modal(
																'hide');//
														init();
													} else {
														$.messager.alert('提示',
																data.msg,
																'info');
													}
												},
												failure : function() {
													$.messager.alert('提示',
															'操作超时！');
												}
											});
								}

							});
		});
		function init() {
			$("#datagrid").treegrid({
								fit : false,
								nowrap : false,
								rownumbers : true,
								animate : true,
								collapsible : false,
								fitColumns : true,
								url : "${basePath}rest/module/getTree/null",
								singleSelect : true,
								idField : 'moduleId',
								treeField : 'moduleName',
								border : false,
								onBeforeExpand : function(row) {
									if (row) {
										$("#datagrid").treegrid('options').url = '${basePath}rest/module/getTree/'
												+ row.moduleId;
									}
								},
								onBeforeEdit : function(row) {
								},
								onAfterEdit : function(row, changes) {
								},
								onLoadSuccess : function() {
								},
								onClickRow : function(row) {
									IsCheckFlag=true;
									$('#datagrid').treegrid('toggle',
											row.moduleId);
								},
								onDblClickRow:function(row) {
									if(IsCheckFlag){
										IsCheckFlag=false;
										$('#datagrid').treegrid('unselect',
												row.moduleId);
									}
								}
							});
		}

		//删除模块
		function actionBtnDel() {
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$.messager.confirm('提示','你是否将要删除 <'+node.moduleName+'>功能模块？',
								function(r) {
									if (r) {
										$.ajax({
													url : "${basePath}rest/module/delModule/"
															+ node.moduleId,
													contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
													success : function(data,
															stat) {
														if (data.state) {
															$.messager.alert(
																	'提示',
																	'删除成功',
																	'info');
														} else {
															$.messager.alert(
																	'提示',
																	data.msg,
																	'info');
														}
														$("#datagrid")
																.treegrid(
																		'options').url = "${basePath}rest/module/getTree/null";
														$("#datagrid")
																.treegrid(
																		"reload");
													},
													failure : function() {
														$("#datagrid")
																.treegrid(
																		'options').url = "${basePath}rest/module/getTree/null";
														$("#datagrid")
																.treegrid(
																		"reload");
													}
												});
									}
								});
			} else {
				$.messager.alert('提示', '你没有选择任何节点！', 'info');
			}
		}
		//新增模块弹窗
		function addModule() {
			$('#addForm')[0].reset();
			var node = $("#datagrid").treegrid('getSelected');
			if (node) {
				$("#addModal").modal({
					keyboard : false,
					backdrop : 'static'
				});
				$("#parentIdAdd").val(node.moduleId);
				$.ajax({
					url : "${basePath}rest/module/findSeq/"+ node.moduleId,
					contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
					success : function(data,stat) {
							$("#seqAdd").val(data+1);
					
					}
				});

			} else {
				$.messager.confirm('提示', '你没有选择任何节点，是否将要创建顶级功能模块？',
						function(r) {
							if (r) {
								$("#addModal").modal({
									keyboard : false,
									backdrop : 'static'
								});
								$.ajax({
									url : "${basePath}rest/module/findSeq/null",
									contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
									success : function(data,stat) {
											$("#seqAdd").val(data+1);
									}
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
				$("#parentIdEdit").val(node.moduleId);
				$("#moduleNameEdit").val(node.moduleName);
				$("#moduleNumberEdit").val(node.moduleNumber);
				$("#moduleUrlEdit").val(node.moduleUrl);
				$("#moduleIconEdit").val(node.moduleIcon);
				$("#moduleDescriptionEdit").val(node.moduleDescription);
				$("#moduleLevelEdit").val(node.moduleLevel);
				$("#seqEdit").val(node.seq);
				//下拉框单独这样赋值是没用的
				$("#info1Edit").val(node.info1);
				$("#info1Edit").trigger('chosen:updated');
				$("#stateEdit").val(node.moduleState);
				$("#stateEdit").trigger('chosen:updated');

				$("#editModal").modal({
					keyboard : false,
					backdrop : 'static'
				});

			} else {
				$.messager.alert('提示', '请选择需要编辑的模块！');
			}
		}
	</script>
</body>
</html>