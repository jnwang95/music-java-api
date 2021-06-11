package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  电台新人榜
 */
@Service
public class DjToplistNewcomer implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"100"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/dj/toplist/newcomer";
    }
}
