package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import com.music.util.CryptoUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginQrCheck implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        object.set("key",queryMap.get("key"));
        object.set("type",1);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/login/qrcode/client/login";
    }
}
