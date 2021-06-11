package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 获取动态评论
 */
@Service
public class CommentFloor implements BaseModuleWeApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        String type = TypeConfig.resourceTypeMap.get(queryMap.get("type"));
        object.set("parentCommentId",queryMap.get("parentCommentId"));
        object.set("threadId",type + queryMap.get("id"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"20"));
        object.set("time", StrUtil.nullToDefault(queryMap.get("time"),"-1"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/resource/comment/floor/get";
    }
}
