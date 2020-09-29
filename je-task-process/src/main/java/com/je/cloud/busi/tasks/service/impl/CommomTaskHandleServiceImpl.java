package com.je.cloud.busi.tasks.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.je.cloud.base.utils.UUIDUtils;
import com.je.cloud.busi.tasks.domain.entity.TRuntimeProcess;
import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.vo.TProcessInfoVo;
import com.je.cloud.busi.tasks.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommomTaskHandleServiceImpl implements CommomTaskHandleService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TRuntimeProcessService tRuntimeProcessService;
    @Resource
    private TTaskService tTaskService;

    @Resource
    private CommonCallProcessService commonCallProcessService;

    @Resource
    private TaskInsService insService;

    @Async
    @Override
    public void execute(TTask e) {
        String json = e.getProcessList();
        List<TProcessInfoVo> ps = new Gson().fromJson(json, new TypeToken<List<TProcessInfoVo>>() {
        }.getType());
        int currentTaskOrder = e.getCurrentTaskOrder();
        TProcessInfoVo p = ps.get(currentTaskOrder);
        TRuntimeProcess run = tRuntimeProcessService.findById(p.getRunId());
        if ("1".equals(run.getStatus())) {
            // run状态为1时 为任务正在执行
            return;
        }
        // 判断当前执行的process状态
        // 2为执行成功
        log.info("-------------> 任务:{} 子任务:{} order:{}--> 运行状态:{}", e.getName(), p.getProcessName(), currentTaskOrder + 1, run.getStatus());
        p.setStatus(run.getStatus());
        e.setUpdateTime(new Date());
        int nextOrder = currentTaskOrder + 1;
        if (StringUtils.equals("2", run.getStatus())) {
            //判断任务是否还有任务
            if (ps.size() > nextOrder) {
                // 执行下一个任务
                log.info("-------------> 任务:{} --> 执行下一个子任务:{}", e.getName(), ps.get(nextOrder).getProcessName());
                runNextTask(e, ps, nextOrder);
            } else if (ps.size() == nextOrder) {
                // 执行完毕
                log.info("-------------> 任务:{} --> 执行完毕", e.getName());
                e.setStatus("2");
                e.setEndTime(new Date());
                insService.addHistory(e);
            }
            e.setProcessList(new Gson().toJson(ps));
        } else if (StringUtils.equals("3", run.getStatus())) {
            // process 执行失败
            // 跳过
            if (StringUtils.equals("2", p.getAfterFail())) {
                log.info("-------------> 任务:{} 子任务:{} --> 执行失败 -- 跳过", e.getName(), p.getProcessName());
//                log.info("-------------> processName:" + p.getProcessName() + "失败跳过");
                if (ps.size() > nextOrder) {
                    // 执行下一个任务
                    log.info("-------------> 任务:{} --> 执行下一个子任务:{}", e.getName(), ps.get(nextOrder).getProcessName());
                    runNextTask(e, ps, nextOrder);
                } else if (ps.size() == nextOrder) {
                    // 执行完毕
                    log.info("-------------> 任务:{} --> 执行完毕", e.getName());
                    e.setStatus("2");
                    e.setEndTime(new Date());
                    insService.addHistory(e);
                } else {

                }
            } else if (StringUtils.equals("1", p.getAfterFail())) {
//                log.info("-------------> processName:" + p.getProcessName() + "失败重试");
                log.info("-------------> 任务:{} --> 子任务{} 执行失败 --> 终止", e.getName(), p.getProcessName());
                e.setStatus("3");
            } else {
                // 重试
                log.info("-------------> 任务:{} --> 子任务{} 执行失败 --> 重试", e.getName(), p.getProcessName());
                reTryTask(e, ps, currentTaskOrder);
            }
        }
        e.setProcessList(new Gson().toJson(ps));
        tTaskService.update(e);
    }

    private void reTryTask(TTask e, List<TProcessInfoVo> ps, int currentTaskOrder) {
        TProcessInfoVo process = ps.get(currentTaskOrder);
        runTask(e, process, "try");
    }

    private void runNextTask(TTask e, List<TProcessInfoVo> ps, int nextOrder) {
        runTask(e, ps.get(nextOrder), "run");
        e.setCurrentTaskOrder(nextOrder);
    }

    private void runTask(TTask tTask, TProcessInfoVo process, String runType) {
        TRuntimeProcess model = new TRuntimeProcess();
        model.setTaskId(tTask.getId());
        model.setId(UUIDUtils.getId());
        model.setTaskName(process.getName());
        model.setProcessId(process.getId());
        model.setProcessName(process.getProcessName());
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        model.setRunType(runType);
        model.setRunVersion(tTask.getRunVersion());
        tRuntimeProcessService.save(model);
        commonCallProcessService.callProcess(tTask, process.getProcessName(), model.getId());
        process.setRunId(model.getId());
        process.setStatus("1");
    }
}
