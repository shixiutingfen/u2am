package com.jiuling.web.dwr;

import java.io.Serializable;
import java.util.List;

public class MembersDataBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2630492855116526767L;
	private MineBean owner;
	private List<GroupBean> list;
	private Integer members;
	public MineBean getOwner() {
		return owner;
	}
	public void setOwner(MineBean owner) {
		this.owner = owner;
	}
	public List<GroupBean> getList() {
		return list;
	}
	public void setList(List<GroupBean> list) {
		this.list = list;
	}
	public Integer getMembers() {
		return members;
	}
	public void setMembers(Integer members) {
		this.members = members;
	}
	
	
}
