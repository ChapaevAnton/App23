package com.example.app23.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R
import org.jetbrains.annotations.NotNull

const val FRUIT_ITEM_TYPE = 0
const val AD_ITEM_TYPE = 1

class FruitAdapter(var listItem: ArrayList<ItemModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FRUIT_ITEM_TYPE -> FruitHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
            )
            AD_ITEM_TYPE -> AdHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            FRUIT_ITEM_TYPE -> {
                val fruitHolder = holder as FruitHolder
                fruitHolder.onBindFruit(listItem[position] as FruitModel)
            }
            AD_ITEM_TYPE -> {
                val adHolder = holder as AdHolder
                adHolder.onBindAd(listItem[position] as AdModel)
            }
        }
    }

    // TODO: 20.06.2021 23.5
    override fun getItemViewType(position: Int): Int {
        return when {
            listItem[position] is FruitModel -> FRUIT_ITEM_TYPE
            listItem[position] is AdModel -> AD_ITEM_TYPE
            else -> throw IllegalArgumentException("Invalid item type")
        }

    }

    // TODO: 19.06.2021 23.4 StableIds
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
//        if (payloads.isEmpty())
//            super.onBindViewHolder(holder, position, payloads) else {
//            payloads.find { it is String && it == "icon" }
//                .let { holder.icon?.setImageResource(listFruit[position].idIcon) }
//
//            payloads.find { it is String && it == "name" }
//                .let { holder.name?.text = listFruit[position].name }
//
//            payloads.find { it is String && it == "description" }
//                .let { holder.description?.text = listFruit[position].description }
//        }
//    }

    // TODO: 19.06.2021 23.4 StableIds
//    override fun getItemId(position: Int): Long {
//        return listFruit[position].hashCode().toLong()
//    }

    override fun getItemCount(): Int = listItem.size

    inner class FruitHolder(@NotNull itemFruit: View) : RecyclerView.ViewHolder(itemFruit) {
        val icon: ImageView? = itemFruit.findViewById(R.id.icon)
        val name: TextView? = itemFruit.findViewById(R.id.text_name)
        val description: TextView? = itemFruit.findViewById(R.id.text_description)

        fun onBindFruit(fruitModel: FruitModel) {
            icon?.setImageResource(fruitModel.idIcon)
            name?.text = fruitModel.name
            description?.text = fruitModel.description
        }
    }

    // TODO: 20.06.2021 23.5
    inner class AdHolder(@NotNull itemAd: View) : RecyclerView.ViewHolder(itemAd) {
        val adTitle: TextView? = itemAd.findViewById(R.id.ad_title)
        val adDescription: TextView? = itemAd.findViewById(R.id.ad_description)

        fun onBindAd(adModel: AdModel) {
            adTitle?.text = adModel.adTitle
            adDescription?.text = adModel.adDescription
        }

    }


}