package com.leb.jet.modules.test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.leb.jet.databinding.ActivityTestMainBinding

/**
 * 1、所有用来测试用的项目入口
 * 2、该页面展示了ViewBinding的使用
 */
class TestMainActivity : FragmentActivity(){

    private  lateinit var binding:ActivityTestMainBinding;

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        initView();
    }

    private fun initView() {
        binding.backIv.setOnClickListener { finish(); };
        binding.viewBindExBtn.setOnClickListener { Toast.makeText(this,"ViewBinding",Toast.LENGTH_LONG).show(); };
        binding.dataBindExBtn.setOnClickListener {
            val dataIntent = Intent(this,TestDataBindActivity::class.java);
            startActivity(dataIntent);
        }
        binding.liveDataExBtn.setOnClickListener {
            val lIntent = Intent(this,TestLiveDataActivity::class.java);
            startActivity(lIntent);
        }
        binding.coroutineExBtn.setOnClickListener {
            val cIntent = Intent(this,TestCoroutineActivity::class.java);
            startActivity(cIntent);
        }
    }
}