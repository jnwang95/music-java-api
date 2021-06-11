package com.music.module.eapi;

import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  首页-发现 dragon ball
 *  这个接口为移动端接口，首页-发现页（每日推荐、歌单、排行榜 那些入口）
 *  !需要登录或者匿名登录，非登录返回 []
 */
@Service
public class HomepageDragonBall implements BaseModuleEApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        if (queryMap.containsKey("MUSIC_U") || queryMap.containsValue("MUSIC_U")) {
            cookies.put("MUSIC_A", TypeConfig.anonymous_token);
        }
        cookies.put("os", "ios");
        cookies.put("appver", "8.1.20");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/eapi/homepage/dragon/ball/static";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/homepage/dragon/ball/static";
    }
}
