package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  收藏与取消收藏歌手
 */
@Service
public class ArtistSub implements BaseModuleWeApi {

    private String url;

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.url = "1".equals(queryMap.get("t")) ? "sub" : "unsub";
        object.set("artistId", queryMap.get("id"));
        object.set("artistIds","[" + queryMap.get("id") + "]");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/artist/" + this.url ;
    }
}
