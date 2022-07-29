package com.leb.jet.modules.test.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestNameViewModel : ViewModel() {
    //create a livedata with a String
    val currentName: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}