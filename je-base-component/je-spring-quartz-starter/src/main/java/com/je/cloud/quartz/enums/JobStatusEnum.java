package com.je.cloud.quartz.enums;

public enum JobStatusEnum {

    /**
     * 0=停止
     */
    STOP("0", "停止"),
    /**
     * 1=运行
     */
    RUN("1", "运行");

    private String value = null;
    private String code = null;

    JobStatusEnum(String _code, String _value) {
        this.value = _value;
        this.code = _code;
    }

    public static JobStatusEnum getEnumByKey(String key) {
        for (JobStatusEnum e : JobStatusEnum.values()) {
            if (e.getCode().equals(key)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 获取value
     */
    public String getValue() {
        return value;
    }

    /**
     * 获取code
     */
    public String getCode() {
        return code;
    }
}
