package com.jiuling.web.enums;

import org.springframework.web.servlet.support.RequestContext;

public enum LogType {
	MODULE((byte)1, "菜单", "dic.logtype.module"),
	CAMERA((byte)2, "点位", "dic.logtype.camera"),
	VIDEO((byte)3, "视频", "dic.logtype.video"),
	CASE((byte)4, "案件", "dic.logtype.case"),
	CLUE((byte)5, "线索", "dic.logtype.clue"),
	LOGIN((byte)6, "上次登录时间", "dic.logtype.login");
 
	public byte value;
	public String desc;
	public String label;
	
	private LogType(byte value, String desc, String label) {
		this.value = value;
		this.desc = desc;
		this.label = label;
	}
	
	public void setDesc(byte value, String desc) {
		for(LogType type: LogType.values()) {
			if(type.value == value) {
				type.desc = desc;
				break;
			}
		}
	}
	
	public static LogType get(byte value) {
		for(LogType type: LogType.values()) {
			if(type.value == value) {
				return type;
			}
		}
		return null;
	}	
	
	public String getDesc(RequestContext context) {
		return context.getMessage(label, desc);
	}	
}
