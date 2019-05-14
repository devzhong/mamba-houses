package com.mamba.houses.exception;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/5 13:21
 */
public interface IError {

    String getNamespace();

    String getErrorCode();

    String getErrorMessage();
}

