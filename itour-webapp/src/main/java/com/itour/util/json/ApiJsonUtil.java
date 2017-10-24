package com.itour.util.json;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public abstract class ApiJsonUtil {

    public abstract CenterCodeEnum getCenterCodeEnum();

    public String success(Object data) {
        return buildSuccess(data);
    }

    public String success() {
        return buildSuccess(null);
    }

    public String failed() {
        return buildFailed(DefaultMsgCodeEnum.SERVER_ERROR, null, null);
    }

    public String failed(String msg) {
        return buildFailed(DefaultMsgCodeEnum.SERVER_ERROR, msg, null);
    }

    public String failed(MsgCode code, String msg) {
        return buildFailed(code, msg, null);
    }

    public String failed(MsgCode code, String msg, Object data) {
        return buildFailed(code, msg, data);
    }

    private String buildSuccess(Object data) {
        Map<String, Object> res = Maps.newHashMap();
        res.put("succ", true);
        res.put("code", MsgCodeBuilder.buildCode(DefaultMsgCodeEnum.SUCCESS, getCenterCodeEnum()));
        res.put("timestamp", getCurrentSecond());
        res.put("data", data);
        res.put("msg", StringUtils.EMPTY);
        return JSON.toJSONString(res);
    }

    private String buildFailed(MsgCode code, String msg, Object data) {
        Map<String, Object> res = Maps.newHashMap();
        res.put("succ", false);
        res.put("code", MsgCodeBuilder.buildCode(code, getCenterCodeEnum()));
        res.put("timestamp", getCurrentSecond());
        res.put("msg", StringUtils.defaultIfBlank(msg, code.getMsg()));
        res.put("data", data);
        return JSON.toJSONString(res);
    }

    public int getCurrentSecond() {
        return (int) (System.currentTimeMillis() / 1000L);
    }
}
