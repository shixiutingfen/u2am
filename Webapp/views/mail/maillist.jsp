<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/views/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<title>${systemNameView}-通知</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<base href="${basePath}" id="basePath">
		<meta charset="utf-8" />
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<%-- <jsp:include page="/views/common/head.jsp" flush="true"/> --%>
		<%@ include file="/views/common/resources.jsp"%>
	</head>
	
<body>
   <%@ include file="/views/common/head.jsp"%>
	<!-- <div class="notice-box">
		<div class="cs-retcrumb">
			<span class="glyphicon glyphicon-home"></span>
			<a class="active">通知</a>
		</div>
	</div> -->

<div class="container-fluid">
   <div class="cs_wrapper">
   		<div class="cs_container ca_dataBase">
			<div class="widget-box transparent tabbable">
				<div class="widget-header">
					<h4 class="widget-title lighter smaller" style="float:right">
						<button class="btn btn-primary" type="button" onclick="send()">
							<i class="ace-icon fa fa-envelope bigger-110"></i>
							发信
						</button>
					</h4>
					<div class="widget-toolbar no-border" style="float:left">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active">
								<a data-toggle="tab" id="mailAll" href="#All" onclick="getData('All')">
									全部
								</a>
							</li>
							<li>
								<a data-toggle="tab" id="mailNotRead" href="#NotRead" onclick="getData('NotRead')">
									未读信件
								</a>
							</li>
							<li>
								<a data-toggle="tab" id="mailHaveRead" href="#HaveRead" onclick="getData('HaveRead')">
									已读信件
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="widget-body jl-mgt12">
					<div class="widget-main padding-0">
						<div class="tab-content padding-0">
							<div id="All" class="tab-pane fade in active">
								<table id="gridAll"></table>
								<div id="gridpagerAll"></div>
							</div>
							<div id="NotRead" class="tab-pane fade">
								<table id="gridNotRead"></table>
								<div id="gridpagerNotRead"></div>
							</div>
							<div id="HaveRead" class="tab-pane fade">
								<table id="gridHaveRead"></table>
								<div id="gridpagerHaveRead"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
   </div>
</div>
</div>

<script type="text/javascript">
function send(){
	window.location.href = '${basePath}rest/mail/sendMail';
}
	
//切换tab页事件
function getData(type){
	initTab(type);
}
	
//初始化表格
function initTab(type){
	$("#grid"+type).jqGrid({
	    url: '${basePath}rest/mail/queryEmailListByPage?type=' + type,
	    datatype: "json",
		height: 'auto',
		width: 'auto',
		colNames:['状态','发信人','标题', '时间'],
		viewrecords: true, //是否显示行数 
		autoScroll: true, 
		colModel:[
			{name:'readFlag',index:'readFlag',sortable:false, width:5, formatter: formateRf},
			{name:'senderName', index:'senderName',sortable:false, width:8},
			{name:'mailTitle', index:'mailTitle',sortable:false, width:55, formatter: formateMt},
			{name:'sendTime',index:'sendTime', width:10,sortable:false, formatter: formateTime},
		], 

		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30],
		pager : "#gridpager"+type,
		altRows: true,
		multiselect: false,
        multiboxonly: true,
        loadComplete : function() {
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
			
		}
	});
	$("#grid"+type).setGridWidth($(".widget-header").width());
}
	
function updatePagerIcons(table) {
	var replacement = 
	{
		'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
		'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
		'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
		'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		
		if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
	})
}
	
function formateRf(cellvalue, options, rawObject) {
	if(rawObject.readFlag == "0"){
		return "<img src='${basePath}static/images/notread.png'/>";
	}else{
		return "<img src='${basePath}static/images/hadread.png'/>";
	}
}

function formateMt(cellvalue, options, rawObject) {
	return "<a href='javascript:;' onclick=viewMailDetail('"+ rawObject.mailRecieveId + "')>" + cellvalue + "</a>";
}

function formateBody(cellvalue, options, rawObject){
	var v = cellvalue;
	var index = v.indexOf("&nbsp;");
	while(index > 0){
		v = v.replace("&nbsp;"," ");
		index = v.indexOf("&nbsp;");
	}
	index = v.indexOf("<a");
	while(index > 0){
		v = v.replace("<a","<span");
		index = v.indexOf("<a");
	}
	index = v.indexOf("</a>");
	while(index > 0){
		v = v.replace("</a>","</span>");
		index = v.indexOf("</a>");
	}
	if(v && v.length > 120){
		return v.substr(0, 120) + '<span>...</span>'; 
	}else{
		return v;
	}
}

function formateTime(cellvalue, options, rawObject){
	return cellvalue.substr(0,cellvalue.length - 4);
}

function viewMailDetail(id){
	window.location.href='${basePath}rest/mail/viewMailDetail?mailRecieveId=' + id;
}
	
$(function(){
	initTab('All');
});

</script>
</body>
</html>