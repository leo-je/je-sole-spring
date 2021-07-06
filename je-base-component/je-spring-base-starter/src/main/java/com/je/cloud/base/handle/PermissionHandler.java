package com.je.cloud.base.handle;


import com.je.cloud.base.domain.vo.ResponseData;
import com.je.cloud.base.exception.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class PermissionHandler {

    @ExceptionHandler(value = {AuthorizationException.class})
    @ResponseBody
    public ResponseData<?> authorizationException(HttpServletResponse response, AuthorizationException e) {
        ResponseData<?> responseData = new ResponseData();
        responseData.setCode("-9999");
        responseData.setCodeMsg(e.getLocalizedMessage());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return responseData;
    }
}
