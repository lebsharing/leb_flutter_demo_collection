package com.leb.jet

import android.content.Intent
import android.os.Bundle
import android.provider.Browser
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.leb.jet.modules.browser.BrowserActivity
import com.leb.jet.modules.test.TestMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener();
    }

    fun initListener() {
        findViewById<Button>(R.id.browser_btn).setOnClickListener { openBrowser(); }
    }

    fun openBrowser() {
//        val intent = Intent(this,BrowserActivity::class.java).apply {
//            putExtra("url","https://cdn.lingo-ace.com/teach/pro/CourseTest/index.html?instanceId=31&loginType=1&lessonId=13661&studentId=6399560928242318");
//        };
        var intent = Intent(this,TestMainActivity::class.java);
        startActivity(intent);
    }
}