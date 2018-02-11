package com.jiuling.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Module implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4687569953487273176L;

	private Long moduleId;

    private Long parentId;

    private String moduleUrl;

    private String state;

    private String isVisible;

    private String actions;

    private String longNumber;

    private Long moduleLevel;

    private String displayName;

    private Long leaf;

    private Long seq;

    private String moduleName;

    private String moduleNumber;

    private String moduleDescription;

    private Long creatorId;

    private Date createTime;

    private Long lastUpdateUserId;

    private Date lastUpdatedTime;

    private String ctrlUnitId;

    private String moduleIcon;

    private String isDsiplay;

    private Long displayOrder;

    private String info1;

    private String info2;

    private String info3;
    private List<Module> children;
    public Long getModuleId() {
        return moduleId;
    }

    public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
	}

	public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl == null ? null : moduleUrl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible == null ? null : isVisible.trim();
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions == null ? null : actions.trim();
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber == null ? null : longNumber.trim();
    }

    public Long getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(Long moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public Long getLeaf() {
        return leaf;
    }

    public void setLeaf(Long leaf) {
        this.leaf = leaf;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(String moduleNumber) {
        this.moduleNumber = moduleNumber == null ? null : moduleNumber.trim();
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription == null ? null : moduleDescription.trim();
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

    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getCtrlUnitId() {
        return ctrlUnitId;
    }

    public void setCtrlUnitId(String ctrlUnitId) {
        this.ctrlUnitId = ctrlUnitId == null ? null : ctrlUnitId.trim();
    }

    public String getModuleIcon() {
        return moduleIcon;
    }

    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon == null ? null : moduleIcon.trim();
    }

    public String getIsDsiplay() {
        return isDsiplay;
    }

    public void setIsDsiplay(String isDsiplay) {
        this.isDsiplay = isDsiplay == null ? null : isDsiplay.trim();
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1 == null ? null : info1.trim();
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2 == null ? null : info2.trim();
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3 == null ? null : info3.trim();
    }
}