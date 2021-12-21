package com.example.rxrecyclerview.base.holders

import com.example.rxrecyclerview.base.BaseAdapter
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow

class HeaderViewHolder(private val binding: HeaderLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.addressTextView.text = item.type.name
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