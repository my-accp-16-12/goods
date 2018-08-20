package com.prosay.quratz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.prosay.job.Job01;

public class test03 {
	public static void main(String[] args) throws SchedulerException {
		//调度器
		StdSchedulerFactory schedulerFactory= new StdSchedulerFactory();
		
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		//规则
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger01")
				.withSchedule(
						SimpleScheduleBuilder
						.simpleSchedule()
						.withRepeatCount(-1)
						.withIntervalInSeconds(2)
						)
				.startNow()
				.build();
		
		
		
		//任务
		JobDetail jobDetail = JobBuilder
		.newJob(Job01.class)
		.withIdentity("job01")
		.build();
		
		//将任务和规则一起使用
		scheduler.scheduleJob(jobDetail, trigger);
		
		
		
		//启动
		scheduler.start();
		
		//不需要关闭
	}
}
