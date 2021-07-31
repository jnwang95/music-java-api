package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import com.music.util.CryptoUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 邮箱登录
 */
@Service
public class Login implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        cookies.put("os","pc");
        object.set("username",queryMap.get("email"));
        String password = StrUtil.nullToDefault(queryMap.get("md5_password"), CryptoUtil.getMd5(queryMap.get("password")));
        object.set("rememberLogin",true);
        object.set("password",password);
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/login";
    }
}
