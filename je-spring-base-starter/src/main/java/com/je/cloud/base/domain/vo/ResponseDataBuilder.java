package com.je.cloud.base.domain.vo;

import com.github.pagehelper.Page;
import com.je.cloud.base.domain.enums.ExceptionCodeEnum;
import com.je.cloud.base.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@FunctionalInterface
public interface ResponseDataBuilder<T> {
    Logger logger = LoggerFactory.getLogger(ResponseDataBuilder.class);

    T invokeData();

    default ResponseData<T> build(String operate, int... pageInfo) {
        ResponseData<T> responseData = new ResponseData();
        responseData.setOperate(operate);

        try {
            T t = this.invokeData();
            if (t == null) {
                responseData.setCodeMsg(operate + " success");
                return responseData;
            }

            Class pageClass = null;

            try {
                pageClass = Class.forName("com.github.pagehelper.Page");
            } catch (ClassNotFoundException var10) {
                logger.warn(var10.getMessage());
            }

            if (pageClass != null && t instanceof Page) {
                Page page = (Page)t;
                ResponsePageData pageData = new ResponsePageData();
                pageData.setTotalCount(page.getTotal());
                responseData.setPage(pageData);
            } else if (t instanceof List && pageInfo.length > 1) {
                int limit = pageInfo[1];
                int offset = (pageInfo[0] - 1) * pageInfo[1];
                List list = (List)t;
                ResponsePageData pageData = new ResponsePageData();
                pageData.setTotalCount(list.size());
                responseData.setPage(pageData);
                if (limit > 0 || offset < list.size()) {
                    list = list.subList(offset, offset + limit > list.size() ? list.size() : offset + limit);
                }

                t = (T) list;
            }

            responseData.setData(t);
            responseData.setCodeMsg(operate +" success");
        } catch (ApplicationException var11) {
            logger.error(operate + "失败：" + var11.getMessage(), var11);
            responseData.setCode(var11.getCode());
            responseData.setCodeMsg(operate + " fail" + ": " + var11.getMessage());
        } catch (Exception var12) {
            logger.error(operate + "失败：" + var12.getMessage(), var12);
            responseData.setCode(ExceptionCodeEnum.SYSTEM.getCode());
            responseData.setCodeMsg(operate + " error" + "!");
        }

        return responseData;
    }


}
