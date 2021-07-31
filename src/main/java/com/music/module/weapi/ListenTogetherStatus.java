package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 一起听状态
 */
@Service
public class ListenTogetherStatus implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/listen/together/status/get";
    }
}
