<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/views/common/taglib.jsp"%>
<title>登录</title>
<link rel="icon" href="/static/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="/static/images/favicon.ico" type="image/x-icon" />
<link rel="bookmark" href="/static/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/bootstrap/bootstrap.min.css">
<script src="<%=basePath%>static/js/common/jquery/jquery-1.11.0.min.js"></script>
<script src="<%=basePath%>static/js/common/bootstrap/bootstrap.js"></script>
<link rel="stylesheet" href="<%=basePath%>static/css/newLogin.css" />

<script type="text/javascript">
    if (navigator.userAgent.toLowerCase().indexOf("chrome") >= 0) {
        $(window).load(function(){
            $('input:-webkit-autofill').each(function(){
                var text = $(this).val();
                var name = $(this).attr('name');
                $(this).after(this.outerHTML).remove();
                $('input[name=' + name + ']').val(text);
            });
        });
    }
</script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" id="contentModel"  action="<%=basePath%>rest/user/login" method="POST" autocomplete="off">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
	<script>
		if (window != top) {
			alert("登陆超时，将返回登陆页面!");
			top.location.href = location.href;
		}
		$(document).ready(function() {
			$("#username").focus();
			hasLogin();
			$('#contentModel').validate({
				focusInvalid : false, // do not focus the last invalid input
				rules : {
					username : {
						required : true
					},
					password : {
						required : true
					}
				},

				messages : {
					username : {
						required : "用户名不能为空."
					},
					password : {
						required : "密码不能为空."
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
			
			$('#password').attr('type','text').focus(function(){
				$(this).attr('type','password');
			});
			
			
		});

		function hasLogin() {
			var error = $("#error").val();
			if ($.trim(error)) {
				layer.alert(error);
				//alert(error);
			}
		}
	</script>


</body>
</html>
