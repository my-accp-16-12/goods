package com.prosay.quratz;

import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class test04MyGroup {

	//自定义任务调度
	// 1.明白组的概念
	// 任务组  Job Group
	// 规则组  Trigger Group
	
	//调度器
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	//任务组
	private static String My_Job_Group = "My_Job_Group";
	
	//规则组
	private static String My_Trigger_Group = "My_Trigger_Group";
	
	public static void addJob(){
		
	}
}
