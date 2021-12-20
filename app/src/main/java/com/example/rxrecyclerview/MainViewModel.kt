package com.example.rxrecyclerview

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxrecyclerview.model.DisplayableItemRow
import com.example.rxrecyclerview.model.Mock
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign

class MainViewModel : ViewModel() {

    private var disposable = CompositeDisposable()
    private val mockData = ArrayList<DisplayableItemRow>()

    val data = MutableLiveData<ArrayList<DisplayableItemRow>>()

    fun initRaw(context: Context){
        val gson = Gson()
        val mockDataJsonString = context.resources
            .openRawResource(R.raw.mockup)
            .bufferedReader().use { it.readText() }

         val data = gson.fromJson<Mock>(
            mockDataJsonString,
            Mock::class.java
        )

        mockData.apply {
            clear()
            addAll(data.mockup)
        }

        mapData()
    }

    private fun mapData() {
        disposable += Single.just(mockData)
            .onErrorResumeNext { Single.just(arrayListOf()) }
            .toObservable()
            .subscribe(
                { items ->
                    data.postValue(items)
                },
                {
                    Log.d("THROWABLE", "getData: $it")

                })
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}