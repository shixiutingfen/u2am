package com.jiuling.web.model;

import java.util.Date;

public class CtrlUnitFile {
    private Long id;

    private String fileType;

    private String fileSuffix;

    private String fileName;

    private String fileNameafterupload;

    private String filePathafterupload;

    private String fileLocalPath;

    /**
     * 提交转码时管理服务器返回的videoId，用于查询转码id
     */
    private String ctrlUnitId;

    private Long cameraId;

    private String fileDescription;

    private String thumbNail;

    private String fileSize;

    private Long createUerid;

    private Date createTime;

    private String serialnumber;

    private String transcodingId;

    private String transcodingProgress;

    private Long frameCount;

    private Long framerate;

    private String slaveIp;
    
    private String fileId;
    
    public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
     * 创建时间
     */
    private String createTimeStr;
    
    /**
     * 转码进度
     */
    private String transcodingProgressStr;
    
    /**
     * 监控点名称
     */
    private String cameraName;

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }
    
 
    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    
    public String getTranscodingProgressStr() {
        return transcodingProgressStr;
    }

    public void setTranscodingProgressStr(String transcodingProgressStr) {
        this.transcodingProgressStr = transcodingProgressStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCtrlUnitId() {
        return ctrlUnitId;
    }

    public void setCtrlUnitId(String ctrlUnitId) {
        this.ctrlUnitId = ctrlUnitId == null ? null : ctrlUnitId.trim();
    }

    public Long getCameraId() {
        return cameraId;
    }

    public void setCameraId(Long cameraId) {
        this.cameraId = cameraId;
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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public String getTranscodingId() {
        return transcodingId;
    }

    public void setTranscodingId(String transcodingId) {
        this.transcodingId = transcodingId == null ? null : transcodingId.trim();
    }

    public String getTranscodingProgress() {
        return transcodingProgress;
    }

    public void setTranscodingProgress(String transcodingProgress) {
        this.transcodingProgress = transcodingProgress == null ? null : transcodingProgress.trim();
    }

    public Long getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Long frameCount) {
        this.frameCount = frameCount;
    }

    public Long getFramerate() {
        return framerate;
    }

    public void setFramerate(Long framerate) {
        this.framerate = framerate;
    }

    public String getSlaveIp() {
        return slaveIp;
    }

    public void setSlaveIp(String slaveIp) {
        this.slaveIp = slaveIp == null ? null : slaveIp.trim();
    }
}