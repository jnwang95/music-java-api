package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  歌手单曲
 */
@Service
public class Artists implements BaseModuleWeApi {

    private String url;

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.url = queryMap.get("id");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/v1/artist/" + this.url ;
    }
}
