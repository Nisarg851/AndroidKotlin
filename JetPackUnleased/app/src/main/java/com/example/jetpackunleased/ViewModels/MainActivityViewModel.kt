package com.example.jetpackunleased.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var _count: MutableLiveData<Int> = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun incrementCount(){
        _count.value = _count.value?.plus(1)
    }
}