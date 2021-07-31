package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 删除动态
 */
@Service
public class EventDel implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("id", queryMap.get("evId"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/eapi/event/delete";
    }
}
