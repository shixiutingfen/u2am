<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<base href="${basePath}">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/views/common/resources.jsp"%>
<title>${systemNameView}</title>

<script src="${basePath}static/js/fancybox/source/jquery.fancybox.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}static/js/fancybox/source/jquery.fancybox.css">
<link rel="icon" href="${basePath}static/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${basePath}static/images/favicon.ico" type="image/x-icon"/>
<link rel="bookmark" href="${basePath}static/images/favicon.ico" type="image/x-icon"/>		
<link rel="stylesheet" type="text/css" href="${basePath}static/js/layim3.0.1/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${basePath}static/css/common/main.css">

<script src="${basePath}static/js/layim3.0.1/layui/layui.js" type="text/javascript"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type="text/javascript" src="<%=basePath%>dwr/interface/sendMsg.js"></script>
<script type="text/javascript" src="<%=basePath%>dwr/interface/pushMsg.js"></script>
<script src="${basePath}static/js/chat.js" type="text/javascript"></script>
<style>
   .table-responsive {
	   margin: 15px 15px 0;
   }
   .advanced_search_group a.chosen-single{
   	   height: 30px;
   }
</style>
	
</head>
<input type="hidden" value="${basePath}" id="basePath" />
<input type="hidden" id="userId" value="${userId }"/>
<body onload="onPageLoad();dwr.engine.setActiveReverseAjax(true);dwr.engine.setNotifyServerOnPageUnload(true);" class="overflow-auto" style="overflow-x: hidden" marginheight="0">
	<%@ include file="/views/common/head.jsp"%>
	<!-- <div class="notice-box-wrap" >
		<div id="breadcrumb" class="notice-box">
			<div class="cs-retcrumb pull-left" style="margin-left: 5px;">
				<span class="glyphicon glyphicon-home"></span> <span>首页</span>
			</div>
			<div class="cs-retcrumb pull-right">
				<ul class="clearfix">
					<li class="ge-notice-list"><i class="icon-notice"></i>
						<div id="Marquee" style="height: 30px; overflow: hidden"></div></li>
				</ul>
			</div>
		</div>

	</div>  -->
	
	<div class="content-wra">
	<div class="fl content-l">

	<div class="panel  table-responsive" style="height: 820px;">

		<div class="panel-body search_panel_body">
			<div class="form-group" style="margin-bottom:5px;">
				<div class="row" style="position:relative;top:8px;">
					<form id="searchForm" class="form-horizontal">
						<div class="row">
							<label class="col-md-1 control-label" style="width: 70px;">案件名称</label>
							<div class="col-md-2" style="margin-right:20px;">
								<input type="text" placeholder="请输入案件名称" class="form-control input-sm" id="lawcaseName">
							</div>
							<label class="col-md-1 control-label">创建时间</label>
							<div class="col-md-2">
								<div class="input-group input-append date form_datetime">
									<input placeholder="请输入开始时间" class="laydate-icon form-control input-sm" name="startTime1" id="startTime1" onclick="laydate({istime: true, max:laydate.now(),format: 'YYYY-MM-DD hh:mm:ss'})">
								</div>
							</div>
							
							<label class="col-md-1 control-label" style="text-align:center;">至</label>
							<div class="col-md-2">
								<div class="input-group input-append date form_datetime">
									<input placeholder="请输入结束时间" class="laydate-icon form-control input-sm" name="endTime1" id="startTime2" onclick="laydate({istime: true, max:laydate.now(),format: 'YYYY-MM-DD hh:mm:ss'})">
								</div>
							</div>
						</div>
						<div class="row advanced_search_group" id="highSearchDiv">
							<label class="col-md-1 control-label">接处警编号</label>
							<div class="col-md-2">
								<input type="text" placeholder="请输入接处警编号" class="form-control input-sm" name="recieveCode">
							</div>
							<label class="col-md-1 control-label" style="text-align:center;">案件类别</label>
							<div class="col-md-2">
								<input type="hidden" value="" id="categoryValue" class="form-control" name="categoryValue"> 
								<input type="hidden" id="categoryValueLevel" class="form-control"name="categoryValueLevel" >
								<input type="text"  id="category" class="form-control input-sm" style="cursor: pointer;" 
									name="category" value="" readonly="readonly" placeholder="点击选择案件类别"  onclick="choose();">
							</div>
							
							<label class="col-md-1 control-label">审批状态</label>
							<div class="col-md-2">
								<select id="verifyingStatus" name="verifyingStatus"  class="input-sm chosen-select form-control" >
									<option value="" selected="selected">请选择</option>
									<option value="1">新建</option>
									<option value="2">待审批</option>
									<option value="4">审批通过</option>
									<option value="3">审批不通过</option>
									<option value="6">补录</option>
								</select>
							</div>
						</div>
						<div style="margin-top:15px;">
							<div class=" handle_btn_group">
								<button type="button" class="btn btn-primary btn-sm" id="searchBtn">
									<i class="ace-icon fa fa-search bigger-110"></i> 查询
								</button>
								<button type="button" class="btn btn-default btn-sm"
									onclick="resetSearch()"><i class="ace-icon fa fa-undo bigger-110"></i>重置</button>
								<button type="button" class="btn btn-primary btn-sm" id="highSearchBtn" >
									<i class="ace-icon fa fa-angle-down bigger-110"></i>&nbsp;高级搜索
								</button>
								<button type="button" class="btn btn-info btn-sm" onclick="addLawcase()" style="text-align: right;"> 
									<i class="ace-icon fa fa-plus bigger-110"></i>&nbsp;新增案件
								</button>
							</div>
						</div>
					</form>
					<input type="hidden" id="othermay" name="othermay">
				</div>
			</div>

		</div>
		<div class="ztitle">
			案件列表
	    </div>
		<div class="panel panel-info table-responsive">
			<ul class="nav nav-tabs" role="tablist" id="myTab" style="padding-left: 30px;">
			</ul>

			<div class="tab-content" style="height:660px;">
				<div role="tabpanel" class="tab-pane active">
					<table id="caseList" style="border:0 none;"
						class="table table-hover table-striped noborderb">
					</table>
					<div id="grid-pager"></div>
					<div class="modal fade" id="reviseCaseModal">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<span class="bluehead">&nbsp;&nbsp;</span> 案件信息
								</div>
								<form class="form-horizontal" method="POST" id="lawcaseform"
									name="lawcaseform" style="margin-left: 100px">
									<div class="modal-body">
										<div class="row">
											<input type="hidden" id="uid" name="id"
												class="form-control input-sm inline">
										<div class="form-group">
												<label class="col-sm-2 control-label"> 接处警编号：</label>
												<div class="col-sm-6">
													<input type="text" id="caseCode"
														class="form-control input-sm inline">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"> <span
													style="color: red">*</span> 案件名称：
												</label>
												<div class="col-sm-6">
													<input type="text" id="caseName" name="caseName"
														placeholder="请输入案件名称" class="form-control input-sm inline">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="typelawcase">
													<span style="color: red">*</span> 案件类别：
												</label>
												<div class="col-sm-6">
													<select id="utypeCode" name="typeCode" data-size="10"
														class="col-sm-12 selectpicker padding-zero"
														data-live-search="true" style="width: 30%;">
													</select>
												</div>
											</div>


										</div>
									</div>
									<div class="modal-footer text-right">
										<button class="btn btn-success" type="submit">确认</button>
										<button class="btn btn-info" type="button"
											data-dismiss="modal">取消</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	</div>
		<div class="fr content-r" style="">
			<div>
				<div class="panel panel-default panel-casedetailinfo" style="border:0;" id="case-detail-infos">
					<div class="panel-heading title-info">
						案件详细信息
					</div>
					<div class="panel-body" id="case-detail-infos-body">
					</div>
				</div>
				
	
				<div class="panel panel-default panel-caseclue" style="border:0;margin-bottom:10px;">
	
					<div class="panel-heading title-info">
						案件相关线索
					</div>
					<div class="panel-body docs-pictures" style="height:495px;overflow-y:auto;" id="case-detail-clue-body">
					</div>
				</div>
				<a id="loadMoreClue" href="javascript:;" class="check-more">查看更多>></a>
			</div>
		</div>
	<div class="clear"></div>
	</div>
</body>

<script type="text/javascript">
$(function(){
	changeMenuColor("index");
	$('.chosen-select').chosen({allow_single_deselect: true});
	var winWidth = 0; 
	function findDimensions() //函数：获取尺寸 
	{ 
	//获取窗口高度 
	if (window.innerWidth) 
	winWidth = window.innerWidth; 
	else if ((document.body) && (document.body.clientWidth)) 
	winWidth = document.body.clientWidth; 
	//通过深入Document内部对body进行检测，获取窗口大小 
	if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) 
	{ 
	winWidth = document.documentElement.clientWidth; 
	} 
	}
	findDimensions();
	var content_l_width=winWidth-$(".content-r").width()-30;
	$(".content-l").width(content_l_width);
});

function logOut(){
	layer.confirm('确定要注销？',{
	      offset : ['40%' , '40%'],
		  title:'提示',
		  btn: ['确定','取消'] //按钮
		}, function(){
			window.location.href="${basePath}rest/user/logout";
		}, function(){
			layer.close();
		});
}

function modifyPassword(){
	layer.open({
	    type: 2,
	    title: '修改密码',
	    shadeClose: true,
	    shade: 0.1,//遮罩背景效果
	    area: ['55%', '40%'],
	    shift:0,//动画效果 有0~6选
	    content: '${basePath}rest/user/changePwd'
	});
}
function playVideo(url){
	layer.open({
		type : 2,
		title : '播放视频',
		shadeClose : true,
		shade : 0.1,
		area : [ '800px', '630px' ],
		content : '${basePath}rest/playVideoOcx?videoUrl='+url
		//content : '${basePath}rest/playVideo?videoUrl='+url
	});
}

//案件类别选择
function choose() {
	layer.open({
		type : 2,
		title : '选择案件类别',
		shadeClose : true,
		shade : 0.1,
		area : [ '800px', '90%' ],
		content : '${basePath}rest/lawCase/toCategoryChoose'
	});
}

function toCaseDetail(lawcaseId){
	window.open('${basePath}rest/lawCaseIndex/toCaseDetail?lawCaseId='+lawcaseId+'&parentUrl=lawCase/caseresult&parentName='+encodeURI("案件库"));
}

//通过该方法与后台交互，确保推送时能找到指定用户
function onPageLoad() {
    var userId = $("#userId").val();
    pushMsg.onPageLoad(userId);

}
</script>
<script src="${basePath}views/common/case.js" type="text/javascript"></script>
</html>