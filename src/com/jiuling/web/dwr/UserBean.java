package com.jiuling.web.dwr;

/**
 * 用户bean
 * @author fanxiaoming
 * 2017/07/08
 */
public class UserBean {
	private String code = "0";
	private String msg = "";
	private UserDataBean data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public UserDataBean getData() {
		return data;
	}
	public void setData(UserDataBean data) {
		this.data = data;
	}
	
}
