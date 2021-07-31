package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 转发动态
 */
@Service
public class EventForward implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
       cookies.put("os","pc");
        object.set("forwards", queryMap.get("forwards"));
        object.set("id", queryMap.get("evId"));
        object.set("eventUserId", queryMap.get("uid"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/event/forward";
    }
}
