package com.itour.util.json;

public enum CenterCodeEnum {
    PHOTO_CENTER("001"),
    ITOUR_CENTER("002");

    private String code;

    private CenterCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
