package com.example.rxrecyclerview.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

//Android Util
fun <T> MutableLiveData<T>.observeNotNull(owner: LifecycleOwner, invoke: (f: T) -> Unit) {
    this.observe(owner, Observer { it?.let(invoke) })
}