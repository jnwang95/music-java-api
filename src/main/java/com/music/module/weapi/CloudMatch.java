package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 */
@Service
public class CloudMatch implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","ios");
        cookies.put("appver","8.1.20");
        object.set("userId", queryMap.get("uid"));
        object.set("songId", queryMap.get("sid"));
        object.set("adjustSongId", queryMap.get("asid"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/cloud/user/song/match";
    }
}
