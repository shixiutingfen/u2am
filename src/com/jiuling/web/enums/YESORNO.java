package com.jiuling.web.enums;

import org.springframework.web.servlet.support.RequestContext;

public enum YESORNO {
	YES((byte)1, "是", "dic.yesorno.yes"),
	NO((byte)0, "否", "dic.yesorno.no");
 
	public byte value;
	public String desc;
	public String label;
	
	private YESORNO(byte value, String desc, String label) {
		this.value = value;
		this.desc = desc;
		this.label = label;
	}
	
	public void setDesc(byte value, String desc) {
		for(YESORNO type: YESORNO.values()) {
			if(type.value == value) {
				type.desc = desc;
				break;
			}
		}
	}
	
	public static YESORNO get(byte value) {
		for(YESORNO type: YESORNO.values()) {
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
