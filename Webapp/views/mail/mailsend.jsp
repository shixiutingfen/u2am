<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script charset="utf-8" src="${basePath}static/js/common/kindeditor/kindeditor-all-min.js"></script>
		<script charset="utf-8" src="${basePath}static/js/common/kindeditor/lang/zh-CN.js"></script>
<%-- 		<link href="${basePath}static/easyui/themes/bootstrap/easyui.css" rel="stylesheet">
		<link href="${basePath}static/easyui/themes/icon.css" rel="stylesheet"> --%>
		<%@ include file="/views/common/resources.jsp"%>
	</head>
<body>
<%@ include file="/views/common/head.jsp"%>

	<div class="notice-box">
		<div class="cs-retcrumb">
			<span class="glyphicon glyphicon-home"></span> <a href="${basePath}rest/mail/mailList">通知列表</a> <span>/</span>
			<a class="active">新增通知</a>
		</div>
	</div>
<div class="container-fluid">
   <div class="cs_wrapper">
  	  <div class="cs_container">
	   	  	 <form id="addMailForm" class="form-horizontal" method="post">
			    <div class="row">
		        	<div class="form-group">
		            	<label class="col-sm-4 control-label">收件人：</label>
		                <div class="col-sm-8">
		                	<input type="text" name="recieverNames" class="form-control" style="width:650px;" placeholder="请单击选择收件人名称" />
		                	<input type="hidden" name="recieverIds" />
		                </div>
		            </div>
			    </div>
			    <div class="row" style="margin-top: 10px;">
		        	<div class="form-group">
		            	<label class="col-sm-4 control-label">标题：</label>
		                <div class="col-sm-8">
		                	<input type="text" name="mailTitle"  class="form-control" style="width:650px;" placeholder="请输入标题内容" />
		                </div>
		            </div>
			    </div>
			    <div class="row" style="margin-top: 10px;">
		        	<div class="form-group">
		            	<label class="col-sm-4 control-label">内容：</label>
		                <div class="col-sm-8" width="500">
		                	<textarea id="editor_id" name="mailBody" style="height:455px;"></textarea>
		                </div>
		            </div>
			    </div>
			    <div class="clearfix form-actions">
					<div class="col-md-offset-4 col-md-8">
						<button class="btn btn-primary" id="sendBtn" type="button">
							<i class="ace-icon fa fa-envelope bigger-110"></i>
							发送
						</button>
		            	<button type="button" class="btn btn-default" id="backBtn">
		            		<i class="ace-icon fa fa-reply bigger-110"></i>返回
		            	</button>
						
					</div>
				</div>
	   	  	 </form>
	  </div>
   </div>
</div>
</body>

<script>
	KindEditor.ready(function(K) {
	   editor = K.create('textarea[name="mailBody"]', {
	      minWidth: 650,
          items:["source", "|", "undo", "redo", "|", "preview",  "cut", "copy", "paste", "|", "justifyleft", "justifycenter", "justifyright", "justifyfull", "insertorderedlist", "insertunorderedlist", "indent", "outdent", "subscript", "superscript",  "quickformat", "selectall", "|", "fullscreen",  "formatblock", "fontname", "fontsize", "|", "forecolor", "hilitecolor", "bold", "italic", "underline", "strikethrough", "lineheight", "removeformat"] //配置kindeditor编辑器的工具栏菜单项
	   });
	});
	
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	$(function(){
		//绑定用户列表选择事件
		$(".userlist-con input[name=userCheckBox]").click(function(){
			var ids = '', names = '';
			$(".userlist-con input[name=userCheckBox]:checked").each(function(){
				if($(this).attr("attrId")){
					ids += $(this).attr("attrId") + ',';
					names += $(this).attr("attrName") + ',';
				}
			});
			$("input[name=recieverIds]").val(ids);
			$("input[name=recieverNames]").val(names);
		});
		
		//输入框获取焦点事件
		$("input[name=recieverNames]").focus(function(){
			getreciever();
		});
		
		//发送按钮
		$("#sendBtn").click(function(){
			var recieverNames = $("input[name=recieverNames]").val();
			var recieverIds = $("input[name=recieverIds]").val();
			var mailTitle = $("input[name=mailTitle]").val();
			var mailBody = editor.html();
			if(!$.trim(recieverNames)){
				layer.alert('收件人必填!',{
				  title:'提示',
				  btn: ['确定'] //按钮
				}, function(){
					$(".layui-layer-close").trigger('click');
				}, function(){
					layer.close();
				});
				return;
			}
			if(!$.trim(mailTitle)){
				layer.alert('标题必填!',{
				  title:'提示',
				  btn: ['确定'] //按钮
				}, function(){
					$(".layui-layer-close").trigger('click');
				}, function(){
					layer.close();
				});
				return;
			}
			if(!$.trim(mailBody)){
				layer.alert('内容必填!',{
				  title:'提示',
				  btn: ['确定'] //按钮
				}, function(){
					$(".layui-layer-close").trigger('click');
				}, function(){
					layer.close();
				});
				return;
			}
			//表单提交验证
			$.ajax({ 
     			url: '${basePath}rest/mail/saveMailInfo',
     	        type: "POST" , 
     	        dataType: 'json',
     	        data: {
     	        	recieverIds: recieverIds,
     	        	mailTitle: mailTitle,
     	        	mailBody: mailBody
     	        },
     	        success : function(data) {
     				if(data.status){
     					layer.alert('发送成功!',{
   						  title:'提示',
   						  btn: ['确定'] //按钮
   						}, function(){
   							$(".layui-layer-close").trigger('click');
   						}, function(){
   							layer.close();
   						});
     					window.location.href = '${basePath}rest/mail/mailList';
     					
     				}else{
     					layer.alert('发送失败!');
     				}
     			},
     			failure : function() {
     				layer.alert('操作超时!');
     			}
     	     });
		});
		
		//返回按钮
		$("#backBtn").click(function(){
			window.location.href = '${basePath}rest/mail/mailList';
		});
		
		$('#userDeptListTree').tree({   
            checkbox: true,   
            url: '${basePath}rest/mail/userDeptListTree/null',   
            onBeforeExpand:function(node, param){  
                $('#userDeptListTree').tree('options').url = '${basePath}rest/mail/userDeptListTree/' + node.id;
            },               
            onClick:function(node){
            },
            onCheck:function(node){
        	    var nodes = $('#userDeptListTree').tree('getChecked');
       			var ids = '', names = '';
       			for(var i=0; i<nodes.length; i++){
       				names += nodes[i].text + ",";
       				ids += nodes[i].id + "|" + nodes[i].userDeptFlag + ",";
       			}
       			$("input[name=recieverIds]").val(ids);
    			$("input[name=recieverNames]").val(names);
            }
       });
	});
	
	function getreciever(){
		layer.open({
		    type: 2,
		    title: '选择收件部门/人',
		    shadeClose: true,
		    shade: 0.1,//遮罩背景效果
		    area: ['55%', '90%'],
		    shift:0,//动画效果 有0~6选
		    content: '${basePath}rest/mail/reciever?timeStamp=' + new Date().getTime(),
		    success: function(layero, index){
		        var body = layer.getChildFrame('body', index);
		        var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
		    }
		});
	}
	
</script>
</html>