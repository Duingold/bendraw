package com.lvtuben.bendraw.response;

import java.io.Serializable;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/3
 * @version: 1.0
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -8869835046694241883L;
    private Boolean success = false;
    private String code = "-1";
    private String msg = "错误";

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public BaseResponse() {
    }

    public BaseResponse(Boolean b) {
        this.success = b;
    }

    public BaseResponse(String msg, Boolean success) {
        this.msg = msg;
    }

    public BaseResponse(Boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public BaseResponse(Boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
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
