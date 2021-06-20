package com.example.app23.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R
import com.example.app23.fruit.data.AdModel
import com.example.app23.fruit.data.ItemModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import org.jetbrains.annotations.NotNull

class AdDelegateAdapter :
    AbsListItemAdapterDelegate<AdModel, ItemModel, AdDelegateAdapter.AdHolder>() {

    // TODO: 20.06.2021 23.5
    inner class AdHolder(@NotNull itemAd: View) : RecyclerView.ViewHolder(itemAd) {
        private val adTitle: TextView? = itemAd.findViewById(R.id.ad_title)
        private val adDescription: TextView? = itemAd.findViewById(R.id.ad_description)

        fun onBindAd(adModel: AdModel) {
            adTitle?.text = adModel.adTitle
            adDescription?.text = adModel.adDescription
        }

    }

    override fun isForViewType(
        item: ItemModel,
        items: MutableList<ItemModel>,
        position: Int
    ): Boolean {
        return item is AdModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): AdHolder {
        return AdHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        )
    }

    override fun onBindViewHolder(item: AdModel, holder: AdHolder, payloads: MutableList<Any>) {
        holder.onBindAd(item)
    }
}