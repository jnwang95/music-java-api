package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  数字专辑&数字单曲-榜单
 */
@Service
public class AlbumSongsaleboard implements BaseModuleWeApi {

    private String url;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        object.set("albumType", StrUtil.nullToDefault(queryMap.get("queryMap"),"0"));
        var type = StrUtil.nullToDefault(queryMap.get("type"),"daily"); // daily,week,year,total
        this.url = type;
        if (type.equals("year")) {
            object.set("year",queryMap.get("year"));
        }
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/feealbum/songsaleboard/"+ url +"/type";
    }
}
