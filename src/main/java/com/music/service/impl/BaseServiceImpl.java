package com.music.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.music.module.base.*;
import com.music.service.BaseService;
import com.music.util.CookieUtil;
import com.music.util.CryptoUtil;
import com.music.util.RestTemplateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@AllArgsConstructor
public class BaseServiceImpl implements BaseService {

    private final RestTemplate restTemplate;
    private final InitModule initModule;
    private final CookieUtil cookieUtil;

    @Override
    public ResponseEntity<String> getMusicData(HttpServletRequest request) {
        Map<String, String> cookies = cookieUtil.getCookies(request);
        Map<String,String> queryMap = new ConcurrentHashMap<>();
        if (StrUtil.isNotEmpty(request.getQueryString())) {
            String[] queryArray = request.getQueryString().split("&");
            for (String query : queryArray) {
                if (query.contains("=")) {
                    String[] split = query.split("=");
                    queryMap.put(split[0],split[1]);
                }
            }
        }
        String key = request.getRequestURI()
                .replaceAll("music","")
                .replaceAll("/", "");

        JSONObject object = new JSONObject();
        object.set("csrf_token", cookies.get("__csrf"));
        BaseModule baseModule = initModule.getService(key);
        baseModule.execute(object,queryMap,cookies);

        if (baseModule instanceof BaseModuleApi) {

            return RestTemplateUtil.postApi(object, baseModule.getUrl(), cookies, restTemplate);
        }
        if (baseModule instanceof BaseModuleEApi) {

            final String param = CryptoUtil.eapiEncrypt(baseModule.getOptionsUrl(), object.toString());
            return RestTemplateUtil.postEApi(param,
                    baseModule.getUrl().replaceAll("api",baseModule.getOptionsUrl()),
                    cookies,
                    restTemplate);
        }
        if (baseModule instanceof BaseModuleWeApi) {

            String[] encrypt = CryptoUtil.weapiEncrypt(object.toString());
            return RestTemplateUtil.postWeApi(encrypt[0],
                    encrypt[1],
                    baseModule.getUrl().replaceAll("/api","/" + baseModule.getType()) +"?csrf_token=",
                    cookies,
                    restTemplate);
        }

        if (baseModule instanceof BaseModuleGetType) {
            return RestTemplateUtil.get(baseModule.getUrl(),cookies,restTemplate);
        }
        return RestTemplateUtil.post(object, baseModule.getUrl(),cookies,restTemplate);
    }
}
