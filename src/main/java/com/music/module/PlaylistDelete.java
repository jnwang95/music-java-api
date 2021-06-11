package com.music.module;//package com.music.module;
//
//import cn.hutool.json.JSONObject;
//import com.music.module.base.BaseModule;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
///**
// * @author wjning
// * @date 2021/6/7 16:33
// * @description 删除歌单
// */
//@Service
//public class PlaylistDelete implements BaseModule {
//    @Override
//    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
//        cookies.put("os", "pc");
//        object.set("ids", "[" + queryMap.get("id") + "]");
//    }
//
//    @Override
//    public String getUrl() {
//        return "https://music.163.com/weapi/playlist/remove";
//    }
//
//    @Override
//    public String getType() {
//        return null;
//    }
//}
