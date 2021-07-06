package com.je.cloud.base.exception;

import com.je.cloud.base.domain.enums.ExceptionCodeEnum;

public class ApplicationException extends RuntimeException {
    private String code;
    private String msg;

    public ApplicationException() {
        this.code = ExceptionCodeEnum.APPLICATION.getCode();
    }

    public ApplicationException(String message) {
        super(message);
        this.code = ExceptionCodeEnum.APPLICATION.getCode();
        this.msg = message;
    }

    public ApplicationException(String code, String message) {
        super(message);
        this.code = ExceptionCodeEnum.APPLICATION.getCode();
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
