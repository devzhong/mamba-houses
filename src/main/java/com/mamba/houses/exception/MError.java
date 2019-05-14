package com.mamba.houses.exception;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/5 16:34
 */
public enum MError implements IError {
    SYSTEM_INTERNAL_ERROR("0000", "System Internal Error"),
    PAGER_PARAMETER_IS_NOT_CORRECT("0003", "pager parameter is not correct");

    String errorCode;
    String errorMessage;
    private static final String ns = "SYS";

    private MError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getNamespace() {
        return "SYS";
    }

    public String getErrorCode() {
        return "SYS." + this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
