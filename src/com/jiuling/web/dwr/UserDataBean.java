package com.jiuling.web.dwr;

import java.util.List;

/**
 * userDataBean
 * @author fanxiaoming
 */
public class UserDataBean {
	private MineBean mine;
	private List<FriendGroupBean> friend;
	private List<GroupBean> group;
	public MineBean getMine() {
		return mine;
	}
	public void setMine(MineBean mine) {
		this.mine = mine;
	}
	public List<FriendGroupBean> getFriend() {
		return friend;
	}
	public void setFriend(List<FriendGroupBean> friend) {
		this.friend = friend;
	}
	public List<GroupBean> getGroup() {
		return group;
	}
	public void setGroup(List<GroupBean> group) {
		this.group = group;
	}
	
	
}
