package com.leb.jet.modules.test

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.leb.jet.R
import com.leb.jet.databinding.ActivityTestDataBindBinding
import com.leb.jet.model.test.TestAddress
import com.leb.jet.model.test.TestStudent
import com.leb.jet.model.test.TestUser
import com.leb.jet.modules.test.handler.TestDataBindHandler
import com.leb.jet.modules.test.handler.TestDataBindPresenter

/**
 * 1、本类用来示例数据绑定的基本使用
 * 2、
 */
class TestDataBindActivity: FragmentActivity() {
    lateinit var binding:ActivityTestDataBindBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //实现方式一，数据绑定
        binding = DataBindingUtil.setContentView<ActivityTestDataBindBinding>(this,
            R.layout.activity_test_data_bind);

        //方式二，结合试图绑定
        //使用该方式，试图不显示？TODO WHY
//        binding = ActivityTestDataBindBinding.inflate(layoutInflater);

        //数据绑定，xml文件中的注释可能影响binding的生成。
        binding.handlers = TestDataBindHandler();
        binding.presenter = TestDataBindPresenter();
        binding.testUser = TestUser("Enbo","Li",18,);
        binding.testAddress = TestAddress().apply {
            city.set("Beijing");
            street.set("西三旗")
        }
        binding.testStudent = TestStudent().apply {
            name = "ZhangSan";
            address = "Beijing";
        }
    }
}