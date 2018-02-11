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
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/common/icon.css">
   <link href="<%=basePath%>static/js/common/jquery-pagination/pagination.css" rel="stylesheet" type="text/css">
   <script src="<%=basePath%>static/js/common/jquery-pagination/jquery.pagination.js" type="text/javascript"></script>
   <style type="text/css">
   	.nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus{
   		color:#333;
   	}
   </style>
</head>
<body >
   <input type="hidden" id="toId" value="${id }"/>
   <input id="caseId" type="hidden">
   <input id="taskId" type="hidden">
    <a href="javascript:refleshLog();" class="btn btn-primary"  title="刷新"><span class="glyphicon glyphicon-refresh" title="播放"></span></a>
	<div class="container"  id="myTabs">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home1" aria-controls="home1" role="tab" data-toggle="tab">图片</a></li>
        <li role="presentation"><a href="#home2">文件</a></li>
         <li role="presentation" ><a href="#home" >全部</a></li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane active" id="home1">
       		<div class="information-w" id="imageDiv">
            	
            </div>
           	<div class="page-bottom" >
		    	<div class="pagination" id="paginationPic" ></div>
		    </div>
        </div>
        <div class="tab-pane" id="home2">
            <div class="information-w" id="fileDiv">
            	
            </div>
           	<div class="page-bottom" >
		    	<div class="pagination" id="paginationFile" ></div>
		    </div>
        </div>
        <div class="tab-pane " id="home">
            <div class="information-w" id="messageContentDiv">
            	
            </div>
            <div class="page-bottom" >
		    	<div class="pagination" id="pagination" ></div>
		    </div>
        </div>
    </div>
     
</div>
</body>
<script type="text/javascript">
var pageSize=10;
var currentPage=1;

var pageSize2=10;
var currentPage2=1;

var pageSize3=10;
var currentPage3=1;
$(function(){
    $('#myTabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show')
    });
    initCasePage(1);//文字信息
    initPicPage(1);//图片
    initFilePage(1);//文件
});
function refleshLog(){
	initCasePage(1);//文字信息
    initPicPage(1);//图片
    initFilePage(1);//文件
}
/**
 * 文字begin
 */
function initCasePage(curp){
	if(curp){
		currentPage = curp;
	}
	$.ajax({
		url:'<%=basePath%>rest/chat/getChatMessage',
		data:{
			page : currentPage,
			rows : pageSize,
			id:$("#toId").val(),
			messageType:'0'
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
		url:'<%=basePath%>rest/chat/getChatMessage',
		data:{
			page : currentPage,
			rows : pageSize,
			id:$("#toId").val(),
			messageType:'0'
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
		var messageType = this.messageType;
		str+='<div class="information">';
		str+='<div class="information-info cb fl"><span class="info-user">'+this.userName+'</span>&nbsp;&nbsp;<span>'+this.inputTime+'</span></div>';
		var resourceUrl = '<%=basePath%>rest/getFtpFileStream?path='+this.messageContent;
		if(messageType == 0){
			str+='<div class="information-con cb fl layim-chat-text">'+this.messageContent+'</div>';
		}else if(messageType == 1){
			str+='<div class="information-con cb fl"><img src="'+resourceUrl+'" style="width:100px;height:100px"></img></div>';
		}
		str+='</div>';
	})
	$("#messageContentDiv").empty().append(str);
}
/**
 * 文字end
 */
 
 /**
  * 图片begin
  */
  function initPicPage(curp){
		if(curp){
			currentPage = curp;
		}
		$.ajax({
			url:'<%=basePath%>rest/chat/getChatMessage',
			data:{
				page : currentPage2,
				rows : pageSize2,
				id:$("#toId").val(),
				messageType:'1'
			},
			type : "POST" , 
			dataType:'json',
			success:function(data){
				//分业初始化
				caseLibPagination2(data.records, pageSize);
			},
			failure : function() {
				layer.closeAll('dialog');
				layer.msg('操作超时!');
			}
		});
	}
	function caseLibPagination2(totalCount, pageSize){
		var optInit = {
			items_per_page: pageSize2,
			num_display_entries: 10,
			num_edge_entries: 5,
			prev_text: "<<", 
			next_text: ">>",
			callback: pageselectCallback2
			};

		$("#paginationPic").pagination(totalCount, optInit);
	}
	function pageselectCallback2(page_index, jq){
		queryCaseData2(page_index + 1);
	}

	function queryCaseData2(curPage){
		currentPage = curPage;
		$.ajax({
			url:'<%=basePath%>rest/chat/getChatMessage',
			data:{
				page : currentPage2,
				rows : pageSize2,
				id:$("#toId").val(),
				messageType:'1'
			},
			type : "POST" , 
			dataType:'json',
			success:function(data){
				if(data.state){
					buildStr2(data.rows);
				}
			},
			failure : function() {
				layer.closeAll('loading');
				layer.msg('操作超时!');
			}
		});
	}
	function buildStr2(data){
		var str='';
		$(data).each(function(){
			var messageType = this.messageType;
			str+='<div class="information">';
			str+='<div class="information-info cb fl"><span class="info-user">'+this.userName+'</span>&nbsp;&nbsp;<span>'+this.inputTime+'</span></div>';
			var resourceUrl = '<%=basePath%>rest/getFtpFileStream?path='+this.messageContent+'&playType=chat';
			if(messageType == 0){
				str+='<div class="information-con cb fl layim-chat-text">'+this.messageContent+'</div>';
			}else if(messageType == 1){
				str+='<div class="information-con cb fl"><img src="'+resourceUrl+'" style="width:100px;height:100px"></img>';
				str += '<a onclick="javascript:uploadclue(\''+ this.messageId+ '\')" title="添加线索" style="position:relative;top:2px;"><label class="uploadClue"></label></a>';
				str += '<a onclick="javascript:changeCase(\''+ this.messageId+ '\')" title="案件取证" style="position:relative;top:2px;"><label class="uploadCase"></label></a>';
				str += '<a onclick="javascript:uploadCloud(\''+ this.messageContent+ '\')" title="加入云空间" style="position:relative;top:2px;"><label class="uploadCloud"></label></a>';
				str+='</div>';
			}
			str+='</div>';
		})
		$("#imageDiv").empty().append(str);
	}
  /**
   * 图片end
   */
   
   
   /**
    * 文件begin
    */
    function initFilePage(curp){ 
		if(curp){
			currentPage = curp;
		}
		$.ajax({
			url:'<%=basePath%>rest/chat/getChatMessage',
			data:{
				page : currentPage3,
				rows : pageSize3,
				id:$("#toId").val(),
				messageType:'2'
			},
			type : "POST" , 
			dataType:'json',
			success:function(data){
				//分业初始化
				caseLibPagination3(data.records, pageSize);
			},
			failure : function() {
				layer.closeAll('dialog');
				layer.msg('操作超时!');
			}
		});
	}
	function caseLibPagination3(totalCount, pageSize){
		var optInit = {
			items_per_page: pageSize2,
			num_display_entries: 10,
			num_edge_entries: 5,
			prev_text: "<<", 
			next_text: ">>",
			callback: pageselectCallback3
			};

		$("#paginationFile").pagination(totalCount, optInit);
	}
	function pageselectCallback3(page_index, jq){
		queryCaseData3(page_index + 1);
	}

	function queryCaseData3(curPage){
		currentPage = curPage;
		$.ajax({
			url:'<%=basePath%>rest/chat/getChatMessage',
			data:{
				page : currentPage3,
				rows : pageSize3,
				id:$("#toId").val(),
				messageType:'2'
			},
			type : "POST" , 
			dataType:'json',
			success:function(data){
				if(data.state){
					buildStr3(data.rows);
				}
			},
			failure : function() {
				layer.closeAll('loading');
				layer.msg('操作超时!');
			}
		});
	}
	function buildStr3(data){
		var str='';
		$(data).each(function(){
			var messageType = this.messageType;
			str+='<div class="information">';
			str+='<div class="information-info cb fl"><span class="info-user">'+this.userName+'</span>&nbsp;&nbsp;<span>'+this.inputTime+'</span></div>';
			var resourceUrl = '<%=basePath%>rest/getFtpFileStream?path='+this.messageContent+'&playType=chat';
			if(messageType == 0){
				str+='<div class="information-con cb fl layim-chat-text">'+this.messageContent+'</div>';
			}else if(messageType == 2){
				str+='<div class="information-con cb fl"><img src="'+resourceUrl+'" style="width:100px;height:100px"></img></div>';
			}
			str+='</div>';
		})
		$("#fileDiv").empty().append(str);
	}
    /**
     * 文件end
     */
     
   //选择上传线索
	function uploadclue(id){
			$.ajax({
				url:  '${basePath}rest/lawCase/saveChatClue',
				data: {
					"lawcaseId" : "",
					"messageId" : id
				},
				method: 'POST',
				dataType: 'JSON',
				success: function(data){
					if (data.state) {
						layer.alert("添加成功，请到线索库中查看");
						}else{
							layer.alert(data.msg);
						}
				}
			});
		}
     	/**
		 * 选择案件
		 */
		function changeCase(taskId){
			parent.layer.open({
				type : 2,
				title : '案件选择',
				shadeClose : true,
				shade : 0.1,// 遮罩背景效果
				area : [ '1080px', '80%' ],
				shift : 0,// 动画效果 有0~6选
				content : '${basePath}rest/cameraMedia/openMycase?fromModule=chat&taskId='+taskId,
				success : function(layero, index) {
					var body = parent.layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
					body.find('#parentIndex').val(index);
					
				}
			});
		}
		
		//保存线索至当前案件
		function saveClue(){
			var lawcaseId = $("#caseId").val();
			var taskId = $("#taskId").val();
			$.ajax({
				url:  '${basePath}rest/lawCase/saveChatClue',
				data: {
					"lawcaseId" : $("#caseId").val(),
					"messageId" : taskId
				},
				method: 'POST',
				dataType: 'JSON',
				success: function(data){
					if (data.state) {
						layer.msg('保存成功!', {
							offset:['30px','600px'],
							icon : 1,
							time : 1500
						});
						}else{
							layer.msg('线索已取证!', {
								offset:['30px','600px'],
								icon : 1,
								time : 1500
							});	
						}
				}
			});
		}
		function uploadCloud(imgurl){
			
			var cloudArrayParam =[];
			cloudArrayParam.push(imgurl);
			$.ajax({
				url:   '${basePath}rest/cloud/save2CloudSpace',
				method: 'POST',
				data: {
					cloudArray : cloudArrayParam.join(),
					lawcaseId : '',
					clueType : "1"  //这里的type代表当前线索类型  1图片 2视频
				},
				dataType: 'JSON',
				success: function(data){
					if(data.state){
						layer.alert('存入云空间成功!');
						upload2FTP(cloudArrayParam);
					}else{
						if(data.errorMsg){
							layer.alert(data.errorMsg);
						}else{
							layer.alert('存入云空间失败!');
						}
					}
					layer.close(index);
				}
			});
		}
		
		//上传云ftp
		function upload2FTP(paramData){
			$.ajax({
				url: '${basePath}rest/cloud/upload2FTP',
				type: 'POST',
				data:{
					cloudArray : paramData.join(),
					lawcaseId : ''
				},
				dataType: 'JSON',
				success: function(data){
				}
			});
		}
</script>
</html>