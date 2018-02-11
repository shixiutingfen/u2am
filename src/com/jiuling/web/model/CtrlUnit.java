package com.jiuling.web.model;

import java.io.Serializable;
import java.util.Date;

public class CtrlUnit implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6251097697008001312L;
    private Long id;

    private Long unitState;

    private String unitIdentity;

    private String orgType;

    private Long shareUnitId;

    private String longNumber;

    private Long unitLevel;

    private String displayName;

    private Long isLeaf;

    private Long seqNum;

    private String unitName;

    private String unitNumber;

    private String unitDescription;

    private Long creatorId;

    private Date createTime;

    private Long lastUpdateUserId;

    private Date lastUpdatedTime;

    private String ctrlUnitId;

    private String unitParentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitState() {
        return unitState;
    }

    public void setUnitState(Long unitState) {
        this.unitState = unitState;
    }

    public String getUnitIdentity() {
        return unitIdentity;
    }

    public void setUnitIdentity(String unitIdentity) {
        this.unitIdentity = unitIdentity == null ? null : unitIdentity.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public Long getShareUnitId() {
        return shareUnitId;
    }

    public void setShareUnitId(Long shareUnitId) {
        this.shareUnitId = shareUnitId;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber == null ? null : longNumber.trim();
    }

    public Long getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(Long unitLevel) {
        this.unitLevel = unitLevel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public Long getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Long isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber == null ? null : unitNumber.trim();
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription == null ? null : unitDescription.trim();
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

    public String getUnitParentId() {
        return unitParentId;
    }

    public void setUnitParentId(String unitParentId) {
        this.unitParentId = unitParentId == null ? null : unitParentId.trim();
    }
}