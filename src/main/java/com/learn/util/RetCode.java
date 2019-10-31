package com.learn.util;

public enum RetCode {

    SUCCESS(200),

    NOT_FOUND(404),

    ERROR(500);

    private int code;

    RetCode(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
