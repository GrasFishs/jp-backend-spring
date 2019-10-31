package com.learn.util;

public class Response<T> {

    private int code;

    private String msg;

    private T data;

    public Response() {
        this.code = RetCode.SUCCESS.getCode();
        this.msg = "";
        this.data = null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(RetCode code) {
        this.code = code.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
