package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TTask;

public interface CommonCallProcessService {
    void callProcess(TTask tTask, String processName, String runId);
}
