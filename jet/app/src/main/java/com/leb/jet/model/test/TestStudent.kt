package com.leb.jet.model.test

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.leb.jet.BR

/**
 *
 */
class TestStudent : BaseObservable(){

    @get:Bindable
    var name:String = ""
        set(value) {
            field = value;
            notifyPropertyChanged(BR.name);
        }

    @get:Bindable
    var address:String= ""
        set(value) {
            field = value;
            notifyPropertyChanged(BR.address)
        }

}