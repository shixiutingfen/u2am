package com.jiuling.web.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量定义
 * @author ShiXt  2016年1月18日
 */
public class CommonConstants {
	
   public static int N_HANDLER = 0;
    
    /**
     * 新增失败信息
     */

   public static final String CREATE_FAILURE = "新增失败";
   /**
    * 录入员
    */
   
   public static final String ROLE_ENTERING = "录入员";
    
    /**
     * 删除失败信息
     */
    public static final String DELETE_FAILURE = "删除失败";
    
    /**
     * 更新失败信息
     */
    public static final String UPDATE_FAILURE = "更新失败";
    
    /**
     * 查询失败信息
     */
    public static final String QUERY_FAILURE = "查询失败";
    
    /**
     * 推送失败信息
     */
    public static final String PUSH_FAILURE = "推送失败";
    /**
     * 模块长编码分割符号
     */
    public static final String MODULE_SPLIT = "!";
    /**
     * 长编码分割符号
     */
    public static final String SPLIT_CHAR="!";
    
       /**
     * 基本特征类型
     */
    public static final String BASIC_FEATURES_TYPE="BASIC";
    /**
     * 二级切割符
     */
    public static final String SECOND_SPLIT_CHAR=",";
    /**
     * 人特征类型
     */
    public static final String PERSON_FEATURES_TYPE="PERSON";
    /**
     * 车特征类型
     */
    public static final String CAR_FEATURES_TYPE="CAR";
    /**
     * 物特征类型
     */
    public static final String ITEM_FEATURES_TYPE="ITEM";
    /**
     * 更新操作关键字
     */
    public static final String UPDATE_METHOD="UPDATE";
    /**
     * 删除操作关键字
     */
    public static final String DELETE_METHOD="DELETE";
    
    /**
     * 上传文件类型 1： 图片
     */
    public static final String FILE_TYPE_IMAGE="1";
    /**
     * 上传文件类型 2：视频
     */
    public static final String FILE_TYPE_VEDIO="2";
    
    /**
     *人员表来源类型 0：结构化页面录入
     */
    public static final String PERSON_TYPE_INPUT="0";
    /**
     * 人员表来源类型 1：结构化页面人员库导入
     */
    public static final String PERSON_TYPE_IMPORT="1";
    
    /**
     * 特征类型 T： 文本
     */
    public static final String FEATURE_TYPE_INPUT="T";
    /**
     * 特征类型 S：选择
     */
    public static final String FEATURE_TYPE_SELECT="S";
    /**
     * 卷宗创建类型(案件碰撞)
     */
    public static final String ARCHIVE_CREATE_AJPZ="AJPZ";
    /**
     * 卷宗创建类型(个案研判)
     */
    public static final String ARCHIVE_CREATE_GAYP="GAYP";
    /**
     * 卷宗创建类型(类案研判)
     */
    public static final String ARCHIVE_CREATE_LAYP="LAYP";
    
    /**
     * 合成作战 流程类别  FF 分发 XZ 协作'
     */
    public static final String COMBINPROCESS_TYPE_FF ="FF";
    public static final String COMBINPROCESS_TYPE_XZ ="XZ";
    
    public static final String DEPT_TYPE="DEPT";
    public static final String USER_TYPE="USER";
    public static final String DIRECT_TYPE="DIRECT";
    public static final String TRAN_TYPE="DIRECT";
    
    public static final String YES_STATUS="Y";
    public static final String NO_STATUS="N";
    
    public static final String CASE_MATERAIL = "5";
    
    public static final String ISPOLICE = "0";
    
    public static final String NOTPOLICE = "1";
    
    /****************案件审批状态***********************/
    /**
     * 审批状态： 1 新建（未提交）
     */
	public static final Integer VERIFYINGSTATUS_NEW = 1;
	/***
	 * 审批状态： 2 待审批
	 */
    public static final Integer VERIFYINGSTATUS_PENDING = 2;
    
    /**
     * 审批状态： 3审批不通过
     */
	public static final Integer VERIFYINGSTATUS_DENEY = 3;
	
	  /**
     * 审批状态： 4 通过审核
     */
	public static final Integer VERIFYINGSTATUS_PASS = 4;
	
    /**
     * 审批状态： 5 退回（不合格）
     */
    public static final Integer VERIFYINGSTATUS_BACK_BACK=5;
    
    /**
     * 审批状态： 6 补录
     */
    public static final Integer VERIFYINGSTATUS_BACK_TRACKING=6;
    
    public final static Map<Integer,String> COLORS = new HashMap<Integer,String>();
   	static {
   	COLORS.put(1,  "红色");
   	COLORS.put(2,  "黄色");
   	COLORS.put(3,  "绿色");
   	COLORS.put(4,  "青色");
   	COLORS.put(5,  "蓝色");
    COLORS.put(6,  "紫色");
   	COLORS.put(7,  "黑色");
   	COLORS.put(8,  "白色");
   	COLORS.put(9,  "灰色");
   	COLORS.put(10,  "褐色");
   	COLORS.put(11,  "品红色");
   	COLORS.put( 12,  "橙色");
   	COLORS.put(13,  "粉色");
   	COLORS.put( 14,  "棕色");
  
   	}
   	
    public final static Map<Integer,String> VERIFYINGSTATUS_MAP = new HashMap<Integer,String>();
   	static {
   		VERIFYINGSTATUS_MAP.put(1,  "新建");
   		VERIFYINGSTATUS_MAP.put(2,  "待审核");
   		VERIFYINGSTATUS_MAP.put(3,  "审批不通过");
   		VERIFYINGSTATUS_MAP.put(4,  "审批通过");
   		VERIFYINGSTATUS_MAP.put(5,  "退回");
   		VERIFYINGSTATUS_MAP.put(6,  "补录");
  
   	}
}
