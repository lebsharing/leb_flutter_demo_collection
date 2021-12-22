package com.leb.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leb.card.activity.FAEmbedActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Constants.ENGINE_TYPE == Constants.MULTI_ENGINE) {
            infoTv.text = "以多引擎的方式open flutter page"
        } else if (Constants.ENGINE_TYPE == Constants.SINGLE_ENGINE) {
            infoTv.text = "以共享引擎的方式使用Flutter Engine"
        }

        btn1.setOnClickListener {
            startActivity(Intent(this, FAEmbedActivity::class.java));
        }

        flBtn3.setOnClickListener {
            startActivity(Intent(this, FlutterFragmentActivity::class.java));
        }

    }
}