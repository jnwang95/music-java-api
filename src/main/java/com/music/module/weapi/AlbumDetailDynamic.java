package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 专辑动态信息
 */
@Service
public class AlbumDetailDynamic implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("id", queryMap.get("id"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/album/detail/dynamic";
    }
}
