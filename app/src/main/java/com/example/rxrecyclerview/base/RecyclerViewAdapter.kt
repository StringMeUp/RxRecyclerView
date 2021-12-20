package com.example.rxrecyclerview.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow
import java.lang.IllegalStateException

class RecyclerViewAdapter: BaseAdapter<DisplayableItemRow>(DisplayableItemRow.createLoadingList()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DisplayableItemRow.ItemType.HEADER.ordinal -> {
                 HeaderViewHolder(HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            DisplayableItemRow.ItemType.INFO.ordinal  -> {
                InfoViewHolder(InfoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            DisplayableItemRow.ItemType.PROFILE.ordinal  -> {
                ProfileViewHolder(ProfileLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> { throw IllegalStateException("Wrong Type")}
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, item: DisplayableItemRow) {
        super.onBindViewHolder(holder, item)
        when(holder){
            is HeaderViewHolder -> {holder.bindData(item)}
            is InfoViewHolder -> {holder.bindData(item)}
            is ProfileViewHolder -> {holder.bindData(item)}
        }
    }

    override fun getItemViewType(item: DisplayableItemRow): Int = item.type.ordinal

}