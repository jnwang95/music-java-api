package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 数字专辑详情
 */
@Service
public class AlbumDetail implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("id", queryMap.get("id"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/vipmall/albumproduct/detail";
    }
}
