package com.je.cloud.quartz.service;

import com.je.cloud.quartz.entity.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;
import java.util.Map;


public interface TaskService {

    TaskInfo get(String id);

    /**
     * 获取任务列表
     *
     * @param param
     * @return
     */
    List<TaskInfo> list(Map<String, Object> param);

    /**
     * 新增任务信息
     *
     * @param taskScheduleJob
     * @return
     */
    int save(TaskInfo taskScheduleJob);

    /**
     * 更新任务
     *
     * @param taskScheduleJob
     * @return
     */
    int update(TaskInfo taskScheduleJob);

    /**
     * 根据id删除任务
     *
     * @param id
     * @return
     */
    int remove(String id);

    int removeBatch(String[] ids);

    void initSchedule() throws SchedulerException;

    void changeStatus(String jobId, String jobStatus) throws SchedulerException;

    void updateCron(String jobId) throws SchedulerException;

    void run(TaskInfo scheduleJob) throws SchedulerException;

    void run(String id) throws SchedulerException;
}
