package com.jiuling.web.constants;

/**
 * 图帧融合webservice接口名称常量定义
 * 
 * @author Administrator
 *
 */
public class WebserviceConstant {
	/**
	 * 请求成功标识
	 */
	public static final String SUCCUSS_REQUEST_CODE="0";
    /**
     * 添加视频转码 http://slave_ip/addtranscodetask.php
     */
    public static final String ADD_TRANSCODE_TASK = "/addtranscodetask.php";

    /**
     * 视频摘要/检索提交任务 http://master_ip/submitTask.php <?xmlversion="1.0"encoding="UTF-8"?> <result> <code>0</code> //0：代表成功，-1：磁盘空间不足 其它异常编码待定
     * <flowNumber>77</flowNumber> //成功时 返回唯一ID标示这个任务， <msg></msg> //成功时该信息可为空，当有其他异常时存放异常详细信息 </result>
     */
    public static final String SUBMIT_TASK = "/submitTask.php";
    
    /**
     * 检索人车  检索提交任务 http://master_ip/submitTask.php <?xmlversion="1.0"encoding="UTF-8"?> <result> <code>0</code> //0：代表成功，-1：磁盘空间不足 其它异常编码待定
     * <flowNumber>77</flowNumber> //成功时 返回唯一ID标示这个任务， <msg></msg> //成功时该信息可为空，当有其他异常时存放异常详细信息 </result>
     */
    public static final String SUBMIT_TASKEX = "/submitTaskEx.php";

    /**
     * 查询转码视频状态 http://slave_ip/querytranscodestatus.php?UserUploadVideoId=1
     */
    public static final String QUERY_TRANSCODE_STATUS = "/querytranscodestatus.php";

    /**
     * 图像去抖动  图像去雾 夜间增强 任务提交
     * http://serverip/master/SubmitEnhanceTask.php
     */
    public static final String SUBMIT_ENHANCE_TASK = "/master/SubmitEnhanceTask.php";
    
    /**
     * 查询接口 http://192.168.0.139/server.php?command=QueryEnhance_slave&genhanceid=1
     * 
     * http://serverip/master/QueryEnhanceTaskInfo.php?genhanceid=3
     */
    public static final String QUERY_ENHANCE_TASKINFO = "/server.php";
    
    /**
     * http://serverip/ImageAceTools.php?inputfile=aaa.png
     */
    public static final String IMAGE_ACE_TOOLS = "/ImageAceTools.php";
    
    /**
     * 视频处理任务状态查询 http://slave_ip/query_ex.php?flowNumber =114 <?xml version="1.0" encoding="UTF-8"?> <result> <ret>0</ret> <str_desc>succ</str_desc>
     * <status>7</status> <description>analysis succ</description> <useruploadvideoid>93</useruploadvideoid> <process>100.0</process>
     * <summaryurl>\result\117_20160704115529.avi</summaryurl> <daturl>\result\117_20160704115529.dat</daturl>
     * <summarypath>D:\VideoInvestigation\VIServer\DAT\AstVS_1v2\result\117_20160704115529.avi</summarypath> </result>
     */
    public static final String QUERY_TASK_STATUS = "/query_ex.php";

    /**
     * 删除视频&分析任务 type : 0 分析任务 1 视频 id: flowNmber 192.168.0.123_98 http://slave_ip/delete.php?type=0&id=192.168.0.123_98
     */
    public static final String DELETE_TASK = "/delete.php";
    
    /**
     * 查询快照信息 http://slave_ip/getsnapshot.php
     * id  	要查询任务的流水号(即flowNumber)
	 * type	快照类型，tube为全快照，obj为目标快照
     */
    public static final String QUERY_SNAPSHOT = "/getsnapshot.php";
    
    
    public static final String QUERY_TRACE_SNAPSHOT = "/BSGetSnapshot.php";
    
    /***        侦查平台对接研判接口列表         **/
    /**
     * 监控点同步接口常量
     */
    public static final String SYN_CAMERA = "/cs2vj/rest/webservice/synCamera";
    
    /**
     * 案件关联同步接口常量
     */
    public static final String SYN_LAWCASE_ALL = "/cs2vj/rest/webservice/synLawCaseAll";
    
    /**
     * 案件同步接口常量
     */
    public static final String SYN_LAWCASE = "/cs2vj/rest/webservice/synLawCase";
    
    /**
     * 从研判拉取案件信息
     */
    public static final String GET_LAWCASEINFO = "/cs2vj/rest/webservice/getLawcaseInfo";
    
    /**
     * 案件视频同步接口常量
     */
    public static final String SYN_LAWCASE_MEDIAS = "/cs2vj/rest/webservice/synLawCaseMedias";
    
    /**
     * 案件分析结果同步接口常量
     */
    public static final String SYN_LAWCASE_OBJ_RESULTS = "/cs2vj/rest/webservice/synLawCaseObjResults";
    
    /**
     * 上传文件的接口
     */
	public static final String UPLOADFILE = "/cs2vj/rest/webservice/upLoadFile";
	
	
	/**
	 * 获取从服务器IP  http://x.x.x.x/master/QueryUploadVideoSlaveIP.php?station=0
	 */
	public static final String QUERY_UPLOADVIDEO_SLAVEIP = "/master/QueryUploadVideoSlaveIP.php";
	
	/**
	 *  向管理服务器插入一条视频上传数据，等待分发 http://x.x.x.x/master/addvideo.php?video_filename=&slaveip=
	 */
	public static final String ADDVIDEO = "/master/addvideo.php";
	
	/**
	 *  用管理服务器视频id查询分析服务器产生的转码视频id   http://x.x.x.x/master/queryUserUploadVideoId.php?videoid=x&slaveip=
	 */
	public static final String QUERY_USER_UPLOADVIDEOID = "/master/queryUserUploadVideoId.php";
	
	/**
	 *  查询转码状态（必须得到转码进度为100%，此视频方可提供分析和播放），（分析服务器）   http://x.x.x.x/querytranscodestatus.php?UserUploadVideoId=x&slaveip=
	 */
	public static final String QUERY_TRANSCODESTATUS = "/querytranscodestatus.php";
	/**
	 * 查询历史视频是否存在
	 */
	public static final String QUERY_ISEXISTCAMERAHIRTORY="/jni2vd/rest/jni/getVideoRecordFromID";
 
}
