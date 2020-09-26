package com.je.cloud.busi.tasks.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.je.cloud.base.utils.UUIDUtils;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcess;
import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.entity.TTaskExample;
import com.je.cloud.busi.tasks.domain.entity.TaskHistory;
import com.je.cloud.busi.tasks.domain.vo.TProcessInfoVo;
import com.je.cloud.busi.tasks.domain.vo.TTaskVo;
import com.je.cloud.busi.tasks.mapper.CommTaskMapper;
import com.je.cloud.busi.tasks.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TaskInsServiceImpl implements TaskInsService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TTaskService taskService;

    @Resource
    private TRuntimeProcessService tRuntimeProcessService;

    @Override
    public void add(TTaskVo vo) {
        Date now = new Date();
        List<TProcessInfoVo> ps = vo.getProcessInfos();
        TProcessInfoVo p;
        for (int i = 0; i < ps.size(); i++) {
            p = ps.get(i);
            p.setOrder(i);
            p.setStatus("0"); // 未执行ß
        }
        String json = new Gson().toJson(ps);
        vo.setProcessList(json);
        vo.setStatus("0"); //未执行
        vo.setId(UUIDUtils.getId());
        vo.setCreateTime(now);
        vo.setUpdateTime(now);
        taskService.save(vo);
    }

    @Override
    public void reStartTask(String id) {
        TTask e = taskService.findById(id);
        log.info("-------------> 任务:{} --> 重新开始运行", e.getName());
        if (e == null) return;
        if (!StringUtils.equals("2", e.getStatus())
                && !StringUtils.equals("0", e.getStatus())) {
            addHistory(e);
        }
        startTask(e);
    }

    @Resource
    private TaskHistoryService taskHistoryService;

    @Override
    public void addHistory(TTask e) {
        TaskHistory history = new TaskHistory();
        BeanUtils.copyProperties(e, history);
        history.setId(UUIDUtils.getId());
        history.setTaskId(e.getId());
        taskHistoryService.save(history);
    }

    @Override
    public void startTask(String id) {
        TTask e = taskService.findById(id);
        startTask(e);
    }

    @Override
    public void startTask(TTask e) {
        switch (e.getType()) {
            case "1": //即时任务
                startImmediateTask(e);
                break;
            case "2": //周期任务
                System.out.println("2");
                break;
            case "3": //定时任务
                System.out.println("3");
                break;
        }
    }

    @Override
    public List<TTask> taskList() {
        TTaskExample exa = new TTaskExample();
        exa.createCriteria().andIdIsNotNull();
        exa.setOrderByClause(" create_time desc");
        return taskService.findByExample(exa);
    }

    @Resource
    private CommTaskMapper commTaskMapper;

    @Resource
    private CommonCallProcessService commonCallProcessService;

    private void startImmediateTask(TTask e) {
        log.info("-------------> 即时任务:{} --> 开始运行", e.getName());
        e.setStatus("1");
        e.setCurrentTaskOrder(0);
        e.setStartTime(new Date());
        // 创建版本号
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String version = "v." + dateTimeFormatter.format(LocalDateTime.now());
        e.setRunVersion(version);

        String json = e.getProcessList();
        List<TProcessInfoVo> ls = new Gson().fromJson(json, new TypeToken<List<TProcessInfoVo>>() {
        }.getType());
        // 将第一个任务添加到runtime 表
        TProcessInfoVo p = ls.get(0);
        TRuntimeProcess model = new TRuntimeProcess();
        model.setTaskId(e.getId());
        model.setId(UUIDUtils.getId());
        model.setTaskName(e.getName());
        model.setProcessId(p.getId());
        model.setProcessName(p.getProcessName());
        model.setRunVersion(version);
        model.setCreateTime(new Date());
        model.setRunType("run");
        tRuntimeProcessService.save(model);
        commonCallProcessService.callProcess(e, p.getProcessName(), model.getId());
        p.setRunId(model.getId());
        p.setStatus("1");
        e.setProcessList(new Gson().toJson(ls));
        taskService.update(e);
    }

}
