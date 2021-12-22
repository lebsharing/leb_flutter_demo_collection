package com.leb.card.viewlevel

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.leb.card.R
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * 将FlutterView嵌入android
 */
class FlutterViewLevelActivity : FragmentActivity() {

    lateinit var flutterEngine:FlutterEngine;
    lateinit var flutterViewEngine: FlutterView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutterview_level);

//        flutterEngine = FlutterEngine(applicationContext);
//        flutterEngine.dartExecutor.executeDartEntrypoint(
//            DartExecutor.DartEntrypoint(
//                FlutterInjector.instance().flutterLoader().findAppBundlePath(),
//                "enterCell"
//            )
//        );

    }
}