package com.example.app23.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R

class PeopleRecyclerAdapter : RecyclerView.Adapter<PeopleRecyclerAdapter.PeopleRecyclerHolder>() {

    var listPeople = mutableListOf<People>()
        set(value) {
            listPeople.clear()
            listPeople.addAll(value)
        }

    inner class PeopleRecyclerHolder(itemViewPeople: View) :
        RecyclerView.ViewHolder(itemViewPeople) {
        private val number: TextView = itemViewPeople.findViewById(R.id.number)
        private val name: TextView = itemViewPeople.findViewById(R.id.name)
        private val age: TextView = itemViewPeople.findViewById(R.id.age)

        fun onBindItem(people: People, position: Int) {
            number.text = position.toString()
            name.text = people.name
            age.text = people.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleRecyclerHolder {
        return PeopleRecyclerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_people, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PeopleRecyclerHolder, position: Int) {
        holder.onBindItem(listPeople[position], position)
    }

    override fun getItemCount(): Int {
        return listPeople.size
    }

}