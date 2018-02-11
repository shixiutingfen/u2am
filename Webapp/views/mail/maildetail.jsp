<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ include file="/views/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>${systemNameView}-通知</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<base href="${basePath}" id="basePath">
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link href="${basePath}static/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="${basePath}static/easyui/themes/icon.css" rel="stylesheet">
<%@ include file="/views/common/resources.jsp"%>
</head>
<body>
<%@ include file="/views/common/head.jsp"%>

	<%-- <div class="notice-box">
		<div class="cs-retcrumb">
			<span class="glyphicon glyphicon-home"></span> <a href="${basePath}rest/mail/mailList">通知列表</a> <span>/</span>
			<a class="active">通知详情</a>
		</div>
	</div> --%>
<div class="container-fluid">
	<div class="cs_wrapper">
		<div class="cs_container">
			<div class=""
				style="border: 1px solid #CCCACA;">
				<div style="background: #F1F1F1; border-bottom: 1px solid #C1BEBE;">
					<p style="margin-left: 10px; font-size: 20px;">${mailInfoObj.mailTitle}</p>
					<p style="margin-left: 10px;">发信人:&nbsp;${mailInfoObj.senderName}</p>
					<p style="margin-left: 10px;">时间:&nbsp;${mailInfoObj.sendTime}</p>
					<p style="margin-left: 10px;">收信人:&nbsp;${mailInfoObj.recieverName}</p>
				</div>
				<div style=" padding-left: 10px; padding-bottom: 20px; word-break: break-all; word-wrap: break-word; padding-right: 10px; padding-top: 10px;" id="mailBody">${mailInfoObj.mailBody}</div>
			</div>
		</div>
	</div>
  </div>
  <script type="text/javascript">
  //$("#mailBody").find("a").removeAttr('href');
  </script>
</body>
</html>
