package com.je.cloud.quartz.listener;

import com.je.cloud.quartz.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 1)

public class ScheduleJobInitListener implements CommandLineRunner {


    @Autowired
    TaskService scheduleJobService;

    @Override


    public void run(String... arg0) {
        try {
            scheduleJobService.initSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}