<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>${systemNameView}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%@ include file="/views/common/taglib.jsp"%>
<style>
	.modular_task_common ul li a{height:32px;text-decoration:none;font-size:14px;}
  	.modular_task_common ul li a:hover{text-decoration:none;}
  	.modular_task_common ul.nav{margin-top: -9px; margin-left: 56px; height: 16px;border-bottom:0;}
  	.modal-content-1 {
	  position: relative;
	  background-color: #fff;
	  -webkit-background-clip: padding-box;
	          background-clip: padding-box;
	  border-radius: 6px;
	  outline: 0;
	}
	.file-content {
		margin-bottom: 20px;
		width: 980px;
		height: 480px;
		overflow: hidden;
		overflow-y: auto;
	}

	.file-box {
		float: left;
		height: 200px;
		width: 200px;
		margin: 20px;
		border: 1px solid #ccc;
		padding: 3px;
		position: relative;
	}
	.file-box>.file-succese-default{
		position: absolute;
		left: 0px;
		top: 0px;
		width: 20px;
		height: 20px;
		background: url("<%=basePath%>static/images/succese_default.png") center no-repeat;
	}
	.file-box>.file-succese{
		position: absolute;
		left: 0px;
		top: 0px;
		width: 20px;
		height: 20px;
		background: url("<%=basePath%>static/images/succese.png") center no-repeat;
	}
	.file-box>.file-faild{
		position: absolute;
		left: 0px;
		top: 0px;
		width: 20px;
		height: 20px;
		background: url("<%=basePath%>static/images/upload_faild.png") center no-repeat;
	}

	.fileImg {
		width: 100%;
		height: 150px;
		background: #f1f1f1;
	}

	.fileImg>a {
		background: url("<%=basePath%>static/images/play.png") center no-repeat;
	}

	.file-box .progress-bar {
		line-height: 10px;
	}

	.icon-table-delete {
		width: 20px;
		height: 20px;
		display: inline-block;
		background: url("<%=basePath%>static/css/images/img/delete.png") 0px
			center no-repeat;
	}
</style>
</head>
<body>
	<div class="modular-box modular_task_common">
        <div class="tab-content">
			<div class="tab-pane active " id="tab2" align="center">
					<div class="form-group fl" style="padding-left: 40px;margin-top: 20px;">
						<label>* 请输入任务类型：</label> 
						<input type="radio" value="1" name="type"/>标注素材<input type="radio" value="2" name="type"/>以图搜图素材
					</div>
					<div class="form-group fl" style="padding-left: 40px;margin-top: 20px;">
						<label>* 请输入任务名称：</label> 
						<input type="text" name="taskName" id="taskName"/>
					</div>
					<div class="file-content"></div>
					<div class="modal-content-1" style="width: 90%;margin-top: 20px;margin-bottom: 220px;">
						<div id="myTabContent" class="tab-content" style="padding: 20px;width:100%;border:none;">
							<button class="btn btn-primary" id="society_import_video">浏览上传</button>
							<button class="btn btn-default" id="uploadBtn">上传</button>
						</div>
					</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			var mediaCacheArr = [];
			var uploader = null;
			var curindex;
			jQuery(function($) {
				
				var isIE8 = (/MSIE\s8\.0/).test(navigator.userAgent);
				var uploaderUrl ='<%=basePath%>rest/task/submitFile';
				
				$("#close").bind("click", function() {
					parent.layer.close(index);
				});
				var params = {};
				uploader = new plupload.Uploader(
						{ //实例化一个plupload上传对象
							browse_button : 'society_import_video',
							url : uploaderUrl,
							flash_swf_url : '<%=basePath%>static/js/plupload-2.1.2/Moxie.swf',
							silverlight_xap_url : '<%=basePath%>static/js/plupload-2.1.2/Moxie.xap',
							multi_selection : true,
							multipart : true,
							multipart_params:params,
						});
				uploader.init(); //初始化

				//绑定文件添加进队列事件
				uploader.bind('FilesAdded',
					function(uploader, files) {
						for (var i = 0, len = files.length; i < len; i++) {
							var file_name = files[i].name; //文件名
							var suffix = file_name.substring(file_name.lastIndexOf(".")+1);
                            var fileHtml = "";
                            var boxId = "box_" + files[i].id;
                            fileHtml += '<div class="file-box" id="'+boxId+'">';
                            fileHtml += ' <div class="file-succese-default" id="state_'+files[i].id+'" ></div>';
                            fileHtml += '   <div class="fileImg">';
                            fileHtml += '       <a style="display: block;width:100%;height:100%;line-height:160px;"></a>';
                            fileHtml += '   </div>';
                            fileHtml += '   <div class="progress" id="progress-'+files[i].id+'" style="margin-bottom:10px;height:10px;">';
                            fileHtml += '     <div class="progress-bar"  role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">';
                            fileHtml += '       0%';
                            fileHtml += '     </div>';
                            fileHtml += '   </div>';
                            fileHtml += '   <div>';
                            var oriName = file_name;
                            if (file_name.length > 10) {
                                file_name = file_name.substring(0,10)+ "...";
                            }
                            fileHtml += '       <span title="'+oriName+'">'+ file_name + '</span>';
                            fileHtml += '       <button class="btn btn-default" onclick="removeFile('+ "'"+ oriName
                                    + "',"+ "'"+ boxId+ "'"+ ')" id="dlt_'+ files[i].id+ '" type="button" style="padding:0px;border:none;float:right;">';
                            fileHtml += '           <i class="icon-table-delete"></i>';
                            fileHtml += '       </button>';
                            fileHtml += '   </div>';
                            fileHtml += '</div>';
                            $(fileHtml).appendTo('.file-content');
						}
				});

				//绑定文件上传进度事件
				uploader.bind('UploadProgress', function(uploader, file) {
					$('#progress-' + file.id).show();
					$('#progress-' + file.id + " .progress-bar").text(
							file.percent + '%');
					$('#progress-' + file.id + " .progress-bar").css('width',
							file.percent + '%');//控制进度条

				});
				uploader.bind('UploadComplete', function(uploader, files) {
					layer.msg('上传完成.',{
	        			icon : 1,
	    				time : 1500
	  				}, function(){
	  					
	  					layer.close(curindex);
	  					parent.layer.closeAll();
	  				}, function(){
	  					layer.close();
	  					layer.close(curindex);
	  				});
				});
				var uploadFileIds="";
				uploader.bind('FileUploaded',function(up, file, responseObject) { //绑定上传完成时的事件，上传失败不触发该事件
					var data = eval("("+ responseObject.response + ")");
					var divId = "state_"+file.id;
					if (data.state) {
						uploadFileIds += data.fileId + ",";
						$("#"+divId).removeClass("file-succese-default").addClass("file-succese");
					}else{
						$("#"+divId).removeClass("file-succese-default").addClass("file-faild");
					}
				});

				uploader.bind('Error', function(up, err) { //绑定文件上传的错误，包括选择文件时的错误
					layer.alert(err.message, {
						title : '提示',
						btn : [ '确定' ]
					//按钮
					}, function() {
						parent.layer.close(index);
					}, function() {
						layer.close();
					});
					layer.close(curindex);
				});
				$("#uploadBtn").click(function(){
					
					params.type = $("input[name='type']:checked").val();
					params.taskName = $("#taskName").val();
					var len = $(".file-content .file-box").length;
					if (len == 0) {
						layer.msg('请选择需要上传的文件');
						return;
					}
					curindex = layer.load(1, {shade: [0.1,'#fff'] });
					uploader.start(); //开始上传
				});
			});
			function removeFile(oriName, boxId) {
				uploader.removeFile(oriName);
				$("#" + boxId).remove();
			}
			
		</script>
	<script type="text/javascript">
	var basePath = '<%=basePath%>';
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	
	$(function(){
		
	});
	
	</script>
</body>
</html>