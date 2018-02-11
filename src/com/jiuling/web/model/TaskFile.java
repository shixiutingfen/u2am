package com.jiuling.web.model;

import java.util.Date;

public class TaskFile {
    private Long id;

    private Long taskId;

    private String fileType;

    private String fileSuffix;

    private String fileName;

    private String fileNameafterupload;

    private String filePathafterupload;

    private String fileLocalPath;

    private String fileDescription;

    private String thumbNail;

    private String fileSize;

    private Long createUerid;

    private Date createTime;

    private String slaveIp;

    private Long c1;

    private Long c2;

    private Long c3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix == null ? null : fileSuffix.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileNameafterupload() {
        return fileNameafterupload;
    }

    public void setFileNameafterupload(String fileNameafterupload) {
        this.fileNameafterupload = fileNameafterupload == null ? null : fileNameafterupload.trim();
    }

    public String getFilePathafterupload() {
        return filePathafterupload;
    }

    public void setFilePathafterupload(String filePathafterupload) {
        this.filePathafterupload = filePathafterupload == null ? null : filePathafterupload.trim();
    }

    public String getFileLocalPath() {
        return fileLocalPath;
    }

    public void setFileLocalPath(String fileLocalPath) {
        this.fileLocalPath = fileLocalPath == null ? null : fileLocalPath.trim();
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription == null ? null : fileDescription.trim();
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail == null ? null : thumbNail.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public Long getCreateUerid() {
        return createUerid;
    }

    public void setCreateUerid(Long createUerid) {
        this.createUerid = createUerid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSlaveIp() {
        return slaveIp;
    }

    public void setSlaveIp(String slaveIp) {
        this.slaveIp = slaveIp == null ? null : slaveIp.trim();
    }

    public Long getC1() {
        return c1;
    }

    public void setC1(Long c1) {
        this.c1 = c1;
    }

    public Long getC2() {
        return c2;
    }

    public void setC2(Long c2) {
        this.c2 = c2;
    }

    public Long getC3() {
        return c3;
    }

    public void setC3(Long c3) {
        this.c3 = c3;
    }
}