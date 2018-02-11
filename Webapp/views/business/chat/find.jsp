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
  <div class="find-body">
        <div class="find-nav"  id="myTabs">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#person" aria-controls="home" role="tab" data-toggle="tab">找人</a></li>
                <li role="presentation"><a href="#group">找群</a></li>
            </ul>
            <div class="tab-content">
                <div class="search-panel tab-pane active" id="person">
                    <div class="snapshot_search_bar">
                        <div class="input-group">
                            <input class="form-control" type="text" name="keyword" placeholder="请输入名称">
                            <div class="input-group-btn">
                                <button class="btn"><span class="search_img"></span></button>
                            </div>
                        </div>
                    </div>
                    <div class="search-condition">
                        <div class="fl"><a class="left-arrow" href="#"><i></i>返回</a></div>
                        <div class="search-info"><span>搜索：</span><span class="search-text">90</span></div>
                    </div>
                    <div class="search-list row">
                        <div class="col-md-3 col-sm-3 col-xs-3">
                            <div class="user-list">
                                <div class="layim-chat-other">
                                    <a href="javascript:;"><img src="http://192.168.0.115:8081/u2vd/static/images/chat/head.jpg"></a>
                                    <a href="javascript:;">石秀亭</a>
                                    <p class="user-infomation">
                                        <span>25岁</span><span>湖南 长沙</span>
                                    </p>
                                    <p>
                                        <button type="button" class="btn btn-primary"><i class="add_user"></i>添加</button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="search-panel tab-pane" id="group">
                    <div class="snapshot_search_bar">
                        <div class="input-group">
                            <input class="form-control" type="text" name="keyword" placeholder="请输入群名称">
                            <div class="input-group-btn">
                                <button class="btn"><span class="search_img"></span></button>
                                <button class="btn primary" onclick="toAddGroup()">新建</button>
                            </div>
                        </div>
                    </div>
                    <div class="search-condition">
                        <div class="fl"><a class="left-arrow" href="#"><i></i>返回</a></div>
                        <div class="search-info"><span>搜索：</span><span class="search-text">石秀亭</span></div>
                    </div>
                    <div class="search-list row">
                        <div class="col-md-3 col-sm-3 col-xs-3">
                            <div class="user-list">
                                <div class="layim-chat-other">
                                    <a href="javascript:;"><img src="http://192.168.0.115:8081/u2vd/static/images/chat/head.jpg"></a>
                                    <a href="javascript:;">90长沙</a>
                                    <p class="user-infomation">
                                        <span>同事</span><span>湖南 长沙</span>
                                    </p>
                                    <p>
                                        <button type="button" class="btn btn-primary"><i class="add_user"></i>添加</button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
$('#myTabs a').click(function (e) {
    e.preventDefault();
    $(this).tab('show')
});

function toAddGroup(){
	location.href="<%=basePath%>rest/chat/toAddGroup";
}
</script>
</html>