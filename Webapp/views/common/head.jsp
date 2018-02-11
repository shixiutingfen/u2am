<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title></title>
	<link rel="icon" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon"/>
	<link rel="bookmark" href="<%=basePath%>static/images/favicon.ico" type="image/x-icon"/>

</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">素材平台</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="<%=basePath%>rest/task/listtasks">任务管理 </a></li>
        <li><a href="#">数据管理</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a style="color:red">欢迎您，${userInfo.realName }</a></li>
        <li><a href="javascript:logOut()">注销</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统管理 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=basePath%>rest/user/sysUserMgr">用户管理</a></li>
            <li><a href="<%=basePath%>rest/role/sysRoleMgr">角色管理</a></li>
            <li><a href="<%=basePath%>rest/module/listModules">菜单管理</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
<script type="text/javascript">
function logOut(){
	layer.confirm('确定要注销？',{
      offset : ['40%' , '40%'],
	  title:'提示',
	  btn: ['确定','取消'] //按钮
	}, function(){
		window.location.href="<%=basePath%>rest/user/logout";
	}, function(){
		layer.close();
	});
}
</script>
</html>