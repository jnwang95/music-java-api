package com.music.module.notype;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleNoType;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 首页轮播图
 */
@Service
public class Banner implements BaseModuleNoType {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {

        if (StrUtil.isEmpty(queryMap.get("type"))) {
            object.set("clientType", "pc");
        }else if (StrUtil.equals("0",queryMap.get("type"))){
            object.set("clientType", "pc");
        }else if (StrUtil.equals("1",queryMap.get("type"))){
            object.set("clientType", "android");
        }else if (StrUtil.equals("2",queryMap.get("type"))){
            object.set("clientType", "iphone");
        }else if (StrUtil.equals("3",queryMap.get("type"))){
            object.set("clientType", "ipad");
        }else {
            object.set("clientType", "pc");
        }
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/v2/banner/get" ;
    }
}
