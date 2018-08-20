package com.prosay.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//每一个任务调度都需要 执行 Job
public class Job01 implements Job{
	
	//导入slf4j的Logger jar
	private static Logger _log = LoggerFactory.getLogger(Job01.class);

	//重写这个方法
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("无敌的人啊!");
	}
}
