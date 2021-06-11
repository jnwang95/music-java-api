package com.music.module.api;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/7 16:37
 * @description 所有榜单介绍
 */
@Service
public class Toplist implements BaseModuleApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/toplist";
    }
}
