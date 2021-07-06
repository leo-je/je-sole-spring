package com.je.cloud.base.handle;

import com.je.cloud.base.domain.vo.ResponseData;
import com.je.cloud.base.exception.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ApplicationExceptionHandle {

    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseBody
    public ResponseData<?> applicationException(HttpServletResponse response, ApplicationException e) {
        ResponseData<?> responseData = new ResponseData();
        responseData.setCode("-9999");
        responseData.setCodeMsg(e.getLocalizedMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return responseData;
    }
}
