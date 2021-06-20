package com.example.app23.fruit

import androidx.recyclerview.widget.DiffUtil
import com.example.app23.fruit.data.FruitModel

// TODO: 19.06.2021 23.4 DiffUtil 
class FruitDiff(private val newListFruit: ArrayList<FruitModel>, private val oldListFruit: ArrayList<FruitModel>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldListFruit.size
    }

    override fun getNewListSize(): Int {
        return newListFruit.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newListFruit[newItemPosition].id == oldListFruit[oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItemFruit = oldListFruit[oldItemPosition]
        val newItemFruit = newListFruit[newItemPosition]
        return oldItemFruit.idIcon == newItemFruit.idIcon &&
                oldItemFruit.name == newItemFruit.name &&
                oldItemFruit.description == newItemFruit.description
    }
}