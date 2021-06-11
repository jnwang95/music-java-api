package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 国家编码列表
 */
@Service
public class CountriesCodeList implements BaseModuleEApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
    }

    @Override
    public String getUrl() {
        return "https://interface3.music.163.com/eapi/lbs/countries/v1";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/lbs/countries/v1";
    }
}
