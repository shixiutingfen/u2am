package com.jiuling.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysDept implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3918048048586563339L;

	private Long deptId;

    private String longNumber;

    private String deptName;

    private String deptNumber;

    private Long parentId;

    private Long deptLevel;

    private String displayName;

    private Long isLeaf;

    private Long deptState;

    private Long adminIdentity;

    private String address;

    private Long tel;

    private Long isBizOrg;

    private String bizCode;

    private Long seq;

    private Long description;

    private Long creatorId;

    private Date createTime;

    private Long lastUpdateUserId;

    private Date lastUpdatedTime;

    private String ctrlUnitId;
    
    private List<SysDept> children;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber == null ? null : longNumber.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber == null ? null : deptNumber.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Long deptLevel) {
        this.deptLevel = deptLevel;
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

    public Long getDeptState() {
        return deptState;
    }

    public void setDeptState(Long deptState) {
        this.deptState = deptState;
    }

    public Long getAdminIdentity() {
        return adminIdentity;
    }

    public void setAdminIdentity(Long adminIdentity) {
        this.adminIdentity = adminIdentity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Long getIsBizOrg() {
        return isBizOrg;
    }

    public void setIsBizOrg(Long isBizOrg) {
        this.isBizOrg = isBizOrg;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
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

    public List<SysDept> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysDept> children)
    {
        this.children = children;
    }
    
}