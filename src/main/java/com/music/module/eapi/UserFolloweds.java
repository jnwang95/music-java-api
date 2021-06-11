package com.music.module.eapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  关注TA的人(粉丝)
 */
@Service
public class UserFolloweds implements BaseModuleEApi {

    private String uid;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        uid = queryMap.get("uid");
        object.set("userId",queryMap.get("uid"));
        object.set("time",queryMap.get("0"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"30"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("getcounts",queryMap.get("true"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/eapi/user/getfolloweds/" + this.uid;
    }

    @Override
    public String getOptionsUrl() {
        return "/api/user/getfolloweds";
    }
}
