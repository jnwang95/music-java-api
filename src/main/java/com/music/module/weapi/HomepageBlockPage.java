package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * // 首页-发现 block page
 * // 这个接口为移动端接口，首页-发现页，数据结构可以参考 https://github.com/hcanyz/flutter-netease-music-api/blob/master/lib/src/api/uncategorized/bean.dart#L259 HomeBlockPageWrap
 * // query.refresh 是否刷新数据
 */
@Service
public class HomepageBlockPage implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        cookies.put("os","ios");
        cookies.put("appver","8.1.20");
        object.set("cursor", queryMap.get("cursor"));
        object.set("refresh", StrUtil.nullToDefault(queryMap.get("refresh"),"false"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/homepage/block/page";
    }
}
