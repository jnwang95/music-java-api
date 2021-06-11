package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 检测手机号码是否已注册
 */
@Service
public class CellphoneExistenceCheck implements BaseModuleEApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("cellphone",queryMap.get("phone"));
        object.set("countrycode",queryMap.get("countrycode"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/eapi/cellphone/existence/check";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/cellphone/existence/check";
    }
}
