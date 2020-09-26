package com.je.cloud.busi.tasks.domain.vo;

import com.je.cloud.busi.tasks.domain.entity.TTask;

import java.util.List;

public class TTaskVo extends TTask {

    private List<TProcessInfoVo> processInfos;

    public List<TProcessInfoVo> getProcessInfos() {
        return processInfos;
    }

    public void setProcessInfos(List<TProcessInfoVo> processInfos) {
        this.processInfos = processInfos;
    }
}
