package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 红心与取消红心歌曲
 */
@Service
public class Like implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","pc");
        cookies.put("appver","2.7.1.198277");
        String like = "false".equals(queryMap.get("like")) ? "false" : "true";
        object.set("alg", "itembased");
        object.set("trackId", queryMap.get("id"));
        object.set("time", "3");
        object.set("like", like);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/radio/like";
    }
}
