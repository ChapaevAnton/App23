package com.example.app23.fruit

import androidx.recyclerview.widget.DiffUtil
import com.example.app23.fruit.data.ItemModel

// TODO: 19.06.2021 23.4 DiffUtil 
class ItemDiff(private val newItemFruit: ArrayList<ItemModel>, private val oldItemFruit: ArrayList<ItemModel>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItemFruit.size
    }

    override fun getNewListSize(): Int {
        return newItemFruit.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return newItemFruit[newItemPosition].id == oldItemFruit[oldItemPosition].id
        }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItemFruit = oldItemFruit[oldItemPosition]
        val newItemFruit = newItemFruit[newItemPosition]
        return oldItemFruit.id == newItemFruit.id &&
                oldItemFruit.name == newItemFruit.name &&
                oldItemFruit.description == newItemFruit.description
    }
}