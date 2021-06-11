package com.music.util;

import cn.hutool.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestTemplateUtil {

    /**
     * 产生随机的User Agent
     */
    public static String getUserAgent() {
        String[] userAgentList = new String[]
                {
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1",
                        "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
                        "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
                        "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) Mobile/14F89;GameHelper",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/603.2.4 (KHTML, like Gecko) Version/10.1.1 Safari/603.2.4",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:46.0) Gecko/20100101 Firefox/46.0",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:46.0) Gecko/20100101 Firefox/46.0",
                        "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)",
                        "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)",
                        "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)",
                        "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Win64; x64; Trident/6.0)",
                        "Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; rv:11.0) like Gecko",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/13.10586",
                        "Mozilla/5.0 (iPad; CPU OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1"
                };

        double index = Math.floor(Math.random() * userAgentList.length);
        return userAgentList[(int) index];
    }

    /**
     * 设置Headers
     */
    public static HttpHeaders setHeaders(List<String> cookies) {
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.ACCEPT, "*/*");
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4");
        headers.add(HttpHeaders.CONNECTION, "keep-alive");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        headers.add(HttpHeaders.REFERER, "https://music.163.com");
        headers.add(HttpHeaders.HOST, "music.163.com");
        headers.put(HttpHeaders.COOKIE, cookies);
        headers.add(HttpHeaders.USER_AGENT, getUserAgent());
        return headers;
    }

    /**
     * 发送Post请求
     */
    public static ResponseEntity<String> post(JSONObject object, String url, Map<String, String> cookies, RestTemplate restTemplate) {
        return postApi(object, url, cookies, restTemplate);
    }

    /**
     * 发送weapi Post请求
     */
    public static ResponseEntity<String> postWeApi(String params, String encSecKey, String url, Map<String, String> cookies, RestTemplate restTemplate) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("params", params);
        map.add("encSecKey", encSecKey);
        List<String> list = setCookies(cookies);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, setHeaders(list));
        return restTemplate.postForEntity(url, entity, String.class);
    }

    /**
     * 针对eapi类型的接口请求
     */
    public static ResponseEntity<String> postEApi(String params,String url, Map<String, String> cookies, RestTemplate restTemplate) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("params", params);
        List<String> list = setCookies(cookies);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, setHeaders(list));
        return restTemplate.postForEntity(url, entity, String.class);
    }

    /**
     * 针对api类型的接口请求
     */
    public static ResponseEntity<String> postApi(JSONObject object, String url, Map<String, String> cookies, RestTemplate restTemplate) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        object.forEach(map::add);
        List<String> list = setCookies(cookies);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, setHeaders(list));
        return restTemplate.postForEntity(url, entity, String.class);
    }

    public static List<String> setCookies(Map<String, String> cookies){
        List<String> list = new ArrayList<>();
        if (cookies != null) {
            cookies.forEach((k, v) -> list.add(k + "=" + v));
        }
        return list;
    }
}