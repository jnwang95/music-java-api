package com.music.module.weapi;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 */
@Service
public class Calendar implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("startTime", StrUtil.nullToDefault(queryMap.get("startTime"), DateTime.now().getTime() + ""));
        object.set("endTime", StrUtil.nullToDefault(queryMap.get("endTime"), DateTime.now().getTime() + ""));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/mcalendar/detail" ;
    }
}
