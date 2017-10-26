package com.itour.util.json;

public interface MsgCode {

    StatusCodeEnum getPreFixCode();
    String getMsg();
    String getExtCode();

    static enum StatusCodeEnum  {
        SUCCESS(200, "SUCCESS"),
        SERVER_ERROR(500, "SERVER_ERROR"),
        TIMEOUT(504, "TIMEOUT"),
        ILLEGAL_PARAM(400, "ILLEGAL_PARAM"),
        NOT_FOUND(404, "NOT_FOUND"),
        NO_RIGHT(416, "NO_RIGHT"),
        TOO_MANY_REQUESTS(429, "TOO_MANY_REQUESTS");
        //
        private int code;
        private String msg;

        private StatusCodeEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

    }
}
