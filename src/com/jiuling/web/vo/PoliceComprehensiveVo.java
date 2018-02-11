package com.jiuling.web.vo;

import java.io.Serializable;
import java.util.Date;

public class PoliceComprehensiveVo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3104714936178967576L;

	private String lawcaseId;
	
    private String caseName;

    private String caseCode;
    
    /**
     * 案件类别
     */
    private String categoryValue;
    
    private String categoryValueOption;
    /**
     * 案件性质
     */
    private String propertyValue;
    
    private String propertyValueOption;
    
    private String caseState;
    /**
     * 发案起始时间
     */
    private Date startTime;
    private String startTimeStr;
    /**
     * 发案终止时间
     */
    private Date endTime;
    private String endTimeStr;
    /**
     * 接警时间
     */
    private Date recieveTime;
    private String recieveTimeStr;
    private String recieveTimeStr2;
    /**
     * 责任单位
     */
    private String engageOrg;
    private String engageOrgOption;
    /**
     * reporter_name
     */
    private String reporterName;
    /**
     * 报案人电话
     */
    private String reporterPhone;
    /**
     * 案发区划
     */
    private String locationId;
    private String locationIdOption;
    /**
     * 案发派出所
     */
    private String policeStation;
    private String policeStationOption;
    /**
     * 案发社区
     */
    private String caseCommunity;
    private String caseCommunityOption;
    /**
     * 案发地点类型
     */
    private String locationType;
    private String locationTypeOption;
    /**
     * 案发地点名称
     */
    private String locationName;
    private String locationNameOption;
    /**
     * 案发详址
     */
    private String locationDetail;
    /**
     * 发案经度
     */
    private String lontitude;
    /**
     * 发案纬度
     */
    private String latitude;
    /**
     * 案发区域
     */
    private String caseArea;
    private String caseAreaOption;
    /**
     * 案发场所
     */
    private String casePlaces;
    private String casePlacesOption;
    /**
     * 地点类别
     */
    private String placesType;
    private String placesTypeOption;
    /**
     * 案情简介
     */
    private String caseDesc;
    /**
     * 涉案金额
     */
    private String caseMoney;
    /**
     * 案件状态
     */
    private String stateValue;
    /**
     * 经济损失
     */
    private String moneyLose;
    /**
     * 选择处所
     */
    private String choosePlace;
    private String choosePlaceOption;
    /**
     * 选择对象
     */
    private String choosePerson;
    private String choosePersonOption;
    /**
     * 选择物品
     */
    private String chooseItem;
    private String chooseItemOption;
    /**
     * 选择日期
     */
    private String chooseDate;
    private String chooseDateOption;
    /**
     * 选择时间
     */
    private String chooseTime;
    private String chooseTimeOption;
    /**
     * 选择时机
     */
    private String chooseChance;
    private String chooseChanceOption;
    /**
     * 选择天气 
     */
    private String chooseWeather;
    private String chooseWeatherOption;
    /**
     * 侵入手段
     */
    private String caseMethodFeaturesValue;
    private String caseMethodFeaturesValueOption;
    /**
     * 窃入手段
     */
    private String stealMethod;
    private String stealMethodOption;
    /**
     * 伪装灭迹
     */
    private String disguiseMethod;
    private String disguiseMethodOption;
    /**
     * 预备手段
     */
    private String prepareMethod;
    private String prepareMethodOption;
    /**
     * 组织形式
     */
    private String orgWay;
    private String orgWayOption;
    /**
     * 勾结形式
     */
    private String colludeWay;
    private String colludeWayOption;
    /**
     * 作案范围
     */
    private String caseWay;
    private String caseWayOption;
    /**
     * 试探方式
     */
    private String exploreWay;
    private String exploreWayOption;
    /**
     * 行为特点
     */
    private String actionWay;
    private String actionWayOption;
    /**
     * 是否抢渡
     */
    private String isCross;
    private String isCrossOption;
    /**
     * 公交路线
     */
    private String busWay;
    private String busWayOption;
    /**
     * 上车站点
     */
    private String upStation;
    private String upStationOption;
    /**
     * 下车站点
     */
    private String downStation;
    private String downStationOption;
    /**
     * 作案工具
     */
    private String caseTool;
    private String caseToolOption;
    /**
     * 处理结果
     */
    private String oprateResult;
    private String oprateResultOption;
    /**
     * 关键字
     */
    private String keyWords;
    /**
     * 备注及民警意见
     */
    private String remarkAdvice;
    /**
     * 是否有嫌疑人
     */
    private String hasSupect;
    private String hasSupectOption;
    /**
     * 是否有现场勘查
     */
    private String hasSurvey;
    private String hasSurveyOption;
    /**
     * 是否是老数据
     */
    private Integer isOldData;
    private String isOldDataOption;
    /**
     * 电子归档id
     */
    private String electronicFileId;
    
    /**
     * 案件分类： 案件、疑情
     */
    private String caseClass;
    private String caseClassOption;
    /**
     * 案件封面
     */
    private String caseThumbnail;
    /**
     * 创建人
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    private String createTimeStr;
    private String createTimeStr2;
    private String createTimeStr3;

	private String createTimeStr4;

    /**
     * 更新人
     */
    private Long updateUserId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标识
     */
    private Integer isDeleted;
    private Integer isDeletedOption;
    /**
     * 删除时间
     */
    private Date deleteTime;
    /**
     * 删除原因
     */
    private String deleteReason;
    /**
     * 归档信息
     */
    private String archiveInfo;
    /**
     * 归档报告
     */
    private String archiveReport;
    /**
     * 责任人
     */
    private Long principal;
    /**
     * 是否是经典案例
     */
    private Integer isClassicCase;
    private Integer isClassicCaseOption;
    /**
     * 案发地图层级
     */
    private Long happenPlaceLevel;
    /**
     * 报案人
     */
    private String reportPerson;
    /**
     * 报案人证件号码
     */
    private String idCard;
    /**
     * 报案人电话
     */
    private String contactPhone;
    /**
     * 是否是合格案件
     */
    private Integer isqualified;
    private Integer isqualifiedOption;
    /**
     * 专网id
     */
    private Long sourceid;
    /**
     * 专网网闸
     */
    private String isacrossborder;
    /**
     * 审批关联的附件id
     */
    private Long withwaitverifyres;
    
    private Long operator;
    
    private Long groupId;
    /**
     * 接触警编号
     */
    private String recieveCode;
    
    /**
     * 案件类别的级别
     */
    private String categoryValueLevel;
    /**
     * 审核状态
     */
    private Long verifyingStatus;
    
    
    private String isAnalysis;
    
	public String getCaseState() {
		return caseState;
	}
	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}
	public String getLawcaseId() {
		return lawcaseId;
	}
	public void setLawcaseId(String lawcaseId) {
		this.lawcaseId = lawcaseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public String getCategoryValueOption() {
		return categoryValueOption;
	}
	public void setCategoryValueOption(String categoryValueOption) {
		this.categoryValueOption = categoryValueOption;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyValueOption() {
		return propertyValueOption;
	}
	public void setPropertyValueOption(String propertyValueOption) {
		this.propertyValueOption = propertyValueOption;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
	public Date getRecieveTime() {
		return recieveTime;
	}
	public void setRecieveTime(Date recieveTime) {
		this.recieveTime = recieveTime;
	}
	public String getRecieveTimeStr() {
		return recieveTimeStr;
	}
	public void setRecieveTimeStr(String recieveTimeStr) {
		this.recieveTimeStr = recieveTimeStr;
	}
	public String getEngageOrg() {
		return engageOrg;
	}
	public void setEngageOrg(String engageOrg) {
		this.engageOrg = engageOrg;
	}
	public String getEngageOrgOption() {
		return engageOrgOption;
	}
	public void setEngageOrgOption(String engageOrgOption) {
		this.engageOrgOption = engageOrgOption;
	}
	public String getReporterName() {
		return reporterName;
	}
	
	public String getStateValue() {
		return stateValue;
	}
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	public String getReporterPhone() {
		return reporterPhone;
	}
	public void setReporterPhone(String reporterPhone) {
		this.reporterPhone = reporterPhone;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationIdOption() {
		return locationIdOption;
	}
	public void setLocationIdOption(String locationIdOption) {
		this.locationIdOption = locationIdOption;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getPoliceStationOption() {
		return policeStationOption;
	}
	public void setPoliceStationOption(String policeStationOption) {
		this.policeStationOption = policeStationOption;
	}
	public String getCaseCommunity() {
		return caseCommunity;
	}
	public void setCaseCommunity(String caseCommunity) {
		this.caseCommunity = caseCommunity;
	}
	public String getCaseCommunityOption() {
		return caseCommunityOption;
	}
	public void setCaseCommunityOption(String caseCommunityOption) {
		this.caseCommunityOption = caseCommunityOption;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLocationTypeOption() {
		return locationTypeOption;
	}
	public void setLocationTypeOption(String locationTypeOption) {
		this.locationTypeOption = locationTypeOption;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationNameOption() {
		return locationNameOption;
	}
	public void setLocationNameOption(String locationNameOption) {
		this.locationNameOption = locationNameOption;
	}
	public String getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}
	public String getLontitude() {
		return lontitude;
	}
	public void setLontitude(String lontitude) {
		this.lontitude = lontitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getCaseArea() {
		return caseArea;
	}
	public void setCaseArea(String caseArea) {
		this.caseArea = caseArea;
	}
	public String getCaseAreaOption() {
		return caseAreaOption;
	}
	public void setCaseAreaOption(String caseAreaOption) {
		this.caseAreaOption = caseAreaOption;
	}
	public String getCasePlaces() {
		return casePlaces;
	}
	public void setCasePlaces(String casePlaces) {
		this.casePlaces = casePlaces;
	}
	public String getCasePlacesOption() {
		return casePlacesOption;
	}
	public void setCasePlacesOption(String casePlacesOption) {
		this.casePlacesOption = casePlacesOption;
	}
	public String getPlacesType() {
		return placesType;
	}
	public void setPlacesType(String placesType) {
		this.placesType = placesType;
	}
	public String getPlacesTypeOption() {
		return placesTypeOption;
	}
	public void setPlacesTypeOption(String placesTypeOption) {
		this.placesTypeOption = placesTypeOption;
	}
	public String getCaseDesc() {
		return caseDesc;
	}
	public void setCaseDesc(String caseDesc) {
		this.caseDesc = caseDesc;
	}
	public String getCaseMoney() {
		return caseMoney;
	}
	public void setCaseMoney(String caseMoney) {
		this.caseMoney = caseMoney;
	}
	public String getMoneyLose() {
		return moneyLose;
	}
	public void setMoneyLose(String moneyLose) {
		this.moneyLose = moneyLose;
	}
	public String getChoosePlace() {
		return choosePlace;
	}
	public void setChoosePlace(String choosePlace) {
		this.choosePlace = choosePlace;
	}
	public String getChoosePlaceOption() {
		return choosePlaceOption;
	}
	public void setChoosePlaceOption(String choosePlaceOption) {
		this.choosePlaceOption = choosePlaceOption;
	}
	public String getChoosePerson() {
		return choosePerson;
	}
	public void setChoosePerson(String choosePerson) {
		this.choosePerson = choosePerson;
	}
	public String getChoosePersonOption() {
		return choosePersonOption;
	}
	public void setChoosePersonOption(String choosePersonOption) {
		this.choosePersonOption = choosePersonOption;
	}
	public String getChooseItem() {
		return chooseItem;
	}
	public void setChooseItem(String chooseItem) {
		this.chooseItem = chooseItem;
	}
	public String getChooseItemOption() {
		return chooseItemOption;
	}
	public void setChooseItemOption(String chooseItemOption) {
		this.chooseItemOption = chooseItemOption;
	}
	public String getChooseDate() {
		return chooseDate;
	}
	public void setChooseDate(String chooseDate) {
		this.chooseDate = chooseDate;
	}
	public String getChooseDateOption() {
		return chooseDateOption;
	}
	public void setChooseDateOption(String chooseDateOption) {
		this.chooseDateOption = chooseDateOption;
	}
	public String getChooseTime() {
		return chooseTime;
	}
	public void setChooseTime(String chooseTime) {
		this.chooseTime = chooseTime;
	}
	public String getChooseTimeOption() {
		return chooseTimeOption;
	}
	public void setChooseTimeOption(String chooseTimeOption) {
		this.chooseTimeOption = chooseTimeOption;
	}
	public String getChooseChance() {
		return chooseChance;
	}
	public void setChooseChance(String chooseChance) {
		this.chooseChance = chooseChance;
	}
	public String getChooseChanceOption() {
		return chooseChanceOption;
	}
	public void setChooseChanceOption(String chooseChanceOption) {
		this.chooseChanceOption = chooseChanceOption;
	}
	public String getChooseWeather() {
		return chooseWeather;
	}
	public void setChooseWeather(String chooseWeather) {
		this.chooseWeather = chooseWeather;
	}
	public String getChooseWeatherOption() {
		return chooseWeatherOption;
	}
	public void setChooseWeatherOption(String chooseWeatherOption) {
		this.chooseWeatherOption = chooseWeatherOption;
	}
	public String getCaseMethodFeaturesValue() {
		return caseMethodFeaturesValue;
	}
	public void setCaseMethodFeaturesValue(String caseMethodFeaturesValue) {
		this.caseMethodFeaturesValue = caseMethodFeaturesValue;
	}
	public String getCaseMethodFeaturesValueOption() {
		return caseMethodFeaturesValueOption;
	}
	public void setCaseMethodFeaturesValueOption(
			String caseMethodFeaturesValueOption) {
		this.caseMethodFeaturesValueOption = caseMethodFeaturesValueOption;
	}
	public String getStealMethod() {
		return stealMethod;
	}
	public void setStealMethod(String stealMethod) {
		this.stealMethod = stealMethod;
	}
	public String getStealMethodOption() {
		return stealMethodOption;
	}
	public void setStealMethodOption(String stealMethodOption) {
		this.stealMethodOption = stealMethodOption;
	}
	public String getDisguiseMethod() {
		return disguiseMethod;
	}
	public void setDisguiseMethod(String disguiseMethod) {
		this.disguiseMethod = disguiseMethod;
	}
	public String getDisguiseMethodOption() {
		return disguiseMethodOption;
	}
	public void setDisguiseMethodOption(String disguiseMethodOption) {
		this.disguiseMethodOption = disguiseMethodOption;
	}
	public String getPrepareMethod() {
		return prepareMethod;
	}
	public void setPrepareMethod(String prepareMethod) {
		this.prepareMethod = prepareMethod;
	}
	public String getPrepareMethodOption() {
		return prepareMethodOption;
	}
	public void setPrepareMethodOption(String prepareMethodOption) {
		this.prepareMethodOption = prepareMethodOption;
	}
	public String getOrgWay() {
		return orgWay;
	}
	public void setOrgWay(String orgWay) {
		this.orgWay = orgWay;
	}
	public String getOrgWayOption() {
		return orgWayOption;
	}
	public void setOrgWayOption(String orgWayOption) {
		this.orgWayOption = orgWayOption;
	}
	public String getColludeWay() {
		return colludeWay;
	}
	public void setColludeWay(String colludeWay) {
		this.colludeWay = colludeWay;
	}
	public String getColludeWayOption() {
		return colludeWayOption;
	}
	public void setColludeWayOption(String colludeWayOption) {
		this.colludeWayOption = colludeWayOption;
	}
	public String getCaseWay() {
		return caseWay;
	}
	public void setCaseWay(String caseWay) {
		this.caseWay = caseWay;
	}
	public String getCaseWayOption() {
		return caseWayOption;
	}
	public void setCaseWayOption(String caseWayOption) {
		this.caseWayOption = caseWayOption;
	}
	public String getExploreWay() {
		return exploreWay;
	}
	public void setExploreWay(String exploreWay) {
		this.exploreWay = exploreWay;
	}
	public String getExploreWayOption() {
		return exploreWayOption;
	}
	public void setExploreWayOption(String exploreWayOption) {
		this.exploreWayOption = exploreWayOption;
	}
	public String getActionWay() {
		return actionWay;
	}
	public void setActionWay(String actionWay) {
		this.actionWay = actionWay;
	}
	public String getActionWayOption() {
		return actionWayOption;
	}
	public void setActionWayOption(String actionWayOption) {
		this.actionWayOption = actionWayOption;
	}
	public String getIsCross() {
		return isCross;
	}
	public void setIsCross(String isCross) {
		this.isCross = isCross;
	}
	public String getIsCrossOption() {
		return isCrossOption;
	}
	public void setIsCrossOption(String isCrossOption) {
		this.isCrossOption = isCrossOption;
	}
	public String getBusWay() {
		return busWay;
	}
	public void setBusWay(String busWay) {
		this.busWay = busWay;
	}
	public String getBusWayOption() {
		return busWayOption;
	}
	public void setBusWayOption(String busWayOption) {
		this.busWayOption = busWayOption;
	}
	public String getUpStation() {
		return upStation;
	}
	public void setUpStation(String upStation) {
		this.upStation = upStation;
	}
	public String getUpStationOption() {
		return upStationOption;
	}
	public void setUpStationOption(String upStationOption) {
		this.upStationOption = upStationOption;
	}
	public String getDownStation() {
		return downStation;
	}
	public void setDownStation(String downStation) {
		this.downStation = downStation;
	}
	public String getDownStationOption() {
		return downStationOption;
	}
	public void setDownStationOption(String downStationOption) {
		this.downStationOption = downStationOption;
	}
	public String getCaseTool() {
		return caseTool;
	}
	public void setCaseTool(String caseTool) {
		this.caseTool = caseTool;
	}
	public String getCaseToolOption() {
		return caseToolOption;
	}
	public void setCaseToolOption(String caseToolOption) {
		this.caseToolOption = caseToolOption;
	}
	public String getOprateResult() {
		return oprateResult;
	}
	public void setOprateResult(String oprateResult) {
		this.oprateResult = oprateResult;
	}
	public String getOprateResultOption() {
		return oprateResultOption;
	}
	public void setOprateResultOption(String oprateResultOption) {
		this.oprateResultOption = oprateResultOption;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getRemarkAdvice() {
		return remarkAdvice;
	}
	public void setRemarkAdvice(String remarkAdvice) {
		this.remarkAdvice = remarkAdvice;
	}
	public String getHasSupect() {
		return hasSupect;
	}
	public void setHasSupect(String hasSupect) {
		this.hasSupect = hasSupect;
	}
	public String getHasSupectOption() {
		return hasSupectOption;
	}
	public void setHasSupectOption(String hasSupectOption) {
		this.hasSupectOption = hasSupectOption;
	}
	public String getHasSurvey() {
		return hasSurvey;
	}
	public void setHasSurvey(String hasSurvey) {
		this.hasSurvey = hasSurvey;
	}
	public String getHasSurveyOption() {
		return hasSurveyOption;
	}
	public void setHasSurveyOption(String hasSurveyOption) {
		this.hasSurveyOption = hasSurveyOption;
	}
	public Integer getIsOldData() {
		return isOldData;
	}
	public void setIsOldData(Integer isOldData) {
		this.isOldData = isOldData;
	}
	public String getIsOldDataOption() {
		return isOldDataOption;
	}
	public void setIsOldDataOption(String isOldDataOption) {
		this.isOldDataOption = isOldDataOption;
	}
	public String getElectronicFileId() {
		return electronicFileId;
	}
	public void setElectronicFileId(String electronicFileId) {
		this.electronicFileId = electronicFileId;
	}
	public String getCaseClass() {
		return caseClass;
	}
	public void setCaseClass(String caseClass) {
		this.caseClass = caseClass;
	}
	public String getCaseClassOption() {
		return caseClassOption;
	}
	public void setCaseClassOption(String caseClassOption) {
		this.caseClassOption = caseClassOption;
	}
	public String getCaseThumbnail() {
		return caseThumbnail;
	}
	public void setCaseThumbnail(String caseThumbnail) {
		this.caseThumbnail = caseThumbnail;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Integer getIsDeletedOption() {
		return isDeletedOption;
	}
	public void setIsDeletedOption(Integer isDeletedOption) {
		this.isDeletedOption = isDeletedOption;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	public String getArchiveInfo() {
		return archiveInfo;
	}
	public void setArchiveInfo(String archiveInfo) {
		this.archiveInfo = archiveInfo;
	}
	public String getArchiveReport() {
		return archiveReport;
	}
	public void setArchiveReport(String archiveReport) {
		this.archiveReport = archiveReport;
	}
	public Long getPrincipal() {
		return principal;
	}
	public void setPrincipal(Long principal) {
		this.principal = principal;
	}
	public Integer getIsClassicCase() {
		return isClassicCase;
	}
	public void setIsClassicCase(Integer isClassicCase) {
		this.isClassicCase = isClassicCase;
	}
	public Integer getIsClassicCaseOption() {
		return isClassicCaseOption;
	}
	public void setIsClassicCaseOption(Integer isClassicCaseOption) {
		this.isClassicCaseOption = isClassicCaseOption;
	}
	public Long getHappenPlaceLevel() {
		return happenPlaceLevel;
	}
	public void setHappenPlaceLevel(Long happenPlaceLevel) {
		this.happenPlaceLevel = happenPlaceLevel;
	}
	public String getReportPerson() {
		return reportPerson;
	}
	public void setReportPerson(String reportPerson) {
		this.reportPerson = reportPerson;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public Integer getIsqualified() {
		return isqualified;
	}
	public void setIsqualified(Integer isqualified) {
		this.isqualified = isqualified;
	}
	public Integer getIsqualifiedOption() {
		return isqualifiedOption;
	}
	public void setIsqualifiedOption(Integer isqualifiedOption) {
		this.isqualifiedOption = isqualifiedOption;
	}
	public Long getSourceid() {
		return sourceid;
	}
	public void setSourceid(Long sourceid) {
		this.sourceid = sourceid;
	}
	public String getIsacrossborder() {
		return isacrossborder;
	}
	public void setIsacrossborder(String isacrossborder) {
		this.isacrossborder = isacrossborder;
	}
	public Long getWithwaitverifyres() {
		return withwaitverifyres;
	}
	public void setWithwaitverifyres(Long withwaitverifyres) {
		this.withwaitverifyres = withwaitverifyres;
	}
	public String getRecieveTimeStr2() {
		return recieveTimeStr2;
	}
	public void setRecieveTimeStr2(String recieveTimeStr2) {
		this.recieveTimeStr2 = recieveTimeStr2;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public String getCreateTimeStr2() {
		return createTimeStr2;
	}
	public void setCreateTimeStr2(String createTimeStr2) {
		this.createTimeStr2 = createTimeStr2;
	}
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getRecieveCode() {
		return recieveCode;
	}
	public void setRecieveCode(String recieveCode) {
		this.recieveCode = recieveCode;
	}
	public String getCategoryValueLevel() {
		return categoryValueLevel;
	}
	public void setCategoryValueLevel(String categoryValueLevel) {
		this.categoryValueLevel = categoryValueLevel;
	}
	public Long getVerifyingStatus() {
		return verifyingStatus;
	}
	public void setVerifyingStatus(Long verifyingStatus) {
		this.verifyingStatus = verifyingStatus;
	}
	public String getIsAnalysis() {
		return isAnalysis;
	}
	public void setIsAnalysis(String isAnalysis) {
		this.isAnalysis = isAnalysis;
	}
	
	public void setCreateTimeStr3(String createTimeStr3) {
		this.createTimeStr3 = createTimeStr3;
	}
	public String getCreateTimeStr4() {
		return createTimeStr4;
	}
	public void setCreateTimeStr4(String createTimeStr4) {
		this.createTimeStr4 = createTimeStr4;
	}
	public String getCreateTimeStr3() {
		return createTimeStr3;
	}
    
}
