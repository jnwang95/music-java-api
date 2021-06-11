package com.music.module;//package com.music.module;
//
//import cn.hutool.core.util.StrUtil;
//import cn.hutool.json.JSONObject;
//import com.music.module.base.BaseModule;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
///**
// * 创建歌单
// */
//@Service
//public class PlaylistCreate implements BaseModule {
//    @Override
//    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
//        cookies.put("os", "pc");
//        object.set("name", queryMap.get("name"));
//        object.set("privacy", queryMap.get("privacy"));
//        object.set("type", StrUtil.nullToDefault(queryMap.get("type"),"NORMAL"));
//    }
//
//    @Override
//    public String getUrl() {
//        return "https://music.163.com/weapi/playlist/create`";
//    }
//
//    @Override
//    public String getType() {
//        return null;
//    }
//}
