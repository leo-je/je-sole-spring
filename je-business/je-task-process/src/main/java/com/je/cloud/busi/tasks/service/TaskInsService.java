package com.je.cloud.busi.tasks.service;

import com.je.cloud.busi.tasks.domain.entity.TTask;
import com.je.cloud.busi.tasks.domain.vo.TTaskVo;

import java.util.List;

public interface TaskInsService {
    void add(TTaskVo vo);

    void reStartTask(String id);

    void addHistory(TTask e);

    void startTask(String id);

    void startTask(TTask e);

    List<TTask> taskList();
}
