package com.jiuling.web.constants;

/**
 * 任务请求路径常量定义
 */
public class TaskConstants {
	
	/**
     * 任务页面
     */
	public static final String VSD_TASK_LIST = "vsdtaskList";
    
    
    /**
     * jqgrid查询带分页
     */
    public static final String GET_TASK_LIST = "/getTaskList";
    
    /**
	 * 添加结构化任务
	 */
    public static final String ADD_VSD_TASK = "/addVSDTask";

    /**
     * 查询结构化任务列表
     */
    public static final String GET_VSD_TASK_LIST = "/getVSDTaskList";
    
    /**
     * 查询结构化任务详细信息
     */
    public static final String GET_VSD_TASK_DETAIL = "/getVSDTaskDetail";
    
    
    /**
     * 删除结构化任务
     */
    public static final String DELETE_VSD_TASK = "/deleteVSDTask";
    
    /**
     * 获取任务的信息
     */
    public static final String GET_TASK_DATA = "/getTaskData";
    
    /**
     * 资源状态查询
     */
    public static final String GET_VSD_RES_STATUS = "/getVSDResStatus";
    
    /**
     * 删除结构化任务
     */
    public static final String TASK_MANAGE = "/taskManage";
    

    /**
     * 目标结构化列表
     */
    public static final String OBJECT_TASK_LIST = "objectTaskList";
    
    /**
     * 分析任务状态 1、待提交 2、正在分析 3、已完成 4、分析失败
     */
    public static final Integer TASK_STATUS_WAIT_SUBMIT = 1;
    /**
     * 分析任务状态 1、待提交 2、正在分析 3、已完成 4、分析失败
     */
    public static final Integer TASK_STATUS_UNDER_ANLYSIS = 2;
    /**
     * 分析任务状态 1、待提交 2、正在分析 3、已完成 4、分析失败
     */
    public static final Integer TASK_STATUS_FINISH_ANLYSIS = 3;
    /**
     * 分析任务状态 1、待提交 2、正在分析 3、已完成 4、分析失败
     */
    public static final Integer TASK_STATUS_FAIL_ANLYSIS = 4;
    
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图
     */
    public static final Integer TARGET_TYPE_HUMAN = 1;
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图
     */
    public static final Integer TARGET_TYPE_CAR = 2;
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图 ,7、深度学习算法
     */
    public static final Integer TARGET_TYPE_CAR_HUMEN = 3;
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图
     */
    public static final Integer TARGET_TYPE_BIKE = 4;
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图
     */
    public static final Integer TARGET_TYPE_PICTURE = 5;
    
    /**
     * 分析任务类型 1、人  2、车  3、物  4、人骑车 5、以图搜图 ,7、深度学习算法
     */
    public static final Integer TARGET_TYPE_ALL = 7;
    
}
