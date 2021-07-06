package com.je.cloud.base.domain.enums;

import org.apache.commons.lang3.StringUtils;

public enum ExceptionCodeEnum {
    NONE("0000", "无异常"),
    SYSTEM("-1", "业务异常"),
    APPLICATION("-9999", "业务异常"),
    DATE_TRANS("-9998", "日期转换异常"),
    CIRCUIT_BREAKER("-9997", "熔断"),
    Token_TIMEOUT("-9996", "token超时");

    private String code;
    private String desc;

    private ExceptionCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getCode() {
        return this.code;
    }

    public static ExceptionCodeEnum getByCode(String code) {
        ExceptionCodeEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ExceptionCodeEnum em = var1[var3];
            if (StringUtils.equals(em.getCode(), code)) {
                return em;
            }
        }

        return null;
    }
}
