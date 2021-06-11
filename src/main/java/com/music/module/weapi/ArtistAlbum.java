package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  歌手专辑列表
 */
@Service
public class ArtistAlbum implements BaseModuleWeApi {

    private String url;

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.url = queryMap.get("id");
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"30"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("total", true);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/artist/albums/" + this.url ;
    }
}
