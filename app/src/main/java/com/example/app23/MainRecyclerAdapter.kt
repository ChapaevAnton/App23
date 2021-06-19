package com.example.app23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerAdapter :
    RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerHolder>() {


    private var listItem: List<Int> =
        generateSequence(0) { it + 1 }.takeWhile { it <= 100 }.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MainRecyclerHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainRecyclerHolder, position: Int) {
        holder.onBind(listItem, position)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    inner class MainRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(listItem: List<Int>, position: Int) {
            (itemView as TextView).apply {
                textSize = 20f
                text = listItem[position].toString()
//                if (position % 2 == 0) setBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.purple_200
//                    )
//                ) else
//                    setBackgroundColor(ContextCompat.getColor(context, R.color.purple_700))
            }
        }
    }

}