package com.example.rxrecyclerview.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow

abstract class BaseAdapter<T>(val data: ArrayList<T>): RecyclerView.Adapter<BaseAdapter.BaseViewHolder>(){

    fun updateData(updatedList: ArrayList<T>) {
        data.clear()
        data.addAll(updatedList)
        notifyDataSetChanged()
    }

    final override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = data[holder.adapterPosition]
        onBindViewHolder(holder, item)
    }

    //no need to override
    final override fun getItemCount(): Int = data.size
    //no need to override
    final override fun getItemViewType(position: Int): Int = getItemViewType(data[position])

    //to inherit
    open fun getItemViewType(item: T) = 0
    open fun onBindViewHolder(holder: BaseViewHolder, item: T) {}

    // BASE VIEWHOLDER
    abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bindData(item: DisplayableItemRow)
    }
}

                                            /*ALL HOLDERS*/


class HeaderViewHolder(private val binding: HeaderLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.headerTitle.text = item.type.name
    }
}

class InfoViewHolder(private val binding: InfoLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.infoTitle.text = item.type.name
    }
}

class ProfileViewHolder(private val binding: ProfileLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.profileTitle.text = item.type.name
    }
}