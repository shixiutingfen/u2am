package com.jiuling.web.dwr;

import java.io.Serializable;

public class MembersBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557221894229691498L;
	private String code = "0";
	private String msg = "";
	private MembersDataBean data;
	
	
	public MembersDataBean getData() {
		return data;
	}
	public void setData(MembersDataBean data) {
		this.data = data;
	}
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
}
