package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 发送与删除评论
 */
@Service
public class Comment implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        cookies.put("os","pc");
        this.url = TypeConfig.t.get(queryMap.get("t"));
        String type = TypeConfig.resourceTypeMap.get(queryMap.get("type"));

        if ("A_EV_2_".equals(type)) {
            object.set("threadId", queryMap.get("threadId"));
        }else {
            object.set("threadId", type + queryMap.get("id"));
        }

        if (this.url.equals("add")) {
            object.set("content", queryMap.get("content"));
        }
        if (this.url.equals("delete")) {
            object.set("commentId", queryMap.get("commentId"));
        }
        if (this.url.equals("reply")) {
            object.set("commentId", queryMap.get("commentId"));
            object.set("content", queryMap.get("content"));
        }


        object.set("id", queryMap.get("id"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/resource/comments/" + this.url;
    }
}
