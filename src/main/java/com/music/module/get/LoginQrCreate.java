package com.music.module.get;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleNoType;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 二维码
 */
@Service
public class LoginQrCreate implements BaseModuleNoType {

    private String key;
    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        this.key = queryMap.get("key");
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/login?codekey=" + this.key;
    }
}
