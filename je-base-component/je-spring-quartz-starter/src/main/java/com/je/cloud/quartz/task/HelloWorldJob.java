package com.je.cloud.quartz.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution //作业不并发
@Component
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) {

        System.out.println("HelloWorldJob");

    }

}
