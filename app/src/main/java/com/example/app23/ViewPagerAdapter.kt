package com.example.app23

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    private val colorList =
        listOf(Color.CYAN, Color.RED, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.DKGRAY)


    inner class ViewPagerHolder(itemViewPager: View) : RecyclerView.ViewHolder(itemViewPager) {

        val textView: TextView = itemViewPager.findViewById(R.id.view_pager_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        return ViewPagerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_view_pager, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.textView.text = (position + 1).toString()
        holder.textView.setBackgroundColor(colorList[position])
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

}