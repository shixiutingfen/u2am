(function($) {
    $.timeUtils = function(){};
	 $.extend($.timeUtils, {
		  /**
		   * 获取时长
		   * timeLong 以秒为单位的时间长度（正整数）
		   */
        getTimeLong : function(timeLong){
            var zero = '0';
	   	   var result = '00:00:00';
	   	   var seconds,minute,hour;
	   	 
		      if(timeLong && timeLong > 0){
		    	    minute = this.getFloorBySixty(timeLong);
		    	    seconds = this.getTimeStyle(timeLong%60);
		    	    if(minute > 0){
		    		    hour = this.getTimeStyle(this.getFloorBySixty(minute));
		    		    minute = this.getTimeStyle(minute%60);
		    		    result = hour + ':' + minute +':' + seconds;
		    	    }else{
		    		    result = '00:00:' + seconds;
		    	     }
		        }
		    
		      return result;
	     },
    
         //取整除60
      getFloorBySixty : function(data){
  	       var result = 0;
      	 if(data > 0){
      		  result = Math.floor(data/60);
      	      }
      	
      	 return result;
        },
        
        //返回时间格式
      getTimeStyle : function(data){
        	 if(data < 10){
        	 	  data = '0' + data;
         	 }
        	 return data;
        },
        
        /**
         * 将毫秒数转为正规的日期格式
       * time 要设置的日期和时间据 GMT 时间 1970 年 1 月 1 日午夜之间的毫秒数
         */
      getDateByTime : function(time){
    	    if(!time){
    	        return '';	 
    	     }
    	    var date = new Date();
    	    date.setTime(time);
    	    
    	    var month = this.getDoubleDigit(date.getMonth()), days = this.getDoubleDigit(date.getDate() - 1), hours = this.getDoubleDigit(date.getHours() - 1),
    	        minutes = this.getDoubleDigit(date.getMinutes() - 1), seconds = this.getDoubleDigit(date.getSeconds() - 1);
    	    
    	    return date.getFullYear() + '-' + month + '-' + days + ' ' + hours + ':' + minutes + ':' + seconds;
        },
        
        //获取两位数的时间格式
      getDoubleDigit : function(data){
    	   data++;
        	if(data < 10){
        		data = '0' + data;
        	}
        	 
        	return data;
        }
    });

	 Date.prototype.format=function(fmt) {           
		    var o = {           
		    "M+" : this.getMonth()+1, //月份           
		    "d+" : this.getDate(), //日           
		    "h+" : this.getHours()%24 == 0 ? 24 : this.getHours()%24, //小时           
		    "H+" : this.getHours(), //小时           
		    "m+" : this.getMinutes(), //分           
		    "s+" : this.getSeconds(), //秒           
		    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
		    "S" : this.getMilliseconds() //毫秒           
		    };           
		    var week = {           
		    "0" : "/u65e5",           
		    "1" : "/u4e00",           
		    "2" : "/u4e8c",           
		    "3" : "/u4e09",           
		    "4" : "/u56db",           
		    "5" : "/u4e94",           
		    "6" : "/u516d"          
		    };           
		    if(/(y+)/.test(fmt)){           
		        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
		    }           
		    if(/(E+)/.test(fmt)){           
		        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
		    }           
		    for(var k in o){           
		        if(new RegExp("("+ k +")").test(fmt)){           
		            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
		        }           
		    }           
		    return fmt;           
		} 
})(jQuery); 