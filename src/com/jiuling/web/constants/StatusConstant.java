package com.jiuling.web.constants;

public class StatusConstant {
    /**
     * 协作状态 任务状态 RUN 正在处理 TIMEOUT 超时未处理 WAIT 等待任务被接收 DONE 处理完毕TRASH草稿
     */
    public static enum CombinProcessStatus {
        RUN("RUN"), TIMEOUT("TIMEOUT"), DONE("DONE"), WAIT("WAIT"), TRASH("TRASH");

        private final String value;

        CombinProcessStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    /**
     * 指令审批状态， 
     * 草稿： -1
     * 一级待审批 0
     * 一级审批通过，1
     * 一级审批不通过，2
     * 局级待审批（等同于一级审批通过），1
     * 二级审批通过，3
     * 二级审批不通过 4
     * 
     */
    public static enum ProcessApprovalStatus {
        NEW("-1"), PENDING_LEVEL1("0"), PASS_LEVEL1("1"), 
        	DENEY_LEVEL1("2"), PASS_LEVEL2("3"), DENEY_LEVEL2("4");

        private final String value;

        ProcessApprovalStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 聊天类型 SINGLE群组里单对单 GROUP群组 USER成员列表里单对单
     *
     */
    public static enum ChatTypeStatus {
        SINGLE("SINGLE"), GROUP("GROUP"), USER("USER");

        private final String value;

        ChatTypeStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    /**
     * 聊天消息类型  1text 2图片 3视频 ...
     *
     */
    public static enum ChatContentType {
        TEXT("0"), PICTURE("1"), VIDEO("2");

        private final String value;

        ChatContentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        //System.out.println(StatusConstant.CombinProcessStatus.WAIT.getValue());
    }
}
