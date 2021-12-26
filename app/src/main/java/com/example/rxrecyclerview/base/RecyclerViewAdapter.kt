package com.example.rxrecyclerview.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rxrecyclerview.base.holders.HeaderViewHolder
import com.example.rxrecyclerview.base.holders.InfoViewHolder
import com.example.rxrecyclerview.base.holders.ProfileViewHolder
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow
import com.example.rxrecyclerview.utils.Constants
import java.lang.IllegalStateException

class RecyclerViewAdapter: BaseAdapter<DisplayableItemRow>(DisplayableItemRow.createLoadingList()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DisplayableItemRow.ItemType.CARD.ordinal -> {
                 HeaderViewHolder(HeaderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            DisplayableItemRow.ItemType.INFO.ordinal  -> {
                InfoViewHolder(InfoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            DisplayableItemRow.ItemType.PROFILE.ordinal  -> {
                ProfileViewHolder(ProfileLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> { throw IllegalStateException(Constants.WRONG_TYPE)}
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, item: DisplayableItemRow) {
        super.onBindViewHolder(holder, item)
        when(holder){
            is HeaderViewHolder -> {
                holder.bindData(item) { performClick(item) }
            }
            is InfoViewHolder -> {
                holder.bindData(item) { performClick(item) }
            }
            is ProfileViewHolder -> {
                holder.bindData(item) { performClick(item) }
            }
        }
    }

    override fun getItemViewType(item: DisplayableItemRow): Int = item.type.ordinal

}