package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  默认搜索关键词
 */
@Service
public class SearchDefault implements BaseModuleEApi {
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

    }

    @Override
    public String getUrl() {
        return "https://interface3.music.163.com/eapi/search/defaultkeyword/get";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/search/defaultkeyword/get";
    }
}
