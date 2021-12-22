package com.example.rxrecyclerview.model

data class DisplayableItemRow(
    val type: ItemType,
    var isSkeletonVisible: Boolean = true,
    var isExtended: Boolean = false,
    var data: Any? = null,
    var error: Throwable? = null
){
    enum class ItemType{
        CARD,
        INFO,
        PROFILE
    }

    companion object {
        fun createLoadingList(): ArrayList<DisplayableItemRow> {
            return ArrayList(ItemType.values().map { DisplayableItemRow(it, true) })
        }
    }
}

data class Mock(val mockup: ArrayList<DisplayableItemRow>)