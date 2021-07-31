package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 历史每日推荐歌曲
 */
@Service
public class HistoryRecommendSongs implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","ios");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/discovery/recommend/songs/history/recent";
    }
}
