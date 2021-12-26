package com.example.rxrecyclerview.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.rxrecyclerview.model.DisplayableItemRow
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

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
}