package com.example.rxrecyclerview.base.holders

import com.example.rxrecyclerview.base.BaseAdapter
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow

class HeaderViewHolder(private val binding: HeaderLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.cardTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }
    }
}

class InfoViewHolder(private val binding: InfoLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.infoTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }
    }
}

class ProfileViewHolder(private val binding: ProfileLayoutBinding): BaseAdapter.BaseViewHolder(binding){
    override fun bindData(item: DisplayableItemRow) {
        binding.profileTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }
    }
}