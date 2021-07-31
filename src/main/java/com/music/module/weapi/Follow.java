package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 关注与取消关注用户
 */
@Service
public class Follow implements BaseModuleWeApi {

    private String t;
    private String id;

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.id = queryMap.get("id");
        this.t = "1".equals(queryMap.get("t")) ? "follow" : "delfollow";
        cookies.put("os","pc");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/user/" + this.t + "/" + this.id;
    }
}
