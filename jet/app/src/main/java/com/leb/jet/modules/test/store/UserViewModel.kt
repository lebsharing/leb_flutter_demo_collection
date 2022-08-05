package com.leb.jet.modules.test.store

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class UserViewModel(private val userPreferences:UserPreference):ViewModel() {

    fun setName() {
        val nameList:List<String> = listOf("ZhangSan","Lisi","BeiJing","TianJin","SiChuan","HeNan");
        val index = Random.nextInt(nameList.size)
        val name = nameList[index];
        viewModelScope.launch {
            Log.i("fxz","----name:$name")
            userPreferences.setUserName(name)
        }
    }

    fun getUserName():LiveData<String>{
        return userPreferences.getUserName().asLiveData();
    }
}