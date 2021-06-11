package com.music.module.base;

public interface BaseModuleEApi extends BaseModule {

    @Override
    default String getType(){
        return "eapi";
    }
}
