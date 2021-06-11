package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 电台评论
 */
@Service
public class CommentDj implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","pc");
        object.set("rid", queryMap.get("id"));
        this.url = queryMap.get("id");
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"20"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("beforeTime", StrUtil.nullToDefault(queryMap.get("before"),"0"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/v1/resource/comments/A_DJ_1_" + this.url;
    }
}
