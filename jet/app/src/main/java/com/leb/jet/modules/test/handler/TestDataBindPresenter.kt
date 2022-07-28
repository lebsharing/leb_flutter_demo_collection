package com.leb.jet.modules.test.handler

import android.util.Log
import android.view.View
import android.widget.Toast
import com.leb.jet.model.test.TestAddress
import com.leb.jet.model.test.TestStudent
import kotlin.random.Random

public class TestDataBindPresenter {

    public fun onSaveClicked(view:View,name:String) {
        Log.i("jet","====onSaveClicked====");
        Toast.makeText(view.context,"" + name,Toast.LENGTH_LONG).show();
    }

    public fun onChangeAddress(address:TestAddress) {
        val cities = mutableListOf<String>("Beijing","ShangHai","Shenzhen","GuangZhou","SiChuan","HeNan","TianJin");
        val street = mutableListOf<String>("HaiDian","HongQiao","Baoshan","HuiZhou","ChengDu","ZhengZhou","WuQing")
        val _random = Random.nextInt(cities.size);
        address.city.set(cities[_random]) ;
        address.street.set(street[_random]);
    }

    public fun onChangeStudentAddress(student:TestStudent) {
        val cities = mutableListOf<String>("Beijing","ShangHai","Shenzhen","GuangZhou","SiChuan","HeNan","TianJin","MengGu","WuHan");
        val random = Random.nextInt(cities.size);
        student.address = cities[random];
    }
}