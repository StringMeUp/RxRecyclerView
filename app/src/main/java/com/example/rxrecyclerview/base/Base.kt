package com.example.rxrecyclerview.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.rxrecyclerview.model.DisplayableItemRow
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

abstract class BaseAdapter<T>(val data: ArrayList<T>) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    private val clickListenerPublishSubject = PublishSubject.create<T>()

    fun observeClickListener(): Observable<T> {
        return clickListenerPublishSubject
    }

    fun performClick(item: T?) {
        item?.let { clickListenerPublishSubject.onNext(it) }
    }

    fun updateData(updatedList: ArrayList<T>) {
        data.clear()
        data.addAll(updatedList)
        notifyDataSetChanged()
    }

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = data[holder.adapterPosition]
        onBindViewHolder(holder, item)
    }

    final override fun getItemCount(): Int = data.size
    final override fun getItemViewType(position: Int): Int = getItemViewType(data[position])

    abstract class BaseViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {
        abstract fun bindData(item: DisplayableItemRow, performClick: () -> Unit)
    }

    open fun getItemViewType(item: T) = 0
    open fun onBindViewHolder(holder: BaseViewHolder, item: T) {}

    companion object{

                        /*Shared VH Functions*/

        fun invokeClickOnBackground(performClick: () -> Unit) {
            Single.fromCallable { performClick }
                .delay(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { click -> click.invoke() }
        }

        fun animateArrow(isExtended: Boolean, view: View) {
            if (!isExtended) view.animate().rotation(180F).start()
            else view.animate().rotation(view.rotation - 180F).start()
        }

    }
}