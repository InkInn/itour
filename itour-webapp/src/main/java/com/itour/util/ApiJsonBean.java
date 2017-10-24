package com.itour.util;

import com.itour.util.json.ApiJsonUtil;
import com.itour.util.json.CenterCodeEnum;
import org.springframework.stereotype.Component;

@Component("apiJson")
public class ApiJsonBean extends ApiJsonUtil{
    @Override
    public CenterCodeEnum getCenterCodeEnum() {
        return CenterCodeEnum.ITOUR_CENTER;
    }
}
