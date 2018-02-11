package com.jiuling.web.dwr;

import java.util.List;

/**
 * 好友群组bean
 * @author fanxiaoming
 */
public class FriendGroupBean {
	private String groupname;
	private String id;
	private int online;//群组下面在线人数
	private List<MineBean> list;
	
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public List<MineBean> getList() {
		return list;
	}
	public void setList(List<MineBean> list) {
		this.list = list;
	}
}
