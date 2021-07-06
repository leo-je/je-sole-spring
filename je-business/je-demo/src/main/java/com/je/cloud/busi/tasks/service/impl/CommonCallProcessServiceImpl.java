package com.je.cloud.busi.tasks.service.impl;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.mapper.CommTaskMapper;
import com.je.cloud.busi.tasks.service.CommonCallProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CommonCallProcessServiceImpl implements CommonCallProcessService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CommTaskMapper commTaskMapper;

    @Async
    @Override
    public void callProcess(TTask e, String processName, String runId) {
        log.info("-------------> 任务:{} --> 运行子任务:{}", e.getName(), processName);
        int i = commTaskMapper.callProcess(processName, runId);
        log.info("-------------> 任务:{} --> 子任务:{} --> 运行结果:{}", e.getName(), processName, i);
    }
}
