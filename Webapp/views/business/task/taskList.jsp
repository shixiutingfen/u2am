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
<title>任务管理</title>
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
				<a class="btn btn-default"  data-toggle="modal" data-target="addRoleModal" 
					onclick="addNew()"><i class="fa fa-plus" aria-hidden="true"></i> 新增
				</a> 
				<a class="btn btn-default" onclick="testAddData()"> 
					<i class="fa fa-pencil-square-o" aria-hidden="true"></i> 编辑
				</a>
			</div>
		</div>
	</div>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		function addNew(){
			layer.open({
				type : 2,
				title : '添加任务',
				shadeClose : true,
				shade : 0.1,
				area : [ '80%', '80%' ],
				content : '<%=basePath%>rest/task/addTask' 
			});
		}
		function testAddData(){
			$.ajax({
				url:'<%=basePath%>rest/task/addData',
				data:{
					
				},
				type : "POST" , 
				dataType:'json',
				success:function(data){
					
				},
				failure : function() {
					layer.closeAll('dialog');
					layer.msg('操作超时!');
				}
			});
		}
	</script>
</body>
</html>