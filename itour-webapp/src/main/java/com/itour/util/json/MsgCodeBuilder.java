package com.itour.util.json;

public class MsgCodeBuilder {
    public static String buildCode(MsgCode msgCode, CenterCodeEnum centerCodeEnum) {
        if(msgCode.getPreFixCode() == null) {
            throw new RuntimeException("msgCode.getPreFixCode is null");
        }
        return String.valueOf(msgCode.getPreFixCode().getCode()) + centerCodeEnum.getCode() + ((msgCode.getExtCode() == null || msgCode.getExtCode().equals("")) ? "" : msgCode.getExtCode());
    }
}
