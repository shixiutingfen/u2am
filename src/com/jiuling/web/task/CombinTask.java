package com.jiuling.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 分发任务task
 * 
 * @author Administrator
 *
 */
@Component
public class CombinTask {

	/**
	 * 判断分发子任务是否超时，超时则设置状态为TIMEOUT 当所有子任务都为超时状态时，则主流程表设置状态为TIMEOUT 每5分钟跑一次
	 */
    @Scheduled(cron = "0 0/5 * * * ? ")
	public void taskOverTime() {
    	
	}

	
}
