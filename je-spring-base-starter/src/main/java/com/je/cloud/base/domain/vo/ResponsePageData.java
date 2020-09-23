package com.je.cloud.base.domain.vo;

import io.swagger.annotations.ApiModelProperty;

public class ResponsePageData {
    @ApiModelProperty("数据总数")
    private long totalCount;

    public ResponsePageData() {
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
