package com.leb.jet.modules.test

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.leb.jet.databinding.ActivityTestDataStoreBinding
import com.leb.jet.modules.test.store.UserPreference
import com.leb.jet.modules.test.store.UserViewModel
import com.leb.jet.modules.test.store.userDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random


class TestDataStoreActivity:FragmentActivity() {

    lateinit var binding:ActivityTestDataStoreBinding;
//    val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = "test_store");

    val userProgrss = """
        1、创建 Preferences DataStore
         eg:val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        2、从 Preferences DataStore 读取内容
    """.trimIndent()

//    lateinit var userPreference: UserPreference;
    lateinit var userViewModel: UserViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View binding
        binding = ActivityTestDataStoreBinding.inflate(layoutInflater);
        setContentView(binding.root)

        userViewModel = UserViewModel(UserPreference(userDataStore))
        binding.backIv.setOnClickListener { finish() }

        binding.setNameBtn.setOnClickListener{
            userViewModel.setName();
        }
        val nameObserver = Observer<String>{ newName ->
            binding.userNameTv.text = newName;
        }
        userViewModel.getUserName().observe(this,nameObserver)
        binding.getNameBtn.setOnClickListener {
            //TODO 怎么将Flow<String>转换为String
            userViewModel.getUserName()
        }
    }

}