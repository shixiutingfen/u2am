<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/taglib.jsp"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="<%=basePath%>static/images/favicon.ico"
	type="image/x-icon" />
<link rel="shortcut icon" href="<%=basePath%>static/images/favicon.ico"
	type="image/x-icon" />
<link rel="bookmark" href="<%=basePath%>static/images/favicon.ico"
	type="image/x-icon" />

<title>${systemNameView}-用户管理</title>
<style>
.cs_container {
	background-color: white;
	padding: 15px;
	margin-top: 15px;
	box-shadow: none;
}
</style>
</head>
<body>
	<%@ include file="/views/common/head.jsp"%>
	<div class="container-fluid">
		<div class="cs_wrapper">
			<div class="cs_container">
				<div class="task_form nomarginright noborderb"
					style="margin-right: 0;">
					<form class="form-inline" id="con_from">
							<a class="btn btn-default" onclick="addNew()"> <i
								class="fa fa-plus" aria-hidden="true"></i> 新增用户
							</a>
							<a class="btn btn-default" onclick="editUserPassword()"> <i
								class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改密码
							</a>
							<a class="btn btn-default" onclick="editUser()"> <i
								class="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑信息
							</a>
							<button class="btn btn-default" type="button"
								onclick="deleteit()">
								<i class="fa fa-remove" aria-hidden="true"></i> 删除用户
							</button>

						<div class="form-group mgl15">
							<label>搜索：</label> <input type="hidden" id="cerentUserId"
								value="${cerentUserId}" />
							<div style="width: 100px; display: inline-block;">
								<select id="con" class="chosen-select form-control">
									<option value="1">账号</option>
									<option value="2">姓名</option>
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
				<!-- 列表区 -->
				<div class="table-header2"></div>
				<table id="grid-table" class="table table-hover table-striped"></table>
				<div id="grid-pager"></div>
			</div>
		</div>
	</div>


	<!--修改用户-->
	<div class="modal fade bs-example-modal-lg" tabindex="-222"
		id="modfiyUserModal" role="dialog" aria-labelledby="myLargeModalLabel"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog modal-lg" style="width: 1200px;">
			<div class="modal-content"></div>
		</div>
	</div>



	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			initTab();
			$(window).resize(function(e) {
				initGridWidth();
			});

			$('.chosen-select').chosen({
				allow_single_deselect : true
			});
			$("#sel").click(
					function() {
						var com = $("#con").val();
						var url;
						if ("1" == com) {
							$("#context").attr("name", "username");
							url = '<%=basePath%>rest/user/queryByPage?username='
									+ encodeURI($("#context").val())
									+ '&currentUserId='
									+ $("#cerentUserId").val();
						} else if ("2" == com) {
							$("#context").attr("name", "realName");
							url = '<%=basePath%>rest/user/queryByPage?realName='
									+ encodeURI($("#context").val())
									+ '&currentUserId='
									+ $("#cerentUserId").val();
						}
						var rowNumIndex = $("#grid-table").jqGrid(
								"getGridParam", "rowNum");
						$("#grid-table").jqGrid('setGridParam', {
							url : url,
							datatype : "json",
							height : 'auto',
							width : 'auto',
							viewrecords : true,
							rowNum : rowNumIndex,
							rowList : [ 10, 20, 30 ],
							pager : "#grid-pager",
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
			$("#grid-table").jqGrid(
					{
						url : '<%=basePath%>rest/user/queryByPage?currentUserId='
								+ $("#cerentUserId").val(),
						datatype : "json",
						height : 'auto',
						//width: 'auto',
						colNames : [ '用户编号', '用户账号', '用户姓名', '所属部门id', '所属部门',
								'电话号码', '是否生效', '对应角色', '创建者', '创建时间', '备注' ],
						viewrecords : true, //是否显示行数 
						autoScroll : true,
						autoWidth : true,
						colModel : [ {
							name : 'userId',
							index : 'userId',
							hidden : true,
							key : true
						}, {
							name : 'username',
							index : 'username',
							width : 50,
							sortable : false
						}, {
							name : 'realName',
							index : 'realName',
							width : 50,
							sortable : false
						}, {
							name : 'deptId',
							index : 'deptId',
							hidden : true
						}, {
							name : 'deptName',
							index : 'deptName',
							width : 50,
							sortable : false
						}, {
							name : 'tel',
							index : 'tel',
							width : 50,
							sortable : false
						}, {
							name : 'isvalid',
							index : 'isvalid',
							hidden : true,
							sortable : false,
							formatter : function(v, opt, rec) {
								if (v == '0')
									return '无效';
								return '有效';
							}
						},
						{
							name : 'roleName',
							index : 'roleName',
							width : 50,
							sortable : false
						}, {
							name : 'createUserName',
							index : 'createUserName',
							width : 50,
							sortable : false
						}, {
							name : 'createTime',
							index : 'createTime',
							width : 50,
							sortable : false
						}, {
							name : 'remark',
							index : 'remark',
							width : 70,
							sortable : false
						} ],

						viewrecords : true,
						rowNum : 10,
						rowList : [ 10, 20, 30 ],
						pager : "#grid-pager",
						altRows : true,
						multiselect : false,
						multiboxonly : true,
						loadComplete : function() {
							var table = this;
							setTimeout(function() {
								updatePagerIcons(table);
							}, 0);
						},

					});

			initGridWidth();
		}

		function initGridWidth() {
			$("#grid-table").setGridWidth($(".table-header2").width());
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
			var rowKey = $("#grid-table").jqGrid('getGridParam', "selrow");//获取选中行id
			var rowData = $("#grid-table").jqGrid('getRowData', rowKey);//获取选中行数据  rowData.address(单个参数值)
			var userId = rowData.userId;

			if ("1" == rowData.userId) {
				layer.alert('系统管理员不允许删除!');
				return;
			}

			if (rowKey) {
				layer.confirm('确定要删除此用户吗？云空间资源也会被删除！', {
					offset : [ '40%', '40%' ],
					title : '提示',
					btn : [ '确定', '取消' ]
				//按钮
				}, function() {
					$.ajax({
						url : '<%=basePath%>rest/user/delete?userId=' + userId,
						type : "POST",
						dataType : 'json',
						success : function(data) {
							if (data.state) {
								layer.alert('删除用户成功!', {
									title : '提示',
									btn : [ '确定' ]
								//按钮
								}, function() {
									$("#grid-table").trigger("reloadGrid");//自动刷新grid
									layer.closeAll('dialog');
								}, function() {
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
				title : '新增用户',
				shadeClose : true,
				shade : 0.1,
				area : [ '80%', '80%' ],
				content : '<%=basePath%>rest/user/openAdduser' //iframe的url
			});
		}

		//编辑模块弹窗
		function editUser() {

			//$('#modifyUserForm')[0].reset();//重置
			var rowKey = $("#grid-table").jqGrid('getGridParam', "selrow");//获取选中行id
			var node = $("#grid-table").jqGrid('getRowData', rowKey);//获取选中行数据  rowData.address(单个参数值)

			if (("1" == node.userId) && "1" != $("#cerentUserId").val()) {
				layer.alert('当前用户不允许修改系统管理员!');
				return;
			}
			if (rowKey) {
				layer
						.open({
							type : 2,
							title : '编辑用户',
							shadeClose : true,
							shade : 0.1,//遮罩背景效果
							area : [ '80%', '80%' ],
							shift : 0,//动画效果 有0~6选
							content : '<%=basePath%>rest/user/openModifyuser?userId='
									+ node.userId,
							success : function(layero, index) {
								var body = layer.getChildFrame('body', index);
								var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
								body.find('#deptName').val(node.deptName);//传值到弹出页面
							}
						});

			} else {
				layer.alert('请选择一条记录!');
			}
		}

		function editUserPassword() {
			var rowKey = $("#grid-table").jqGrid('getGridParam', "selrow");//获取选中行id
			var node = $("#grid-table").jqGrid('getRowData', rowKey);//获取选中行数据  rowData.address(单个参数值)
			var userId = node.userId;
			var username = node.username;
			if (rowKey) {
				layer.open({
					type : 2,
					title : '修改密码',
					shadeClose : true,
					shade : 0.1,//遮罩背景效果
					area : [ '40%', '40%' ],
					shift : 0,//动画效果 有0~6选
					content : '<%=basePath%>rest/user/changeSelectedPwd?userId='
							+ userId + '&username=' + username
				});
			} else {
				layer.alert('请选择一条记录!');
			}
		}
	</script>
</body>
</html>