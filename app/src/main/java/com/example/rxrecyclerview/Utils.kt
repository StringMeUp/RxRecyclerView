package com.example.rxrecyclerview

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> MutableLiveData<T>.observeNotNull(owner: LifecycleOwner, invoke: (f: T) -> Unit ){
    this.observe(owner, Observer{ it?.let(invoke) })
}