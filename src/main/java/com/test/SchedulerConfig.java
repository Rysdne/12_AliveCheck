package com.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableAsync
public class SchedulerConfig implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		ThreadPoolTaskScheduler tpts = new ThreadPoolTaskScheduler();
		tpts.setPoolSize(100);
		tpts.setThreadGroupName("AliveCheckPool");
		tpts.setThreadNamePrefix("alive-check-pool-");
		tpts.initialize();
		
		taskRegistrar.setTaskScheduler(tpts);
	}
}
