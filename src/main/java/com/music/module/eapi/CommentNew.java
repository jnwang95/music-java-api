package com.music.module.eapi;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.config.TypeConfig;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 评论
 */
@Service
public class CommentNew implements BaseModuleEApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","pc");
        String type = TypeConfig.resourceTypeMap.get(queryMap.get("type"));
        object.set("threadId",type + queryMap.get("id"));
        object.set("pageSize", StrUtil.nullToDefault(queryMap.get("pageSize"),"20"));
        object.set("showInner", StrUtil.nullToDefault(queryMap.get("showInner"),"true"));
        object.set("pageNo", StrUtil.nullToDefault(queryMap.get("pageNo"),"1"));
        String cursor;
        if (StrUtil.equals(queryMap.get("sortType"),"3")){
             cursor = StrUtil.nullToDefault(queryMap.get("cursor"), "0");
        }else {
            cursor = NumberUtil.mul(StrUtil.nullToDefault(queryMap.get("pageNo"), "1"), StrUtil.nullToDefault(queryMap.get("pageSize"), "20")).toString();
        }
        object.set("cursor", cursor);
        object.set("sortType", queryMap.get("sortType"));

    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v2/resource/comments";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/v2/resource/comments";
    }
}
