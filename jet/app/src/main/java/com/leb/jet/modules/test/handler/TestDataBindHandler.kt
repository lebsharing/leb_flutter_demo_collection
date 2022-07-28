package com.leb.jet.modules.test.handler

import android.util.Log
import android.view.View
import android.widget.Toast

public class TestDataBindHandler {

    //数据绑定-事件处理-方法引用
    //表达式中的方法签名必须与监听器对象中的方法签名完全一致。
    public fun onClickShare(view:View){
        Log.i("jet","---onClickedShare--");
        Toast.makeText(view.context,"Share",Toast.LENGTH_LONG).show();
    }
}