package com.music.module.api;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/7 16:43
 */
@Service
public class HugComment implements BaseModuleApi {
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        cookies.put("os","ios");
        cookies.put("appver","8.1.20");
        String type = TypeConfig.resourceTypeMap.get(StrUtil.nullToDefault(queryMap.get("type"), "0"));
        String threadId = type + queryMap.get("sid");

        object.set("targetUserId",queryMap.get("uid"));
        object.set("commentId",queryMap.get("cid"));
        object.set("threadId",threadId);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v2/resource/comments/hug/listener";
    }
}
