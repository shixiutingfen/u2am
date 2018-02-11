<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/views/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${systemNameView}-通知</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<base href="${basePath}" id="basePath">
<%@ include file="/views/common/resources.jsp"%>
<!-- easyui -->
<link href="${basePath}static/js/common/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="${basePath}static/js/common/easyui/themes/icon.css" rel="stylesheet">
<script src="${basePath}static/js/common/easyui/jquery.easyui.min.js"></script>
<script src="${basePath}static/js/common/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${basePath}static/js/common/json2.js"></script>



</head>
<body class="cs_layer">
	<div class="modal-body">
		<input type="hidden" id="templateId" name="templateId"
			value="${templateId }"> <input type="hidden" id="useList"
			name="useList" value="${useList }" />
		<div class="row" style="margin-left: 0; margin-right: 0;">
			<div class="col-xs-7">
				<div class="row" style="margin-bottom: 5px;">
					<form class="form-inline">
						<div class="form-group">
							<label>搜索:</label> <input type="text" id="deptNameSarch"
								placeholder="请输入收件部门/人" class="form-control" /> <input
								id="hiddenText" type="text" style="display: none" />
						</div>
						<button class="btn btn-primary" type="button" id="sel">
							<i class="ace-icon glyphicon glyphicon-search bigger-110"></i> 查询
						</button>
						<button onclick="reflesh()" class="btn btn-color-2">
							<i class="glyphicon glyphicon-repeat" aria-hidden="true"></i> 重置
						</button>
					</form>
				</div>
				<div class="row">
					<table id="orgPersonTreeGrid">
						<thead>
							<tr>
								<th data-options="field:'id',hidden:true" width="100">id</th>
								<th data-options="field:'name'" width="600">名称</th>
								<th
									data-options="field:'type',formatter:function(value){
					         	if(value=='person'){
					         		return '用户';
					         	}else if(value=='org'){
					         		return '部门';
					         	}
					         }"
									width="100">类型</th>
							</tr>
						</thead>
					</table>
					</table>
				</div>
			</div>
			<div class="col-xs-4 col-xs-offset-1" id="orgContent">
				<div class="row" data-spy="affix">
					<div class="row">
						<div style="margin-bottom: 5px;">
							<button type="button" class="btn btn-primary" onclick="confirm()">
								<i class="ace-icon glyphicon glyphicon-ok bigger-110"></i>确定
							</button>
							<button id="btnClear" class="btn btn-default"
								onclick="clearData();return false;">
								<i class="ace-icon glyphicon glyphicon-trash bigger-110"></i>清空
							</button>
							<button id="btnDel" class="btn btn-default">
								<i class="ace-icon glyphicon glyphicon-minus bigger-110"></i>删除
							</button>

						</div>
					</div>
					<div class="row" style="height: 460px;">
						<table id="orgPersonGrid" class="easyui-datagrid"
							data-options="idField: 'id',fit:true ,fitcolumns:true">
							<thead>
								<tr>
									<th data-options="field:'id',hidden:true" width="100">id</th>
									<th data-options="field:'name'" width="200">名称</th>
									<th
										data-options="field:'type',formatter:function(value){
					         	if(value=='person'){
					         		return '用户';
					         	}else if(value=='org'){
					         		return '部门';
					         	}
					         }"
										width="150">类型</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var baseUrl = "${basePath}rest/dept/getOrgPersonTree";
$(function($) {
	 	initTree();
	 	initTable();
	 	$("#sel").click(function(){
	 		var searchKey=$("#deptNameSarch").val();
	 		var url = baseUrl + "?searchKey=" + encodeURI(searchKey);
			$("#orgPersonTreeGrid").treegrid("options").url = url;
			$("#orgPersonTreeGrid").treegrid("reload");
	 	});
	    $("#close").bind("click",function(){
	 		 parent.layer.close(index);
	 	});
	     
	    $("#btnDel").bind("click", function(){
    		var delRows = $("#orgPersonGrid").datagrid("getSelections");
    		var rows = $("#orgPersonGrid").datagrid("getRows");
    		if(delRows.length > 0){
    			for(var i = (rows.length - 1); i >= 0; i--){
    				for(var j = 0; j < delRows.length; j++){
    					if(rows[i].id == delRows[j].id){
    						$("#orgPersonGrid").datagrid("deleteRow", i);
    					}
    				}
    			}
    		}else{
    			layer.alert('请在已选列表中选择一条需要删除的记录!');
    			$(".jconfirm-box").css({"width":"250px", "left": $(".modal-body").width()/4});
    		}
    	});

    	$("#btnAdd").bind("click", function(){
    		var row = $("#orgPersonTreeGrid").treegrid("getSelected");
    		if(row.length == 0){
    			layer.alert('请在左侧树形列表中双击选择一个或多个部门/人!');
    			$(".jconfirm-box").css({"width":"250px", "left": $(".modal-body").width()/4});
    			return;
    		}
    		addToList(row);
    	});
});
 
 
function initTable(){
    $("#orgPersonGrid").datagrid({
		fit : false,
		nowrap : false,
		rownumbers : true,
		animate : true,
		collapsible : false,
		fitColumns : true,
		data: getCheckedData(),
		<%-- url : '<%=basePath%>rest/judge/loadWhoCanSee?temlateId='+$("#templateId").val()+ '&timeStamp=' + new Date().getTime(), --%>
		singleSelect : true,
		idField : 'id',
		border : false,
		onBeforeExpand : function(row) {
		},
		onDblClickRow:function(row){
			confirm();
		},
		onBeforeEdit : function(row) {
		},
		onAfterEdit : function(row, changes) {
		}
	});
}

function getCheckedData(){
	var recieverIds = parent.$("input[name=recieverIds]").val();
	var recieverNames = parent.$("input[name=recieverNames]").val();
	var arrId =  recieverIds.split(",");
	var arrName =  recieverNames.split(",");
	var data = [];
	
	for(var i = 0; i < arrId.length ;i ++){
		 var arrTemp = arrId[i].split("|");
		 if(arrTemp[0] != ''){
			 var t = '';
			 if(arrTemp[1] == '0'){
				 t = 'org';
			 }else{
				 t = 'person';
			 }
			 
			 data.push({id: arrTemp[0],
					name: arrName[i],
					deptNumber: arrTemp[0],
					state:'closed',
					type: t});
		 }
	 }
	
	return data;
}
 
function initTree(){
	 $("#orgPersonTreeGrid").treegrid({
		fit : false,
		nowrap : false,
		rownumbers : true,
		animate : true,
		collapsible : false,
		fitColumns : true,
		url : "${basePath}rest/dept/getOrgPersonTree?timeStamp=" + new Date().getTime(),
		singleSelect : true,
		idField : 'id',
		treeField : 'name',
		border : false,
		onBeforeExpand : function(row) {
			if (row) {
				$("#orgPersonTreeGrid").treegrid('options').url = '${basePath}rest/dept/getOrgPersonTree?parentId='+ row.id+ '&timeStamp=' + new Date().getTime();
			}
		},
		onDblClickRow:function(row){
			addToList(row);
		},
		onBeforeEdit : function(row) {
		},
		onAfterEdit : function(row, changes) {
		},
		onLoadSuccess : function(row) {
			initTreeAction();
		}
	});
}

var flag = true;
function initTreeAction(){
	if(flag){
		$(".datagrid-view2 .datagrid-btable tr:eq(0) td[field=name]").find(".tree-hit").trigger("click");
	}
	flag = false;
}
 
function addToList(row){
	var rows = $("#orgPersonGrid").datagrid("getRows");
	for(var i = 0; i < rows.length; i++){
		if(rows[i].id == row.id){
			$.messager.alert("提示", row.name + "已经在列表中！", "warning");
			return;
		}
	}
	
	$("#orgPersonGrid").datagrid("appendRow", row);
}

function confirm(){
	 var rows = $("#orgPersonGrid").datagrid("getRows");
	 if(rows.length == 0){
		 layer.alert('请在左侧树形列表中双击选择一个或多个部门/人!');
		$(".jconfirm-box").css({"width":"250px", "left": $(".modal-body").width()/4});
		return;
	 }
	
	 changePropelTo(rows);
	 parent.layer.close(index);
}

function clearData(){
    layer.confirm('确定清空已选列表所有数据吗？',{
  	  title:'提示',
  	  btn: ['确定','取消'] //按钮
  	}, function(){
  		var rows = $("#orgPersonGrid").datagrid("getRows");
		for(var i = (rows.length - 1); i >= 0; i--){
			$("#orgPersonGrid").datagrid("deleteRow", i);
		}
		layer.closeAll('dialog');
  	}, function(){
  		layer.close();
  	});
    
 	$(".jconfirm-box").css({"width":"250px", "left": $(".modal-body").width()/4});
}
 
/*
 * 设定推送对象到界面
 */
function changePropelTo(rows){
	var analyseWhoCanUse='';
	var recieverNames="";
	var recieverIds="";
	for(var i = 0; i < rows.length; i++){
		if(rows[i].type == "org"){
			var userdeptId=rows[i].deptNumber;
			var userdeptName=rows[i].name;
			analyseWhoCanUse+=userdeptId+','+userdeptName+','+0+'!';
			recieverNames+=userdeptName+",";
			recieverIds+=userdeptId+"|"+"0"+",";
		}
	}
	for(var i = 0; i < rows.length; i++){
		if(rows[i].type == "person"){
			var userdeptId=parseInt(rows[i].id);
			var userdeptName=rows[i].name;
			analyseWhoCanUse+=userdeptId+','+userdeptName+','+1+'!';
			recieverNames+=userdeptName+",";
			recieverIds+=userdeptId+"|"+"1"+",";
		}
	}
	parent.$("input[name='recieverNames']").val(recieverNames);
	parent.$("input[name='recieverIds']").val(recieverIds);
	parent.layer.close(index);
	
}
/* $(document).keydown(function(event){ 
	if(event.keyCode==13){ 
		$("#sel").click(); 
	} 
});  */
function reflesh(){
	$("form").reset();
	$("#deptNameSarch").val("");
}
</script>
</body>
</html>