package com.example.app23.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R
import com.example.app23.fruit.data.FruitModel
import com.example.app23.fruit.data.ItemModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import org.jetbrains.annotations.NotNull

class FruitDelegateAdapter :
    AbsListItemAdapterDelegate<FruitModel, ItemModel, FruitDelegateAdapter.FruitHolder>() {

    inner class FruitHolder(@NotNull itemFruit: View) : RecyclerView.ViewHolder(itemFruit) {
        private val icon: ImageView? = itemFruit.findViewById(R.id.icon_fruit)
        private val name: TextView? = itemFruit.findViewById(R.id.text_name_fruit)
        private val description: TextView? = itemFruit.findViewById(R.id.text_description_fruit)

        fun onBindFruit(fruitModel: FruitModel) {
            icon?.setImageResource(fruitModel.idIcon)
            name?.text = fruitModel.name
            description?.text = fruitModel.description
        }
    }

    override fun isForViewType(
        item: ItemModel,
        items: MutableList<ItemModel>,
        position: Int
    ): Boolean {
        return item is FruitModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): FruitHolder {
        return FruitHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        )
    }

    override fun onBindViewHolder(
        item: FruitModel,
        holder: FruitHolder,
        payloads: MutableList<Any>
    ) {
        holder.onBindFruit(item)
    }

}