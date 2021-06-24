package com.example.app23.fruit

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.app23.fruit.data.ItemModel
import java.util.*

class SimpleItemTouchHelperCallback(private val itemAdapter: ItemAdapter) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlag = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlag, swipeFlag)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        targetHolder: RecyclerView.ViewHolder
    ): Boolean {
        val items = itemAdapter.items
        val fromPosition = viewHolder.adapterPosition
        val toPosition = targetHolder.adapterPosition

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }
        itemAdapter.notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun isLongPressDragEnabled(): Boolean {
        return super.isLongPressDragEnabled()
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return super.isItemViewSwipeEnabled()
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //DiffUtil
        val newItems = arrayListOf<ItemModel>()
        newItems.addAll(itemAdapter.items)
        newItems.removeAt(viewHolder.adapterPosition)

        val diffItem = ItemDiffSwipe(newItems, itemAdapter.items)
        val diffResult = DiffUtil.calculateDiff(diffItem)

        itemAdapter.items = newItems
        diffResult.dispatchUpdatesTo(itemAdapter)

        //itemAdapter.notifyItemRemoved(viewHolder.adapterPosition)
        Log.d("TEST", "onSwiped: ${itemAdapter.items}")


    }
}