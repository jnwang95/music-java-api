package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * 搜索
 */
@Service
public class Cloudsearch implements BaseModuleWeApi {

    // 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单, 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台, 1014: 视频
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("s", queryMap.get("keywords"));
        object.set("total", true);
        object.set("type", StrUtil.nullToDefault(queryMap.get("type"),"1"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"30"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/cloudsearch/pc";
    }
}
