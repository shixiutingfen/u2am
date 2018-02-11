package com.jiuling.web.enums;

import org.springframework.web.servlet.support.RequestContext;

public enum ChatMessageType {
	WORD((byte)0, "文本", "dic.chatmessagetype.word"),
	IMAGE((byte)1, "图片", "dic.chatmessagetype.img"),
	FILE((byte)2, "文件", "dic.chatmessagetype.file"),
	VIDEO((byte)3, "视频", "dic.chatmessagetype.video"),;
 
	public byte value;
	public String desc;
	public String label;
	
	private ChatMessageType(byte value, String desc, String label) {
		this.value = value;
		this.desc = desc;
		this.label = label;
	}
	
	public void setDesc(byte value, String desc) {
		for(ChatMessageType type: ChatMessageType.values()) {
			if(type.value == value) {
				type.desc = desc;
				break;
			}
		}
	}
	
	public static ChatMessageType get(byte value) {
		for(ChatMessageType type: ChatMessageType.values()) {
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
