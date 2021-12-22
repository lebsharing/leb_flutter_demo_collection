package com.leb.card

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.leb.card.activity.CustomMainActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode
import kotlinx.android.synthetic.main.activity_flutter_fragment.*

class FlutterFragmentActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null;

    companion object {
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment";

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)

        initView();
        initListener();
        initFlutterFragment();
    }
    private fun initView() {
        if(Constants.ENGINE_TYPE == Constants.MULTI_ENGINE) {
            multiEngineLl.visibility = View.VISIBLE;
            customMainBtn.setOnClickListener {
                Log.w("fxz","****Open Custom enterPoint****");
                startActivity(Intent(this,CustomMainActivity::class.java));
            }
        } else {
            multiEngineLl.visibility = View.GONE;
        }
    }

    private fun initListener() {
        backBtn.setOnClickListener { finish(); }
    }

    private fun initFlutterFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager;
        flutterFragment =
            fragmentManager.findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?;

        if (flutterFragment == null) {
//            var newFlutterFragment = FlutterFragment.createDefault();
            var newFlutterFragment: FlutterFragment =
                if (Constants.ENGINE_TYPE == Constants.SINGLE_ENGINE) {
                    FlutterFragment.withCachedEngine(Constants.CACHE_ENGINE_ID)
//                        .renderMode(RenderMode.surface)
//                        .renderMode(RenderMode.texture)
                        .build<FlutterFragment>();
                } else {
                    FlutterFragment.withNewEngine().initialRoute("/").build<FlutterFragment>();
//                    FlutterFragment.createDefault();
                }
            flutterFragment = newFlutterFragment;
            fragmentManager.beginTransaction()
                .add(R.id.containerFl, newFlutterFragment, TAG_FLUTTER_FRAGMENT)
                .commit();
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