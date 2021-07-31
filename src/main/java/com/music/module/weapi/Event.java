package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 动态
 */
@Service
public class Event implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("pagesize", StrUtil.nullToDefault(queryMap.get("pagesize"),"20"));
        object.set("lasttime", StrUtil.nullToDefault(queryMap.get("lasttime"),"-1"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/v1/event/get";
    }
}
