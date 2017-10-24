package com.itour.util.json;

public enum DefaultMsgCodeEnum implements MsgCode{

    SUCCESS(StatusCodeEnum.SUCCESS, "SUCCESS"),
    SERVER_ERROR(StatusCodeEnum.SERVER_ERROR, "SERVER_ERROR"), //该code会使得客户端直接报警，只有确定需要客户端报警的情况下使用
    TIMEOUT(StatusCodeEnum.TIMEOUT, "TIMEOUT"),
    ILLEGAL_PARAM(StatusCodeEnum.ILLEGAL_PARAM, "ILLEGAL_PARAM"),
    NOT_FOUND(StatusCodeEnum.NOT_FOUND, "NOT_FOUND"),
    NO_RIGHT(StatusCodeEnum.NO_RIGHT, "NO_RIGHT"),
    TOO_MANY_REQUESTS(StatusCodeEnum.TOO_MANY_REQUESTS, "TOO_MANY_REQUESTS");
    //

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
        return msg;
    }

    public String getExtCode() {
        return extCode;
    }
}
