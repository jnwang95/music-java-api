package com.music.module.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/7 16:43
 * @description 歌单详情
 */
@Service
public class PlaylistDetail implements BaseModuleApi {
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("id",queryMap.get("id") );
        object.set("n",100000);
        object.set("s", StrUtil.nullToDefault(queryMap.get("s"),"8"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v6/playlist/detail";
    }
}
