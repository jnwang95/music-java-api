package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 签到
 0为安卓端签到 3点经验, 1为网页签到,2点经验
 签到成功 {'android': {'point': 3, 'code': 200}, 'web': {'point': 2, 'code': 200}}
 重复签到 {'android': {'code': -2, 'msg': '重复签到'}, 'web': {'code': -2, 'msg': '重复签到'}}
 未登录 {'android': {'code': 301}, 'web': {'code': 301}}
 */
@Service
public class DailySignin implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("type", StrUtil.nullToDefault(queryMap.get("type"),"0"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/point/dailyTask";
    }
}
