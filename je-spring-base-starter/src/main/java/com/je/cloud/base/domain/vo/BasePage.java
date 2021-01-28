package com.je.cloud.base.domain.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("分页查询对象")
public class BasePage implements Serializable {

    @ApiModelProperty("页码，从1开始，默认1")
    private Integer pageNum = 1;
    @ApiModelProperty("页面大小，默认20")
    private Integer pageSize = 20;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
