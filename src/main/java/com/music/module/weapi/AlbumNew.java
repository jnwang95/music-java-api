package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  全部新碟
 */
@Service
public class AlbumNew implements BaseModuleWeApi {

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
            object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"10"));
            object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
            object.set("total", queryMap.get("true"));
            object.set("area", StrUtil.nullToDefault(queryMap.get("area"),"ALL"));
            //Z_H:华语,E_A:欧美,KR:韩国,JP:日本
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/album/new";
    }
}
