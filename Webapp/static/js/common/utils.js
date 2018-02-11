(function ($) {
    $.selectUtil = function () { };
    $.extend($.selectUtil,
	             { 
    				//基本信息下拉框初始化
    	             getOptions:function(divId,selectName,cacheItemId,path)
    	             {
    	            	 var url='';
    	            	 if((path != undefined) && (path != null) && (path != '')){
    	            		 url+=path+ "rest/getSelectOption?cacheItemId=" + cacheItemId+ "&timeStamp=" + new Date().getTime();
    	            	 }else{
    	            		 url+="rest/getSelectOption?cacheItemId=" + cacheItemId+ "&timeStamp=" + new Date().getTime();
    	            	 }
    	            	 $.ajax({
 							url:url,
 							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
 							success:function(data){
								var str='<select id="'+selectName+'" name="'+selectName+'" class="chosen-select form-control"  data-placeholder="请选择.." ><option value="">  </option>';
                                var defaultVal = $("#"+divId).prop("title");
								for(var key in data){
									var value=data[key];

									if (null != defaultVal && "" !== defaultVal && key == defaultVal)
									{
										str+="<option value='"+key+"' selected='selected'>"+value+"</option>";
									}else
									{
										str+="<option value='"+key+"'>"+value+"</option>";
									}
									
								}
                                str+="</select>";
                                $("#"+divId).empty().append(str);
								$('.chosen-select').chosen({allow_single_deselect:true}); 
								
 								
 							},
 							failure:function(){
 								$.messager.alert('提示','操作超时！');
 							}
 						});
    	             },
    	             //结构化字典
    	             getfeatureOptions:function(path,divId,seleid,selectName,featureCodeId,featureVal)
    	             {
    	            	 $.ajax({
 							url:path+"rest/getFetureSelectOption?featureCodeId=" + featureCodeId + "&timeStamp=" + new Date().getTime(),
 							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
 							success:function(data){
								var str='<select id="'+seleid+'" name="'+selectName+'" class="chosen-select form-control"  data-placeholder="请选择.." ><option value="">  </option>';
                                
								for(var key in data){
									var value=data[key];

									if (null != featureVal && "" !== featureVal && key == featureVal)
									{
										str+="<option value='"+key+"' selected='selected'>"+value+"</option>";
									}else
									{
										str+="<option value='"+key+"'>"+value+"</option>";
									}
									
								}
                                str+="</select>";
                                
                                $("#"+divId).empty().append(str);
                                $('#'+seleid).chosen({allow_single_deselect:true, width:"100%"}); 
								
 								
 							},
 							failure:function(){
 								$.messager.alert('提示','操作超时！');
 							}
 						});
    	             }, 
    	           //案件审批状态
    	             formatVerifyingStatus:function(v)
    	             {
    	            	 var status='新建';
    	                 var fmt = {
    	                     1: status,
    	                     2: '待审批',
    	                     3: '审批不通过',
    	                     4: '审批通过',
    	                     5: '退回',
    	                     6: '补录'
    	                 };
    	                 return fmt[v] || '';
    	             }, 
    	             getOptionsByCategoryValue:function(divId,selectName,cacheItemId,path,categoryValue)
    	             {
    	            	 var url='';
    	            	 var requestPrefix='';
    	            	 if(path){
    	            		 requestPrefix=path;
    	            	 }
    	            	 if(categoryValue){
    	            		 url=requestPrefix+'rest/getSelectOptionByCategoryValue?categoryValue='+categoryValue+'&cacheItemId=' + cacheItemId+ '&timeStamp=' + new Date().getTime();
    	            	 }else{
    	            		 url=requestPrefix+'rest/getSelectOption?cacheItemId=' + cacheItemId+ '&timeStamp=' + new Date().getTime();
    	            	 }
    	            	 $.ajax({
 							url:url,
 							contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
 							success:function(data){
								var str='<select id="'+selectName+'" name="'+selectName+'" class="chosen-select form-control"  data-placeholder="请选择.." ><option value="">  </option>';
                                var defaultVal = $("#"+divId).prop("title");
								for(var key in data){
									var value=data[key];

									if (null != defaultVal && "" !== defaultVal && key == defaultVal)
									{
										str+="<option value='"+key+"' selected='selected'>"+value+"</option>";
									}else
									{
										str+="<option value='"+key+"'>"+value+"</option>";
									}
									
								}
                                str+="</select>";
                                $("#"+divId).empty().append(str);
								$('.chosen-select').chosen({allow_single_deselect:true}); 
								
 								
 							},
 							failure:function(){
 								$.messager.alert('提示','操作超时！');
 							}
 						});
    	             }
	             }
    		);

    
    /**
     * 入日志表  basePath项目根路径
     * logtype 日志类型 1菜单 2点位 3视频 4案件 5线索 6上次登录时间
     * moduleUrl:当前功能路径  window.location.href  如果是弹出框则用parent.window.location.href
     * videoid 视频id  clueid线索id  caseid案件id cameraid点位id
     * 根据需要填写参数，不需要的参数用null或空
     */
    $.logUtil = function () { };
    $.extend($.logUtil,{ 
	         addLog:function(basePath,logtype,moduleUrl,videoid,clueid,caseid,cameraid,startTime,endTime){
	        	 $.ajax({
	     			url : basePath + "rest/log/addLog",
	     			type : "POST",
	     			data : {
	     				"moduleName" : moduleUrl,
	     				"cameraId" : cameraid,
	     				"videoId":videoid,
	     				"caseId":caseid,
	     				"clueId":clueid,
	     				"cameraId":cameraid,
	     				"logType":logtype,
	     				"c2":startTime, 
	     				"c3":endTime
	     			},
	     			dataType : 'json',
	     			success : function(data) {
	     				if (data.state) {
	     					if(typeof(initPage)!="undefined"){
	     						initPage(1);
	     					}
	     					//layer.msg('新增成功!', {icon : 1,time : 1500});
	     				} else {
	     					layer.alert(data.msg);
	     				}
	     			},
	     			failure : function() {
	     				layer.alert("新增日志失败");
	     			}

	     		});
	         }
	     }
    );
})(jQuery);

