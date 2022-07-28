package com.leb.jet.model.test

import androidx.databinding.ObservableField

data class TestUser(val firstName:String,val lastName:String,val age:Int)

class  TestAddress {
    val city = ObservableField<String>();
    val street = ObservableField<String>();
}
