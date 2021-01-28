package com.je.cloud.base.controller;

import com.je.cloud.base.domain.vo.ResponseData;
import com.je.cloud.base.domain.vo.ResponseDataBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    private transient Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseController() {
    }

    public <T> ResponseData<T> buildResponseData(ResponseDataBuilder<T> responseDataBuilder, String operate, int... pageInfo) {
        return responseDataBuilder.build(operate, pageInfo);
    }

//    public <T> ResponseData<T> transferResponseData(ResponseDataTransfer<T> responseDataTransfer, String operate) {
//        return responseDataTransfer.transfer(operate);
//    }
}
