package com.prosay.quratz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.prosay.job.Job01;

public class test02_will {
	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();  
    
    @SuppressWarnings("unchecked")  
    public static void addJob(String jobName, Class cls, String time) {  
        try {  
		//123123213321213
        	//触发器
            Scheduler sched = gSchedulerFactory.getScheduler();  
            System.out.println("阿斯顿撒");
            //任务
            JobDetail jobDetail = JobBuilder
            		.newJob(cls)
            		.withIdentity(jobName)
            		.build();
            
            //定义规则
            CronTrigger cronTrigger = (CronTrigger) TriggerBuilder
            		.newTrigger()
            		.withIdentity("tri01")
            		.withSchedule(
            				CronScheduleBuilder.cronSchedule(time)
            				).startNow().build();
            	
            //添加任务和规则
            sched.scheduleJob(jobDetail, cronTrigger);
            
            // 启动  
            if (!sched.isShutdown()) {  
                sched.start();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }
}
