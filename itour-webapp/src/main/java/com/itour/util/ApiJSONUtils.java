package com.itour.util;

import com.alibaba.fastjson.JSON;
import com.intellij.openapi.graph.util.Maps;
import com.itour.MsgCode;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiJSONUtils {
    public ApiJSONUtils() {
    }

    public abstract CenterCodeEnum getCenterCodeEnum();

    public String success(Object data) {
        return this.buildSuccess(data);
    }

    public String success() {
        return this.buildSuccess((Object)null);
    }

    public String failed() {
        return this.buildFailed(DefaultMsgCodeEnum.SERVER_ERROR, (String)null, (Object)null);
    }

    public String failed(String msg) {
        return this.buildFailed(DefaultMsgCodeEnum.SERVER_ERROR, msg, (Object)null);
    }

    public String failed(MsgCode code, String msg) {
        return this.buildFailed(code, msg, (Object)null);
    }

    public String failed(MsgCode code, String msg, Object data) {
        return this.buildFailed(code, msg, data);
    }

    private String buildSuccess(Object data) {
        Map<String, Object> res = new HashMap<>();
        res.put("succ", true);
        res.put("code", MsgCodeBuilder.buildCode(DefaultMsgCodeEnum.SUCCESS, this.getCenterCodeEnum()));
        res.put("timestamp", this.getCurrentSecond());
        res.put("data", data);
        res.put("msg", "");
        return JSON.toJSONString(res);
    }

    private String buildFailed(MsgCode code, String msg, Object data) {
        Map<String, Object> res = new HashMap<>();
        res.put("succ", false);
        res.put("code", MsgCodeBuilder.buildCode(code, this.getCenterCodeEnum()));
        res.put("timestamp", this.getCurrentSecond());
        res.put("msg", StringUtils.defaultIfBlank(msg, code.getMsg()));
        res.put("data", data);
        return JSON.toJSONString(res);
    }

    public int getCurrentSecond() {
        return (int)(System.currentTimeMillis() / 1000L);
    }
}
