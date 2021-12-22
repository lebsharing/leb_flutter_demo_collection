package com.leb.card

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class CardApplication : Application(){

    lateinit var flutterEngine:FlutterEngine;

    override fun onCreate() {
        super.onCreate()
        if(Constants.ENGINE_TYPE == Constants.SINGLE_ENGINE) {
            flutterEngine = FlutterEngine(this);

            flutterEngine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            );
            //Cache the FlutterEngine to be used by FlutterActivity
            FlutterEngineCache.getInstance().put(Constants.CACHE_ENGINE_ID,flutterEngine);

        }
    }


}