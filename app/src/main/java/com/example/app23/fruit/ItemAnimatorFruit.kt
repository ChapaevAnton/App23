package com.example.app23.fruit

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.R

class ItemAnimatorFruit(private val context: Context) : DefaultItemAnimator() {

    private val addItemAnim: Animation = AnimationUtils.loadAnimation(context, R.anim.add_item_anim_to_left)
    private val removeItemAnim: Animation = AnimationUtils.loadAnimation(context,R.anim.remove_item_anim_to_right)

    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(addItemAnim)
    }

    override fun getAddDuration(): Long {
        return addItemAnim.duration
    }

    override fun onRemoveStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(removeItemAnim)
    }

    override fun getRemoveDuration(): Long {
        return removeItemAnim.duration
    }
}