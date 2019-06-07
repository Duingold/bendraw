package com.lvtuben.bendraw.exception;

/**
 * @Description:自定义异常
 * @author: Bryce
 * @date: 2019/6/3
 * @version: 1.0
 */
public class RRException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    private int code = 500;

    private  Boolean  success=false;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public RRException(String msg) {
        super(msg);
        this.msg = msg;

    }
    public RRException(String msg,Integer errCode) {
        super(msg);
        this.msg = msg;
        this.code=errCode;
    }
    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}