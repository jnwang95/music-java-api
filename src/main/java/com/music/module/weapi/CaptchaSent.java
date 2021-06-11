package com.music.module.weapi;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 发送验证码
 */
@Service
public class CaptchaSent implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("ctcode", StrUtil.nullToDefault(queryMap.get("ctcode"),"86"));
        object.set("cellphone", queryMap.get("phone"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/sms/captcha/sent";
    }
}
