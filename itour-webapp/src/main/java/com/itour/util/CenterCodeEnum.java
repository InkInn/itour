package com.itour.util;

public enum CenterCodeEnum {
    PHOTO_CENTER("001"),
    TAG_CENTER("002"),
    WALLET_CENTER("003"),
    BRAND_CENTER("004"),
    INPET_CENTER("005");

    private String code;

    private CenterCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
