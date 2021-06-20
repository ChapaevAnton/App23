package com.example.app23.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R
import com.example.app23.fruit.data.ItemModel
import com.example.app23.fruit.data.ProductModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ProductDelegateAdapter :
    AbsListItemAdapterDelegate<ProductModel, ItemModel, ProductDelegateAdapter.ProductHolder>() {


    inner class ProductHolder(itemProduct: View) : RecyclerView.ViewHolder(itemProduct) {

        private val iconCount: ImageView? = itemProduct.findViewById(R.id.icon_count)
        private val textCount: TextView? = itemProduct.findViewById(R.id.text_count)
        private val textNameCount: TextView? = itemProduct.findViewById(R.id.text_name_count)
        private val textDescriptionCount: TextView? =
            itemProduct.findViewById(R.id.text_description_count)

        fun onBindProduct(productModel: ProductModel) {
            iconCount?.setImageResource(productModel.idIcon)
            textCount?.text = productModel.count.toString()
            textNameCount?.text = productModel.name
            textDescriptionCount?.text = productModel.description
        }

    }

    override fun isForViewType(
        item: ItemModel,
        items: MutableList<ItemModel>,
        position: Int
    ): Boolean {
        return item is ProductModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): ProductHolder {
        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_countable, parent, false)
        )
    }

    override fun onBindViewHolder(
        item: ProductModel,
        holder: ProductHolder,
        payloads: MutableList<Any>
    ) {
        holder.onBindProduct(item)
    }
}