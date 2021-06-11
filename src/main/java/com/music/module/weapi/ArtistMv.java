package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  歌手相关MV
 */
@Service
public class ArtistMv implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("artistId", queryMap.get("id"));
        object.set("limit", queryMap.get("limit"));
        object.set("offset", queryMap.get("offset"));
        object.set("total", true);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/artist/mvs" ;
    }
}
