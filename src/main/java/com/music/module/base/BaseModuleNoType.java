package com.music.module.base;

public interface BaseModuleNoType extends BaseModule {

    @Override
    default String getType(){
        return null;
    }

    @Override
    default String getOptionsUrl(){
        return null;
    }
}
