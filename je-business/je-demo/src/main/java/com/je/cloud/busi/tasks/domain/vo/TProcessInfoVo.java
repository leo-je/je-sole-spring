package com.je.cloud.busi.tasks.domain.vo;

import com.je.cloud.busi.tasks.domain.entity.TProcessInfo;

public class TProcessInfoVo extends TProcessInfo {

    private int order;
    private String status;
    private String runId;
    private String afterFail; //失败chul 1- 停止 2-跳过 3-重试

    public String getAfterFail() {
        return afterFail;
    }

    public void setAfterFail(String afterFail) {
        this.afterFail = afterFail;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
