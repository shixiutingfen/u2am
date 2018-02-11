<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${systemNameView}</title>
	<link rel="icon" href="${basePath}static/images/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="${basePath}static/images/favicon.ico" type="image/x-icon"/>
	<link rel="bookmark" href="${basePath}static/images/favicon.ico" type="image/x-icon"/>
	  <%@ include file="/views/common/taglib.jsp"%>
      <%@ include file="/views/common/resources2.jsp"%>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>static/js/layim3.0.1/layui/css/layui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common/main.css">
    <script src="${basePath}static/js/layim3.0.1/layui/layui.js" type="text/javascript"></script>
      <link rel="stylesheet" type="text/css" href="<%=basePath%>static/js/layim3.0.1/layui/css/information.css">
       <link rel="stylesheet" type="text/css" href="<%=basePath%>static/js/layim3.0.1/layui/css/intelligentApplication.css">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
   <link href="<%=basePath%>static/js/common/jquery-pagination/pagination.css" rel="stylesheet" type="text/css">
   <script src="<%=basePath%>static/js/common/jquery-pagination/jquery.pagination.js" type="text/javascript"></script>
</head>
<body >
 <div class="creatgroup-w">
    <div class="creat-step-w">
        <div class="creat-step active" id="groupNameActiveDiv">
            <span class="fl ">1</span>
            	填写群信息
            <i class="fr"></i>
        </div>
        <div class="creat-step" id="addFriendsActiveDiv">
            <span class="fl">2</span>
           	 邀请群成员
        </div>
    </div>
    <div class="creat-infomation">
        <div class="creat-group-com creat-groupinfo"  id="groupNameDiv">
            <!--群信息-->
             <div class="form-group">
                 <label class=""><span style="color:red">*</span>群名称:</label>
                 <div>
                    <input type="text" class="form-control" placeholder="请输入群名称" id="groupName" name="groupName">
                 </div>
             </div>
             <div class="form-group">
                 <label class="">群描述:</label>
                 <div>
                     <input type="text" class="form-control" placeholder="请输入群名称" id="groupDesc" name="groupDesc">
                 </div>
             </div>
            <div class="step-bottom">
                <button type="button" class="btn btn-default fr step_next" onclick="toStepTwo()">下一步</button>
                <!-- <button type="button"  class="btn btn-default fr step_prev" onclick="backToFind()">返回</button> -->
            </div>
        </div>
        <div class="creat-group-com creat-groupmember" style="display: none;" id="addFriendsDiv">
            <!--选择群成员-->
            <div >
                <div class="snapshot_search_bar">
                    <div class="input-group">
                        <input class="form-control" type="text" name="keyword" style="height:34px;" placeholder="请输入查找关键字">
                        <div class="input-group-btn">
                            <button class="btn"><span class="search_img"></span></button>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-6 user-list">
                        <div class="group-list-top">
                          	  用户列表:
                        </div>
                        <div class="group-list-con">
                            <ul id="user_list" class="able-user-list">
                             
                            </ul>
                              <div class="page-bottom" >
						    	<div class="pagination" id="pagination" ></div>
						    </div>
                        </div>
                    </div>
                    <!-- <div class="col-md-2 col-sm-2 col-xs-2 member-operate">
                        <button class="btn btn-default" type="button">添加&gt;</button>
                        <button class="btn btn-default" type="button">&lt;删除</button>
                    </div> -->
                    <div class="col-md-6 col-sm-6 col-xs-6 selected-member">
                        <div class="group-list-top">
                            	已选成员:
                        </div>
                        <div class="group-list-con">
                            <ul id="user_select">
                            	<li userId="${userInfo.userId }">${userInfo.realName }</li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
            <div class="step-bottom">
                <button type="button" class="btn btn-default fr" onclick="finishGroup()">完成创建</button>
                <button type="button" class="btn btn-default fr step_prev" onclick="toStepOne()">上一步</button>

            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
var pageSize=10;
var currentPage=1;
$(function(){
	initUsers(1);
})
function toStepTwo(){
	if(!$("#groupName").val()){
		layer.msg('群组名称不能为空！',{time: 1800});
		return ;
	}
	$("#groupNameDiv").hide();
	$("#addFriendsDiv").show();
	$("#groupNameActiveDiv").removeClass('active');
	$("#addFriendsActiveDiv").addClass('active');
}
function toStepOne(){
	$("#groupNameDiv").show();
	$("#addFriendsDiv").hide();
	$("#groupNameActiveDiv").addClass('active');
	$("#addFriendsActiveDiv").removeClass('active');
}
function backToFind(){
	location.href="<%=basePath%>rest/chat/toFind";
}
//查询所有用户
function initUsers(curp){
	if(curp){
		currentPage = curp;
	}
	//$("#totalCount").val("0");
	$.ajax({
		url:'<%=basePath%>rest/chat/getAllUsers',
		data:{
			page : currentPage,
			rows : pageSize
		},
		type : "POST" , 
		dataType:'json',
		success:function(data){
			//分业初始化
			caseLibPagination(data.records, pageSize);
		},
		failure : function() {
			layer.closeAll('dialog');
			layer.msg('操作超时!');
		}
	});
}

function caseLibPagination(totalCount, pageSize){
	var optInit = {
		items_per_page: pageSize,
		num_display_entries: 10,
		num_edge_entries: 5,
		prev_text: "<<", 
		next_text: ">>",
		callback: pageselectCallback
		};

	$("#pagination").pagination(totalCount, optInit);
}
function pageselectCallback(page_index, jq){
	queryCaseData(page_index + 1);
}

function queryCaseData(curPage){
	currentPage = curPage;
	$.ajax({
		url:'<%=basePath%>rest/chat/getAllUsers',
		data:{
			page : currentPage,
			rows : pageSize,
			id:$("#toId").val()
		},
		type : "POST" , 
		dataType:'json',
		success:function(data){
			if(data.state){
				buildStr(data.rows);
			}
		},
		failure : function() {
			layer.closeAll('loading');
			layer.msg('操作超时!');
		}
	});
}
function buildStr(data){
	var str='';
	$(data).each(function(){
		str+='<li userid="'+this.userId+'" realname="'+this.realName+'" onclick="appendUser(this)"><a>'+this.realName+'</a></li>';
	})
	$("#user_list").empty().append(str);
}
//移动用户到右边
function appendUser(obj){
	var ids = [];
	$("#user_select").find("li").each(function(){
		ids.push($(this).attr("userId"));
	})
	var userId = $(obj).attr("userid");
	if(arrayContain(ids,userId)){
		layer.msg('该用户已经添加到列表中!', {icon : 1,time : 1500});
	}else{
		$("#user_select").prepend(' <li userId="'+userId+'">'+$(obj).attr("realname")+'</li>');
	}
}
function arrayContain(array, obj){
    for (var i = 0; i < array.length; i++){
        if (array[i] == obj)//如果要求数据类型也一致，这里可使用恒等号===
            return true;
    }
    return false;
}
//完成创建
function finishGroup(){
	addGroup();
}
function addGroup(){
	$.ajax({
		url:'<%=basePath%>rest/chat/addGroupBasic',
		data:{
			groupName:$("#groupName").val()
		},
		type : "POST" , 
		dataType:'json',
		success:function(data){
			if(data.state){
				addGroupDetail(data.basicId);
			}
		},
		failure : function() {
			layer.closeAll('dialog');
			layer.msg('操作超时!');
		}
	});
}
function addGroupDetail(basicId){
	var ids = '';
	$("#user_select").find("li").each(function(){
		ids+=$(this).attr("userId")+",";
	})
	$.ajax({
		url:'<%=basePath%>rest/chat/addChatGroupDetail',
		data:{
			ids:ids,
			basicId:basicId
		},
		type : "POST" , 
		dataType:'json',
		success:function(data){
			if(data.state){
				 parent.window.location.reload()
			}
		},
		failure : function() {
			layer.msg('操作超时!');
		}
	});
}
</script>
</html>