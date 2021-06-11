package com.music.module.weapi;

import cn.hutool.json.JSONObject;
import com.music.module.base.BaseModuleWeApi;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wjning
 * @date 2021/6/8 9:24
 * @description 精选电台分类
 *     有声书 10001
 *     知识技能 453050
 *     商业财经 453051
 *     人文历史 11
 *     外语世界 13
 *     亲子宝贝 14
 *     创作|翻唱 2001
 *     音乐故事 2
 *     3D|电子 10002
 *     相声曲艺 8
 *     情感调频 3
 *     美文读物 6
 *     脱口秀 5
 *     广播剧 7
 *     二次元 3001
 *     明星做主播 1
 *     娱乐|影视 4
 *     科技科学 453052
 *     校园|教育 4001
 *     旅途|城市 12
 */
@Service
public class DjRecommendType implements BaseModuleWeApi {


    @Override
    public void execute(JSONObject object, Map<String, String> queryMap, Map<String, String> cookies) {
        object.set("cateId", queryMap.get("type"));
    }

    @Override
    public String getUrl() {
        return "https://music.163.com/weapi/djradio/recommend";
    }
}
