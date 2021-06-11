package com.music.config;

import cn.hutool.core.collection.CollUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 评论类型配置
 */
public final class TypeConfig {

    public final static Map<String,String> resourceTypeMap = CollUtil.newHashMap();
    public final static Map<String,String> t = new ConcurrentHashMap<>();
    public final static String anonymous_token = "8aae43f148f990410b9a2af38324af24e87ab9227c9265627ddd10145db744295fcd8701dc45b1ab8985e142f491516295dd965bae848761274a577a62b0fdc54a50284d1e434dcc04ca6d1a52333c9a";

    static {

        t.put("1","add");
        t.put("0","delete");
        t.put("2","reply");

        resourceTypeMap.put("0","R_SO_4_");
        resourceTypeMap.put("1","R_MV_5_");
        resourceTypeMap.put("2","A_PL_0_");
        resourceTypeMap.put("3","R_AL_3_");
        resourceTypeMap.put("4","A_DJ_1_");
        resourceTypeMap.put("5","R_VI_62_");
        resourceTypeMap.put("6","A_EV_2_");
    }
}
