package com.jiuling.web.enums;

import org.springframework.web.servlet.support.RequestContext;

public enum CameraMediaType {
	IMG((byte)1, "图片", "dic.cameramediatype.img"),
	VIDEO((byte)2, "视频", "dic.cameramediatype.video");
 
	public byte value;
	public String desc;
	public String label;
	
	private CameraMediaType(byte value, String desc, String label) {
		this.value = value;
		this.desc = desc;
		this.label = label;
	}
	
	public void setDesc(byte value, String desc) {
		for(CameraMediaType type: CameraMediaType.values()) {
			if(type.value == value) {
				type.desc = desc;
				break;
			}
		}
	}
	
	public static CameraMediaType get(byte value) {
		for(CameraMediaType type: CameraMediaType.values()) {
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
