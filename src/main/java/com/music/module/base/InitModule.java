package com.music.module.base;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

/**
 * 获取应用上下文并获取相应的接口实现类
 */
@Component
@AllArgsConstructor
public class InitModule implements ApplicationContextAware {

    /**
     * 用于保存接口实现类名及对应的类
     */
    private final Map<String, BaseModule> map;

    /**
     * 获取应用上下文并获取相应的接口实现类
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, BaseModule> oldMap = applicationContext.getBeansOfType(BaseModule.class);
        for (Map.Entry<String, BaseModule> entry : oldMap.entrySet()) {
            String key = entry.getKey();
            BaseModule value = entry.getValue();
            map.put(key.toLowerCase(Locale.ROOT),value);
        }
    }

    /**
     * 获取所有实现集合
     */
    public Map<String, BaseModule> getMap() {
        return map;
    }

    /**
     * 获取对应服务
     */
    public BaseModule getService(String key) {
        return map.get(key);
    }
}
