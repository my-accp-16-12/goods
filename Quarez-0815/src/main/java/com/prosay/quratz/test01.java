package com.prosay.quratz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import com.prosay.job.Job01;

public class test01 {
	
	public static void main(String[] args) throws SchedulerException {
		//创建调度器
		StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
		
		
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		//创建一个Job
		JobDetail detail = JobBuilder.newJob(Job01.class).withIdentity("Job01").build();
		
		//定义时间规则，并设置启动时间
		CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("trigger01")
				.withSchedule(
						//年 星期 月 日 时 分 秒
						//CronScheduleBuilder.cronSchedule("0/2 * * * * ? *")
						SimpleScheduleBuilder		//
						.simpleSchedule()			// 循环次数无限次
													//.withRepeatCount(5)
						.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
						.withIntervalInSeconds(2)	//间隔两秒钟一次,
						
						)
						.startNow()
						.build();
		
		scheduler.scheduleJob(detail, cronTrigger);
		
		//撒旦
		//启动
		scheduler.start();
		
		//停止
		//scheduler.shutdown();
	}
}
