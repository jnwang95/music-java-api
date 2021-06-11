package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 订阅与取消电台
 */
@Service
public class DjSub implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("id", queryMap.get("rid"));
        this.url = "1".equals(queryMap.get("t")) ? "sub" : "unsub";
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/djradio/" + this.url;
    }
}
