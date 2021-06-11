package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 初始化昵称
 */
@Service
public class ActivateInitProfile implements BaseModuleEApi {

    @Override
    public void execute (JSONObject object,Map<String,String> queryMap,Map<String, String> cookies) {
        object.set("nickname",queryMap.get("nickname"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/eapi/activate/initProfile";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/activate/initProfile";
    }
}
