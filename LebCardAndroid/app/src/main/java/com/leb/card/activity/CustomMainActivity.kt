package com.leb.card.activity

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import com.leb.card.Constants
import com.leb.card.R
import io.flutter.embedding.android.FlutterFragment

/**
 * 用于测试，指定Flutter运行入口。和变化的初识路径类似。
 */
class CustomMainActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null;

    companion object {
        private const val TAG_FLUTTER_ENGINE = "custom_flutter_fragment";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_main);
        initView();
    }

    private fun initView() {
        if (Constants.ENGINE_TYPE == Constants.MULTI_ENGINE) {
            val fragmentManager = supportFragmentManager;
            //Caused by: java.lang.NullPointerException: null cannot be cast to non-null type io.flutter.embedding.android.FlutterFragment
            flutterFragment =
                fragmentManager.findFragmentByTag(TAG_FLUTTER_ENGINE) as FlutterFragment?;
            if (flutterFragment == null) {
                var newFlutterFragment =
                    FlutterFragment.withNewEngine().dartEntrypoint("enterDetail")
                        .build<FlutterFragment>();
                flutterFragment = newFlutterFragment;
                fragmentManager.beginTransaction()
                    .add(R.id.containerFl, newFlutterFragment, TAG_FLUTTER_ENGINE)
                    .commit();
            }
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment!!.onPostResume();
    }

    override fun onNewIntent(@NonNull intent: Intent) {
        super.onNewIntent(intent)
        flutterFragment!!.onNewIntent(intent)
    }

    override fun onBackPressed() {
        flutterFragment!!.onBackPressed();
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment!!.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint();
        flutterFragment!!.onUserLeaveHint();
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment!!.onTrimMemory(level);
    }
}