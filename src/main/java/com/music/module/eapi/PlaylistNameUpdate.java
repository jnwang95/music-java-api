package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  更新歌单名
 */
@Service
public class PlaylistNameUpdate implements BaseModuleEApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        object.set("id",queryMap.get("id"));
        object.set("name",queryMap.get("name"));
    }

    @Override
    public String getUrl() {
        return "https://interface3.music.163.com/eapi/playlist/update/name";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/playlist/update/name";
    }
}
