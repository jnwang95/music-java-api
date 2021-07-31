package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 垃圾桶
 */
@Service
public class FmTrash implements BaseModuleWeApi {

    private String id;
    private String time;

    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.id = queryMap.get("id");
        this.time = StrUtil.nullToDefault(queryMap.get("time") , "25");
        object.set("songId", queryMap.get("id"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/radio/trash/add?alg=RT&songId=" + this.id + "&time=" + this.time;
    }
}
