package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  更新歌单描述
 */
@Service
public class PlaylistDescUpdate implements BaseModuleEApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        object.set("id",queryMap.get("id"));
        object.set("desc",queryMap.get("desc"));
    }

    @Override
    public String getUrl() {
        return "https://interface3.music.163.com/eapi/playlist/desc/update";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/playlist/desc/update";
    }
}
