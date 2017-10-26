package com.itour.util;

import com.itour.MsgCode;

public class MsgCodeBuilder {
    public MsgCodeBuilder() {
    }

    public static String buildCode(MsgCode msgCode, CenterCodeEnum centerCodeEnum) {
        if (msgCode.getPreFixCode() == null) {
            throw new RuntimeException("msgCode.getPreFixCode is null");
        } else {
            return msgCode.getPreFixCode().getCode() + centerCodeEnum.getCode() + (msgCode.getExtCode() != null && !msgCode.getExtCode().equals("") ? msgCode.getExtCode() : "");
        }
    }
}
