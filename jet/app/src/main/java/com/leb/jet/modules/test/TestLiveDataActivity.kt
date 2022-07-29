package com.leb.jet.modules.test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.leb.jet.R
import com.leb.jet.databinding.ActivityTestLiveDataBinding
import com.leb.jet.modules.test.model.TestNameViewModel
import kotlin.random.Random

/**
 * 1、LiveData的简单使用
 * 2、使用步骤：
 *  （1）创建 LiveData 的实例以存储某种类型的数据。这通常在 ViewModel 类中完成。
 *  （2）创建可定义 onChanged() 方法的 Observer 对象，该方法可以控制当 LiveData 对象存储的数据更改时会发生什么。
 *  通常情况下，您可以在界面控制器（如 Activity 或 Fragment）中创建 Observer 对象。
 *  （3）使用 observe() 方法将 Observer 对象附加到 LiveData 对象。observe() 方法会采用 LifecycleOwner 对象。
 *  这样会使 Observer 对象订阅 LiveData 对象，以使其收到有关更改的通知。通常情况下，您可以在界面控制器（如 Activity
 *  或 Fragment）中附加 Observer 对象。
 */
class TestLiveDataActivity:FragmentActivity() {

    lateinit var binding:ActivityTestLiveDataBinding;
    private val nameModel:TestNameViewModel by viewModels<TestNameViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestLiveDataBinding.inflate(layoutInflater);
        setContentView(binding.root);

        // Create the observer which updates the UI.
        val nameObserver = Observer<String>{ newName ->
            binding.currentNameTv.text = newName;
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        nameModel.currentName.observe(this,nameObserver);
        binding.updateBtn.setOnClickListener {
            val namesList = mutableListOf<String>("ZhangSan","lisi","Wang","Qian","Gong","Liu");
            val random = Random.nextInt(namesList.size);
            nameModel.currentName.value = namesList[random];
        }
    }
}