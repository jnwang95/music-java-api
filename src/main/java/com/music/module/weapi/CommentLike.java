package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 点赞与取消点赞评论
 */
@Service
public class CommentLike implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        cookies.put("os","pc");
        this.url  = "1".equals(queryMap.get("t")) ? "like" : "unlike";
        String type = TypeConfig.resourceTypeMap.get(queryMap.get("type"));
        object.set("commentId", queryMap.get("cid"));

        if ("A_EV_2_".equals(type)) {
            object.replace("threadId",queryMap.get("threadId"));
        }else {
            object.set("threadId", type + queryMap.get("id"));
        }
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/v1/comment/" + this.url;
    }
}
