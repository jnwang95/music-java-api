package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 视频评论
 */
@Service
public class CommentVideo implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","pc");
        this.url = queryMap.get("id");
        object.set("rid",queryMap.get("id"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"20"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("beforeTime", StrUtil.nullToDefault(queryMap.get("before"),"0"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/v1/resource/comments/R_VI_62_" + this.url;
    }
}
