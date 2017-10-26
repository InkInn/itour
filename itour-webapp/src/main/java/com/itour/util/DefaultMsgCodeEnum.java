package com.itour.util;

import com.itour.MsgCode;

public class DefaultMsgCodeEnum implements MsgCode {
    SUCCESS(Sta,"SUCCESS"),

    SUCCESS(StatusCodeEnum., "SUCCESS"),
    SERVER_ERROR(StatusCodeEnum.SERVER_ERROR, "SERVER_ERROR"),
    TIMEOUT(StatusCodeEnum.TIMEOUT, "TIMEOUT"),
    ILLEGAL_PARAM(StatusCodeEnum.ILLEGAL_PARAM, "ILLEGAL_PARAM"),
    NOT_FOUND(StatusCodeEnum.NOT_FOUND, "NOT_FOUND"),
    NO_RIGHT(StatusCodeEnum.NO_RIGHT, "NO_RIGHT"),
    TOO_MANY_REQUESTS(StatusCodeEnum.TOO_MANY_REQUESTS, "TOO_MANY_REQUESTS");

    private StatusCodeEnum code;
    private String extCode;
    private String msg;

    private DefaultMsgCodeEnum(StatusCodeEnum code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public StatusCodeEnum getPreFixCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getExtCode() {
        return this.extCode;
    }
}
