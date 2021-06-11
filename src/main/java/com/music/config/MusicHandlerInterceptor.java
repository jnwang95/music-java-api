package com.music.config;

import com.music.service.BaseService;
import com.music.util.CookieUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义拦截器
 * 1. 自定义适配音乐接口
 * 2.自定义记录pv,uv
 */
@Slf4j
@Component
@AllArgsConstructor
public final class MusicHandlerInterceptor implements HandlerInterceptor {

    private final BaseService bs;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ResponseEntity<String> musicData = bs.getMusicData(request);
        PrintWriter writer = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            try {
                writer = response.getWriter();
                CookieUtil.setCookie(musicData.getHeaders(), response);
                writer.print(musicData.getBody());
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                assert writer != null;
                writer.close();
            }
        return false;
    }
}
