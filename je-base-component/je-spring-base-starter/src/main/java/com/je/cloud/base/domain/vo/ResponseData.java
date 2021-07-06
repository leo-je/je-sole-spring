package com.je.cloud.base.domain.vo;


import com.je.cloud.base.domain.enums.ExceptionCodeEnum;
import com.je.cloud.base.exception.ApplicationException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

@ApiModel("请求统一返回数据")
public class ResponseData<T> {
    private static final String SUCCESS;
    @ApiModelProperty("请求会返回码：成功返回0000，失败返回负整数")
    private String code;
    @ApiModelProperty("请求返回消息")
    private String codeMsg;
    @ApiModelProperty("请求返回数据，返回任意类型的对象或数组（对象为空时不返回该字段，数组为空返回0长度的数组）")
    private T data;
    @ApiModelProperty("分页请求信息")
    private ResponsePageData page;
    @ApiModelProperty("操作")
    private String operate;

    public ResponseData() {
        this.code = SUCCESS;
    }

    public static <T> ResponseData<T> fail(Throwable throwable) {
        ResponseData<T> responseData = new ResponseData();
        if (throwable instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) throwable;
            responseData.setCode(applicationException.getCode());
        } else {
            responseData.setCode(ExceptionCodeEnum.SYSTEM.getCode());
        }

        responseData.setCodeMsg(throwable.getMessage());
        return responseData;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return this.codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponsePageData getPage() {
        return this.page;
    }

    public void setPage(ResponsePageData page) {
        this.page = page;
    }

    public boolean isSuccess() {
        return StringUtils.equals(this.code, SUCCESS);
    }

    public String getOperate() {
        return this.operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    static {
        SUCCESS = ExceptionCodeEnum.NONE.getCode();
    }
}
