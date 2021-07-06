package com.je.cloud.busi.tasks.scheduler;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.entity.TTaskExample;
import com.je.cloud.busi.tasks.service.CommomTaskHandleService;
import com.je.cloud.busi.tasks.service.TTaskService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@DisallowConcurrentExecution //作业不并发
@Component
public class TaskCommJob implements Job {

    @Resource
    private TTaskService tTaskService;

    @Resource
    private CommomTaskHandleService commomTaskHandleService;



    @Override
    public void execute(JobExecutionContext arg0) {
        // todo：加锁
        // 1。获取状态为1的任务
        TTaskExample exa = new TTaskExample();
        exa.createCriteria().andStatusEqualTo("1");
        List<TTask> list = tTaskService.findByExample(exa);
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(e -> {
                commomTaskHandleService.execute(e);
            });
        }
    }





}
