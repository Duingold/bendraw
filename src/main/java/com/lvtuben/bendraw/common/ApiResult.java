package com.lvtuben.bendraw.common;

import java.io.Serializable;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/12
 * @version: 1.0
 */
public class ApiResult<T> implements Serializable {


    private static final long serialVersionUID = -8869835046694241883L;

    private Boolean isSuccess = false;

    private String code;

    private String msg;

    private T data;

    public ApiResult() {
    }

    public ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    public ApiResult(String code, T t) {
        this.code = code;
        this.data = t;
    }


    public T getT() {
        return data;
    }

    public void setT(T t) {
        this.data = t;
    }


    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T isSuccess() {
        this.isSuccess = true;
        return this.getT();
    }

    public T errow(String msg) {
        this.isSuccess = true;
        this.msg = msg;
        return this.getT();
    }

}
