package com.mamba.houses.exception;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/5 14:14
 */
public enum ServiceError implements IError {

    UM_SERVICE_ERROR("9999", "内部服务错误"),
    BROKER_NAME_NULL("1000","姓名不能为空"),
    BROKER_NOT_FOUND("1001", "未找到相应的经纪人"),
    BROKER_UUI_NULL("1002","uuid不能为空");

    String errorCode;
    String errorMessage;
    private static final String ns = "USER_MANAGE";

    ServiceError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String getNamespace() {
        return ns;
    }

    @Override
    public String getErrorCode() {
        return ns + "_" + errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
