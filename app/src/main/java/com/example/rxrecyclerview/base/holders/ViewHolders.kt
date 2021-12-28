package com.example.rxrecyclerview.base.holders

import androidx.core.view.isVisible
import com.example.rxrecyclerview.base.BaseAdapter
import com.example.rxrecyclerview.databinding.HeaderLayoutBinding
import com.example.rxrecyclerview.databinding.InfoLayoutBinding
import com.example.rxrecyclerview.databinding.ProfileLayoutBinding
import com.example.rxrecyclerview.model.DisplayableItemRow

class HeaderViewHolder(private val binding: HeaderLayoutBinding): BaseAdapter.BaseViewHolder(binding) {
    override fun bindData(item: DisplayableItemRow, performClick: () -> Unit) {
        binding.cardTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }

        binding.apply {
            contentWrapper.isVisible = item.isExtended
            penImageView.isEnabled = item.isExtended

            binding.parentContainer.setOnClickListener {
                BaseAdapter.invokeClickOnBackground(performClick)
                BaseAdapter.animateArrow(item.isExtended, arrowImageView)
            }
        }

    }
}

class InfoViewHolder(private val binding: InfoLayoutBinding): BaseAdapter.BaseViewHolder(binding) {
    override fun bindData(item: DisplayableItemRow, performClick: () -> Unit) {
        binding.infoTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }
        itemView.setOnClickListener { performClick.invoke() }

        binding.apply {
            penImageView.isEnabled = item.isExtended

            binding.parentContainer.setOnClickListener {
                BaseAdapter.invokeClickOnBackground(performClick)
                BaseAdapter.animateArrow(item.isExtended, arrowImageView)

            }
        }
    }
}

class ProfileViewHolder(private val binding: ProfileLayoutBinding): BaseAdapter.BaseViewHolder(binding) {
    override fun bindData(item: DisplayableItemRow, performClick: () -> Unit) {
        binding.profileTextView.text = item.type.name.lowercase().replaceFirstChar { it.uppercase() }
        itemView.setOnClickListener { performClick.invoke() }

        binding.apply {
            penImageView.isEnabled = item.isExtended

            binding.parentContainer.setOnClickListener {
                BaseAdapter.invokeClickOnBackground(performClick)
                BaseAdapter.animateArrow(item.isExtended, arrowImageView)
            }
        }
    }
}