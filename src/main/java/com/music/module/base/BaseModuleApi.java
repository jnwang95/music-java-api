package com.music.module.base;

public interface BaseModuleApi extends BaseModule {

    @Override
    default String getType(){
        return "api";
    }

    @Override
    default String getOptionsUrl() {
        return null;
    }
}
