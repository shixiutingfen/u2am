package com.jiuling.web.enums;

import org.springframework.web.servlet.support.RequestContext;

public enum TaskStatus {
	WAIT((byte)1, "等待处理", "dic.taskstatus.wait"),
	PROCESS((byte)2, "处理中", "dic.taskstatus.process"),
	SUCCESS((byte)3, "处理成功", "dic.taskstatus.success"),
	FAIL((byte)4, "处理失败", "dic.taskstatus.fail");
 
	public byte value;
	public String desc;
	public String label;
	
	private TaskStatus(byte value, String desc, String label) {
		this.value = value;
		this.desc = desc;
		this.label = label;
	}
	
	public void setDesc(byte value, String desc) {
		for(TaskStatus type: TaskStatus.values()) {
			if(type.value == value) {
				type.desc = desc;
				break;
			}
		}
	}
	
	public static TaskStatus get(byte value) {
		for(TaskStatus type: TaskStatus.values()) {
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
