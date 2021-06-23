package com.example.app23.fruit

import com.example.app23.fruit.data.ItemModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ItemAdapter(var listItem: ArrayList<ItemModel>) : ListDelegationAdapter<List<ItemModel>>() {

    init {
        delegatesManager.addDelegate(FruitDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
        delegatesManager.addDelegate(ProductDelegateAdapter())
        setItems(listItem)
    }

    override fun setItems(items: List<ItemModel>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    // TODO: 19.06.2021 23.4 Payloads

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

}