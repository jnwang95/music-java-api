package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 购买数字专辑
 */
@Service
public class DigitalAlbumOrdering implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("business", "Album");
        object.set("paymentMethod", queryMap.get("payment"));
        object.set("from", "web");
        JSONObject subObject = new JSONObject();
        subObject.set("business", "Album");
        subObject.set("resourceID", queryMap.get("id"));
        subObject.set("quantity", queryMap.get("quantity"));
        object.set("digitalResources", subObject.toString());
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/api/ordering/web/digital";
    }
}
