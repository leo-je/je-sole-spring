package com.je.cloud.busi.scheduler.service.impl;

import com.je.cloud.busi.scheduler.mapper.TaskInfoMapper;
import com.je.cloud.quartz.entity.TaskInfo;
import com.je.cloud.quartz.enums.JobStatusEnum;
import com.je.cloud.quartz.service.impl.TaskDefaultServiceImpl;
import com.je.cloud.quartz.utils.QuartzManager;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

//@Service
public class TaskServiceImpl extends TaskDefaultServiceImpl {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Autowired
    private QuartzManager quartzManager;


    @Override
    public TaskInfo get(String id) {
        return taskInfoMapper.selectById(id);
    }

    /**
     * 获取任务列表
     *
     * @param param
     * @return
     */
    @Override
    public List<TaskInfo> list(Map<String, Object> param) {
        return null;
    }

    /**
     * 新增任务信息
     *
     * @param task
     * @return
     */
    @Override
    public int save(TaskInfo task) {
        task.setJobStatus(JobStatusEnum.STOP.getCode());
        task.setCreateTime(new Date());
        task.setUpdateTime(new Date());
        return taskInfoMapper.save(task);
    }

    /**
     * 更新任务
     *
     * @param taskScheduleJob
     * @return
     */
    @Override
    public int update(TaskInfo taskScheduleJob) {
        return taskInfoMapper.update(taskScheduleJob);
    }

    /**
     * 根据id删除任务
     *
     * @param id
     * @return
     */
    @Override
    public int remove(String id) {
        try {
            TaskInfo task = get(id);
            quartzManager.deleteJob(task);
            return taskInfoMapper.delete(id);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int removeBatch(String[] ids) {
        for (String id : ids) {
            try {
                TaskInfo task = get(id);
                quartzManager.deleteJob(task);
            } catch (SchedulerException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return taskInfoMapper.removeBatch(ids);
    }

    @Override
    public void initSchedule() {
        log.info("-------------> initSchedule starting");
        // 这里获取任务信息数据
        List<TaskInfo> jobList = taskInfoMapper.list();
        for (TaskInfo task : jobList) {
            if (JobStatusEnum.RUN.getCode().equals(task.getJobStatus())) {
                log.info("-------------> start " +task.getJobName() + " ...");
                quartzManager.addJob(task);
                log.info("-------------> " +task.getJobName() + " has started");
            }
        }
    }
}
