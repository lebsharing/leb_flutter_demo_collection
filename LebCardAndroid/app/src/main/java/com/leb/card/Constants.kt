package com.leb.card

class Constants {
    //将
    var viewLevelEnable:Boolean = false;

    companion object {
        const val MULTI_ENGINE = "multi_engine";//使用新的引擎，
        const val SINGLE_ENGINE = "single_engine"//使用缓存引擎

        //Flutter Engine使用方式
        const val ENGINE_TYPE = MULTI_ENGINE;


        const val CACHE_ENGINE_ID = "cache_engine_id";//

    }
}