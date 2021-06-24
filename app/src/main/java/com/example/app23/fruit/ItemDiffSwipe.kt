package com.example.app23.fruit

import androidx.recyclerview.widget.DiffUtil
import com.example.app23.fruit.data.ItemModel

class ItemDiffSwipe(
    private val newItems: List<ItemModel>,
    private val oldItems: List<ItemModel>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newItems[newItemPosition].id == oldItems[oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}