package com.music.module.base;

import cn.hutool.json.JSONObject;

import java.util.Map;

public interface BaseModule {

     /**
      * 构建参数
      * @param object json参数体
      * @param queryMap 查询的参数
      * @param cookies cookies
      */
     void execute (JSONObject object,Map<String,String> queryMap,Map<String, String> cookies);

     /**
      * 获取url
      * @return yrl
      */
     String getUrl();

     /**
      * 获取类型
      * @return weapi，api，wapi
      */
     String getType();

     /**
      * 获取eapi的构造url
      * @return url
      */
     String getOptionsUrl();
}
