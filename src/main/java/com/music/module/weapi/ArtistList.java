package com.music.module.weapi;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description  歌手分类
 *     type 取值
 *     1:男歌手
 *     2:女歌手
 *     3:乐队
 *
 *     area 取值
 *     -1:全部
 *     7华语
 *     96欧美
 *     8:日本
 *     16韩国
 *     0:其他
 *
 *     initial 取值 a-z/A-Z
 */
@Service
public class ArtistList implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("area", queryMap.get("area"));
        object.set("type", StrUtil.nullToDefault(queryMap.get("type"),"1"));
        object.set("limit", StrUtil.nullToDefault(queryMap.get("limit"),"30"));
        object.set("offset", StrUtil.nullToDefault(queryMap.get("offset"),"0"));
        object.set("total", true);

        boolean initial = NumberUtil.isNumber(queryMap.get("initial"));
        if (initial) object.set("initial", queryMap.get("initial"));
        else {
            int code = StrUtil.nullToEmpty(queryMap.get("initial")).toUpperCase(Locale.ROOT).codePointAt(0);
            object.set("initial", code);
        }
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v1/artist/list" ;
    }
}
