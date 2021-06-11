package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  歌手相关歌曲
 */
@Service
public class ArtistSongs implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os", "pc");
        object.set("id", queryMap.get("id"));
        object.set("private_cloud", true);
        object.set("work_type", 1);
        object.set("order", StrUtil.nullToDefault(queryMap.get("order"),"hot"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"100"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v1/artist/songs" ;
    }
}
