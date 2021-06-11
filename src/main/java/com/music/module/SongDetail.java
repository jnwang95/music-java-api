package com.music.module;//package com.music.module;
//
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONObject;
//import com.music.module.base.BaseModule;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
//@Service
//public class SongDetail implements BaseModule {
//
//    @Override
//    public void execute(JSONObject object,Map<String, String> queryMap,Map<String, String> cookies) {
//        String ids = queryMap.get("ids");
//        JSONArray c = new JSONArray();
//        for (String id : ids.split("\\s*,\\s*")) {
//            JSONObject curId = new JSONObject();
//            curId.set("id", id);
//            c.add(curId);
//        }
//        object.set("c",c.toString());
//    }
//
//    @Override
//    public String getUrl() {
//        return "https://music.163.com/weapi/v3/song/detail";
//    }
//
//    @Override
//    public String getType() {
//        return null;
//    }
//}
