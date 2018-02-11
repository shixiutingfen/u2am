<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.jiuling.core.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
   String sysName =  PropertiesUtil.getAppContext("sysName");
   //sysName = new String(sysName.getBytes("ISO-8859-1"),"UTF-8");
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/bootstrap/bootstrap.min.css">
<script src="<%=basePath%>static/js/common/jquery/jquery-1.11.0.min.js"></script>
<script src="<%=basePath%>static/js/common/bootstrap/bootstrap.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="<%=basePath%>static/js/ltIE9/html5shiv.js"></script>
 <script src="<%=basePath%>static/js/ltIE9/respond.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common/base.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/bootstrap/chosen.css" />
<script src="<%=basePath%>static/js/common/bootstrap/chosen.jquery.js"></script>
<script src="<%=basePath%>static/js/common/jquery.migrate.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/common/jquery/jqueryvalidate/jquery.form.js"></script>
<script src="<%=basePath%>static/js/common/jquery/jqueryvalidate/jquery.migrate.js"></script>
<script src="<%=basePath%>static/js/common/jquery/jqueryvalidate/jquery.validate.js"></script>
<script src="<%=basePath%>static/js/common/jquery/jqueryvalidate/additional-methods.js"></script>
<script src="<%=basePath%>static/js/common/layer/layer.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/common/jqGrid/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/common/jqGrid/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/common/plupload-2.1.2/plupload.full.min.js" type="text/javascript"></script>
<script src="<%=basePath%>static/js/common/plupload-2.1.2/zh_CN.js" type="text/javascript"></script>