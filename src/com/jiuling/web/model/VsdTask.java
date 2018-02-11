package com.jiuling.web.model;

import java.util.Date;

public class VsdTask {
    private Long id;

    private String name;

    private String serialnumber;

    private String type;

    private String isvalid;

    private Short status;

    private Short retrycount;

    private String slaveip;

    private Date endtime;

    private Date createtime;

    private Long createUser;

    private String approved;

    private Long approvedUser;

    private String c1;

    private String c2;

    private String c3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getRetrycount() {
        return retrycount;
    }

    public void setRetrycount(Short retrycount) {
        this.retrycount = retrycount;
    }

    public String getSlaveip() {
        return slaveip;
    }

    public void setSlaveip(String slaveip) {
        this.slaveip = slaveip == null ? null : slaveip.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved == null ? null : approved.trim();
    }

    public Long getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(Long approvedUser) {
        this.approvedUser = approvedUser;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }
}