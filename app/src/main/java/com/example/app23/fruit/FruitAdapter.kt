package com.example.app23.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R
import org.jetbrains.annotations.NotNull

class FruitAdapter(var listFruit: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.FruitHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitHolder {
        return FruitHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FruitHolder, position: Int) {
        holder.onBind(listFruit[position])
    }

    // TODO: 19.06.2021 23.4 StableIds
    override fun onBindViewHolder(holder: FruitHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty())
            super.onBindViewHolder(holder, position, payloads) else {
            payloads.find { it is String && it == "icon" }
                .let { holder.icon?.setImageResource(listFruit[position].idIcon) }

            payloads.find { it is String && it == "name" }
                .let { holder.name?.text = listFruit[position].name }

            payloads.find { it is String && it == "description" }
                .let { holder.description?.text = listFruit[position].description }
        }
    }

    // TODO: 19.06.2021 23.4 StableIds
    override fun getItemId(position: Int): Long {
        return listFruit[position].hashCode().toLong()
    }

    override fun getItemCount(): Int = listFruit.size

    inner class FruitHolder(@NotNull itemFruit: View) : RecyclerView.ViewHolder(itemFruit) {
        val icon: ImageView? = itemFruit.findViewById(R.id.icon)
        val name: TextView? = itemFruit.findViewById(R.id.text_name)
        val description: TextView? = itemFruit.findViewById(R.id.text_description)

        fun onBind(fruit: Fruit) {
            icon?.setImageResource(fruit.idIcon)
            name?.text = fruit.name
            description?.text = fruit.description
        }

    }


}