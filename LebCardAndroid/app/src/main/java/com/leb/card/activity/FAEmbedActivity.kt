package com.leb.card.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.leb.card.Constants
import com.leb.card.R
import io.flutter.embedding.android.FlutterActivity
import kotlinx.android.synthetic.main.activity_fa_embed.*

/**
 * FlutterActivity嵌入android
 */
class FAEmbedActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fa_embed)

        exBtn1.setOnClickListener {
            if (Constants.ENGINE_TYPE == Constants.MULTI_ENGINE) {
                startActivity(FlutterActivity.createDefaultIntent(this));
            } else if(Constants.ENGINE_TYPE == Constants.SINGLE_ENGINE) {
                startActivity(FlutterActivity.withCachedEngine(Constants.CACHE_ENGINE_ID).build(this));
            }
        }
        exBtn2.setOnClickListener {
            if (Constants.ENGINE_TYPE == Constants.MULTI_ENGINE) {
                startActivity(
                    FlutterActivity.withNewEngine().initialRoute("cardDetail").build(this)
                )
            } else if(Constants.ENGINE_TYPE == Constants.SINGLE_ENGINE) {
                //需要使用平台通道显示的修改flutter页面的切换
                startActivity(FlutterActivity.withCachedEngine(Constants.CACHE_ENGINE_ID).build(this));
            }
        }
    }
}