package com.music.module.eapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleEApi;
import com.music.util.CryptoUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  歌曲链接
 */
@Service
public class SongUrl implements BaseModuleEApi {
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","pc");
        if (!queryMap.containsKey("MUSIC_U") || !queryMap.containsValue("MUSIC_U")) {
            cookies.put("_ntes_nuid", CryptoUtil.strToHex(CryptoUtil.createSecretKey()));
        }
        object.set("br", StrUtil.nullToDefault(queryMap.get("br"),"999000"));
        object.set("id",queryMap.get("id"));
    }

    @Override
    public String getUrl() {
        return "https://interface3.music.163.com/eapi/song/enhance/player/url";
    }

    @Override
    public String getOptionsUrl() {
        return "/api/song/enhance/player/url";
    }
}
