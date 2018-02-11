package com.jiuling.core.util;

public class IdUtils {
    public static String getAnalyseTemplateId() {
        return "at_" + RandomUtils.get24TimeRandom();
    }

    public static String getBasicWeightId() {
        return "bw_" + RandomUtils.get24TimeRandom();
    }

    public static String getEvidenceWeightId() {
        return "ew_" + RandomUtils.get24TimeRandom();
    }

    /**
     * APP_ANALYSE_WHOCANUSE (研判模型表)
     * 
     * @return
     */
    public static String getWhoCanUseId() {
        return "use_" + RandomUtils.get24TimeRandom();
    }

    public static String getPersonBasicId() {
        return "pb_" + RandomUtils.get24TimeRandom();
    }

    public static String getPersonDetailId() {
        return "pd_" + RandomUtils.get24TimeRandom();
    }

    /**
     * APP_WHOCANUSE (设置谁可见通用表)
     * 
     * @return
     */
    public static String getWhoUseId() {
        return "wu_" + RandomUtils.get24TimeRandom();
    }

    /**
     * APP_ARCHIVE_Basic (串并基本表)
     */
    public static String getArchiveBasicId() {
        return "ab_" + RandomUtils.get24TimeRandom();
    }

    /**
     * APP_ARCHIVE_DETAIL (串并管理详情表)
     */
    public static String getArchiveDetailId() {
        return "ad_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 类案研判积分模板id
     */
    public static String getTypeCaseAnalyseTemplateId() {
        return "tt_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 类案研判权重id
     */
    public static String getTypeCaseWeightId() {
        return "tw_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-主表id
     */
    public static String getCombinId() {
        return "cb_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程主表id
     */
    public static String getCombinProcessId() {
        return "cp_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程涉及到的附件表id
     */
    public static String getCombinAttachId() {
        return "ca_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程涉及到的附件表id
     */
    public static String getCombinTaskAttachId() {
        return "cta_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程涉及串并表id
     */
    public static String getCombinArchiveId() {
        return "cpa_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程涉及案件表 id
     */
    public static String getCombinLawcaseId() {
        return "cpl_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务分发 id
     */
    public static String getCombinDistributeId() {
        return "cpd_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务分发子任务 id
     */
    public static String getCombinDistributeTaskId() {
        return "cpdt_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务分发子任务接收人 id
     */
    public static String getCombinTaskReceiverId() {
        return "cptr_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务分发子任务关联案件 id
     */
    public static String getCombinTaskLawCaseId() {
        return "cptl_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务分发子任务关联串并 id
     */
    public static String getCombinTaskArchiveId() {
        return "cptl_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-attach
     */
    public static String getCombiAttachId() {
        return "cpa_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-任务协作时的接收对象表-APP_COMBINCOOP_RECEIVER CombincoopReceiver
     */
    public static String getCombinCoopRecieverId() {
        return "ccr_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-流程回复表 id
     */
    public static String getProcessReplyId() {
        return "cpr_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-回复关联的案件表 id
     */
    public static String getReplyLawcaseId() {
        return "rlc_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-回复关联的案件表 id
     */
    public static String getReplyArchiveId() {
        return "rar_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-回复关联的附件表 id
     */
    public static String getReplyAttachId() {
        return "rat_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战-引用回复 id
     */
    public static String getQuoteReplyId() {
        return "qr_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战结束-分数 id
     */
    public static String getCombinScoreId() {
        return "cbs_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战结束-战果 id
     */
    public static String getCombinEndId() {
        return "cbe_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 合成作战结束-战果 id
     */
    public static String getCombinResultId() {
        return "cbrt_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 用户账户 id
     */
    public static String getUserScoreAccountId() {
        return "usat_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 用户账户积分明细 id
     */
    public static String getUserScoreDetailId() {
        return "usdl_" + RandomUtils.get24TimeRandom();
    }

    /**
     * 聊天室消息id
     */
    public static String getChatMessageId() {
        return "cm_" + RandomUtils.get24TimeRandom();
    }
    /**
     * 聊天室群消息id
     */
    public static String getChatMessageGroupId() {
        return "cmg_" + RandomUtils.get24TimeRandom();
    }
    /**
     * 用户组基本信息id
     */
    public static String getChatGroupBasicId() {
        return "cgb_" + RandomUtils.get24TimeRandom();
    }
    /**
     * 用户组基本信息id
     */
    public static String getChatGroupDetailId() {
        return "cgd_" + RandomUtils.get24TimeRandom();
    }
    /**
     * 聊天文件id
     */
    public static String getChatFileId() {
        return "cf_" + RandomUtils.get24TimeRandom();
    }
    /**
     * 日志id
     */
    public static String getSysLogId() {
        return "sl_" + RandomUtils.get24TimeRandom();
    }
    /**
     * Car_data_Source表的 id
     */
    public static String getCarDataSourceId() {
        return "cds_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_lib_portrait
     */
    public static String getPortraitLibId() {
        return "alp_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_coolection
     */
    public static String getAppCollectionId() {
        return "ac_" + RandomUtils.get24TimeRandom();
    }

    /**
     * sys_user_attr
     */
    public static String getSysUserAttrId() {
        return "sua_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_lawcase_assist
     */
    public static String getLawcaseAssistId() {
        return "las_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_Service_Req
     */
    public static String getServiceReqId() {
        return "sr_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_News
     */
    public static String getNewsId() {
        return "ns_" + RandomUtils.get24TimeRandom();
    }

    /**
     * app_lawcase_media
     */
    public static String getLawcaseMediaId() {
        return "lmd_" + RandomUtils.get24TimeRandom();
    }

    /**
     * t_main_analysetask
     */
    public static String getMainAnalyseTask() {
        return "tma_" + RandomUtils.get24TimeRandom();
    }
    
    /**
     * APP_MAP_DRAW
     */
    public static String getMapDrawId() {
        return "mdr_" + RandomUtils.get24TimeRandom();
    }
    
    /**
     * app_map_draw_points
     */
    public static String getMapDrawPointsId() {
        return "mdrp_" + RandomUtils.get24TimeRandom();
    }
    
    /**
     * t_main_analysetask
     */
    public static String getMainAnalysisTask(){
    	return "tmn"+ RandomUtils.get24TimeRandom();
    }
    /**
     * t_analysetask
     */
    public static String getAnalysisTask(){
    	return "tna"+ RandomUtils.get24TimeRandom();
    }
    
    public static void main(String[] args) {
		System.out.println(IdUtils.getSysLogId());
	}
}
