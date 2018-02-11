<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="MobileOptimized" content="320">
<%@ include file="/views/common/taglib.jsp"%>
<title>${systemNameView}-角色管理</title>
<style>
.cs_container {
	background-color: white;
	padding: 15px;
	margin-top: 15px;
	box-shadow: none;
}
</style>
</head>
<!-- END HEAD -->
<body>
	<%@ include file="/views/common/head.jsp"%>

	<div class="container-fluid">
		<div class="cs_wrapper">
			<div class="cs_container">
				<div class="task_form nomarginright noborderb"
					style="margin-right: 0;">
					<!-- PAGE CONTENT BEGINS -->
					<form id="con_from" class="form-inline">
						<a class="btn btn-default" href="${basePath}rest/role/openaddrole"
							data-toggle="modal" data-target="addRoleModal" onclick="addNew()">
							<i class="fa fa-plus" aria-hidden="true"></i> 新增
						</a> <a class="btn btn-default" onclick="editRole()"> <i
							class="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑
						</a>
						<button class="btn btn-default" type="button" onclick="deleteit()">
							<i class="fa fa-remove" aria-hidden="true"></i> 删除
						</button>
						<!-- 查询条件区 -->
						<div class="form-group mgl15">
							<label>条件：</label> <input type="hidden" id="cerentRoleId"
								value="${cerentRoleId}" />
							<div style="width: 150px; display: inline-block">
								<select id="con" class="chosen-select form-control">
									<option value="1">角色名称</option>
									<!-- <option value="2">权限名称</option> -->
								</select>
							</div>
						</div>
						<div class="form-group">
							<input type="text" id="context" class="form-control" name="" />
							<input id="hiddenText" type="text" style="display: none" />
						</div>
						<button class="btn btn-primary" type="button" id="sel">
							<i class="ace-icon fa fa-search bigger-110"></i> 查询
						</button>
					</form>
				</div>
				<!-- /.row -->

				<!-- 列表区 -->
				<div class="table-header2"></div>
				<table id="roletable" class="table table-hover table-striped"></table>

				<div id="rolepager"></div>

				<!-- PAGE CONTENT ENDS -->



				<!--修改角色-->
				<div class="modal fade bs-example-modal-lg" tabindex="-1"
					id="modifyRoleModal" role="dialog"
					aria-labelledby="myLargeModalLabel" data-backdrop="static"
					data-keyboard="false" data-roleId="" data-roleName="" data-state=""
					data-roleRemark="">
					<div class="modal-dialog modal-lg" style="width: 1200px;">
						<div class="modal-content"></div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			initTab();
			$('.chosen-select').chosen({
				allow_single_deselect : true
			});
			$(window).triggerHandler('resize.jqGrid');
			$("#sel")
					.click(
							function() {
								var com = $("#con").val();

								var url;
								if ("1" == com) {
									$("#context").attr("name", "roleName");
									url = '<%=basePath%>rest/role/queryByPage?roleName='
											+ encodeURI($("#context").val());
								} else if ("2" == com) {
									$("#context")
											.attr("name", "permissionName");
									url = '<%=basePath%>rest/role/queryByPage?permissionName='
											+ encodeURI($("#context").val());
								}
								var rowNumIndex = $("#roletable").jqGrid(
										"getGridParam", "rowNum");
								$("#roletable").jqGrid('setGridParam', {
									url : url,
									datatype : "json",
									height : 'auto',
									width : 'auto',
									viewrecords : true,
									rowNum : rowNumIndex,
									rowList : [ 10, 20, 30 ],
									pager : "#rolepager",
									altRows : true,
									multiselect : false,
									multiboxonly : true,
									loadComplete : function() {
										var table = this;
										setTimeout(function() {
											updatePagerIcons(table);
										}, 0);
									}
								}).trigger("reloadGrid"); //重新载入 
							});

		});

		function initTab() {

			//设置宽度
			$(window).on(
					'resize.jqGrid',
					function() {
						$("#roletable").jqGrid('setGridWidth',
								$(".table-header2").width() * 0.99);
					});

			$("#roletable").jqGrid({
				url : '<%=basePath%>rest/role/queryByPage',
				datatype : "json",
				height : 'auto',
				width : 'auto',
				colNames : [ '角色编号', '角色名称', '描述', '状态', '创建用户', '创建时间' ],
				viewrecords : true, //是否显示行数 
				autoScroll : true,
				colModel : [ {
					name : 'roleId',
					index : 'roleId',
					hidden : true
				}, {
					name : 'roleName',
					index : 'roleName',
					sortable : false,
					width : 40,
				}, {
					name : 'roleRemark',
					index : 'roleRemark',
					sortable : false,
					width : 40
				}, {
					name : 'state',
					index : 'state',
					width : 70,
					sortable : false,
					formatter : function(v, opt, rec) {
						if (v == '2')
							return '无效';
						return '有效';
					}
				}, {
					name : 'createUserName',
					index : 'createUserName',
					sortable : false,
					width : 40
				}, {
					name : 'createTimeStr',
					index : 'createTimeStr',
					sortable : false,
					width : 40
				} ],
				viewrecords : true,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : "#rolepager",
				altRows : true,
				multiselect : false,
				multiboxonly : true,
				loadComplete : function() {
					var table = this;
					setTimeout(function() {
						updatePagerIcons(table);
					}, 0);
				}
			});

			$("#roletable").setGridWidth($(".table-header2").width());
		}

		function updatePagerIcons(table) {
			var replacement = {
				'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
				'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
				'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
				'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
			};
			$(
					'.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
					.each(
							function() {
								var icon = $(this);
								var $class = $.trim(icon.attr('class').replace(
										'ui-icon', ''));

								if ($class in replacement)
									icon.attr('class', 'ui-icon '
											+ replacement[$class]);
							})
		}
		function deleteit() {
			var rowKey = $("#roletable").jqGrid('getGridParam', "selrow");//获取选中行id
			var rowData = $("#roletable").jqGrid('getRowData', rowKey);//获取选中行数据  rowData.address(单个参数值)
			var roleId = rowData.roleId;

			if ("1" == rowData.roleId) {
				layer.alert('系统管理员角色不能删除!');
				return;
			}

			if (rowKey) {
				layer.confirm('确定要删除此记录？', {
					title : '提示',
					btn : [ '确定', '取消' ]
				//按钮
				}, function() {
					$.ajax({
						url : '<%=basePath%>rest/role/delete?roleId=' + roleId,
						type : "POST",
						dataType : 'json',
						success : function(data) {
							if (data.state) {
								layer.alert('删除角色成功!');
								$("#roletable").trigger("reloadGrid");//自动刷新grid
							} else {
								layer.alert(data.msg);
							}
						},
						failure : function() {
							layer.alert('操作超时!');
						}

					});
					layer.closeAll('dialog');
				}, function() {
					layer.close();
				});
			} else {
				layer.alert('请选择一条记录!');
			}

		}

		function addNew() {
			layer.open({
				type : 2,
				title : '添加角色',
				shadeClose : true,
				shade : 0.1,
				area : [ '80%', '80%' ],
				content : '<%=basePath%>rest/role/openaddrole' 
			});
		}

		var curRoleId = null;
		var roleName = null;
		var roleRemark = null;
		var state = null;

		//编辑模块弹窗
		function editRole() {

			//$('#modifyUserForm')[0].reset();//重置
			var rowKey = $("#roletable").jqGrid('getGridParam', "selrow");//获取选中行id
			var node = $("#roletable").jqGrid('getRowData', rowKey);//获取选中行数据  rowData.address(单个参数值)

			if ("1" == node.roleId && "1" != $("#cerentRoleId").val()) {
				layer.alert('当前用户不允许修改系统管理员角色!');
				return;
			}

			if (rowKey) {
				layer.open({
					type : 2,
					title : '编辑角色',
					shadeClose : true,
					shade : 0.1,
					area : [ '80%', '80%' ],
					content : '<%=basePath%>rest/role/openmodifyrole?roleId='
							+ node.roleId,
				});
			} else {
				layer.alert('请选择一条记录!');
			}
		}
	</script>
</body>
</html>