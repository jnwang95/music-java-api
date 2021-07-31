package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 喜欢的歌曲(无序)
 */
@Service
public class Likelist implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("uid", queryMap.get("uid"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/song/like/get";
    }
}
