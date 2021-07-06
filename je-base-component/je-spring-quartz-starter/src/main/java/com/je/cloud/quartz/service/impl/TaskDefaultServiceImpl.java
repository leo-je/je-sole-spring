package com.je.cloud.quartz.service.impl;

import com.je.cloud.quartz.entity.TaskInfo;
import com.je.cloud.quartz.enums.JobStatusEnum;
import com.je.cloud.quartz.service.TaskService;
import com.je.cloud.quartz.utils.QuartzManager;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public abstract class TaskDefaultServiceImpl implements TaskService {


    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private QuartzManager quartzManager;


    @Override
    public abstract TaskInfo get(String id);

    /**
     * 获取任务列表
     *
     * @param param
     * @return
     */
    @Override
    public abstract List<TaskInfo> list(Map<String, Object> param);

    /**
     * 新增任务信息
     *
     * @param task
     * @return
     */
    @Override
    public abstract int save(TaskInfo task);

    /**
     * 更新任务
     *
     * @param taskScheduleJob
     * @return
     */
    @Override
    public abstract int update(TaskInfo taskScheduleJob);

    /**
     * 根据id删除任务
     *
     * @param id
     * @return
     */
    @Override
    public abstract int remove(String id);

    @Override
    public abstract int removeBatch(String[] ids);

    @Override
    public abstract void initSchedule();

    @Override
    public void changeStatus(String jobId, String jobStatus) throws SchedulerException {
        TaskInfo task = get(jobId);
        if (task == null) {
            return;
        }
        if (JobStatusEnum.STOP.getCode().equals(jobStatus)) {
            quartzManager.deleteJob(task);
            task.setJobStatus(JobStatusEnum.STOP.getCode());
        } else {
            task.setJobStatus(JobStatusEnum.RUN.getCode());
            quartzManager.addJob(task);
        }
        update(task);
    }

    @Override
    public void updateCron(String jobId) throws SchedulerException {
        TaskInfo task = get(jobId);
        if (task == null) {
            return;
        }
        if (JobStatusEnum.RUN.getCode().equals(task.getJobStatus())) {
            quartzManager.updateJobCron(task);
        }
        update(task);
    }

    @Override
    public void run(TaskInfo scheduleJob) throws SchedulerException {
        quartzManager.runJobNow(scheduleJob);
    }

    @Override
    public void run(String id) throws SchedulerException {
        TaskInfo scheduleJob = get(id);
        quartzManager.runJobNow(scheduleJob);
    }

}
