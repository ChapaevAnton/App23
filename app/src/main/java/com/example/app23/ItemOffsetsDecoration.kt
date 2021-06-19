package com.example.app23

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetsDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    private val image: Bitmap? =
        ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)?.toBitmap()

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //фон
        image?.let { btm ->
            c.drawBitmap(
                btm,
                Rect(0, 0, btm.width, btm.height),
                Rect(0, 0, btm.width, btm.height), null
            )
        }

        parent.children.forEachIndexed { index, view ->
            if (index % 2 == 0) view.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.purple_200
                )
            ) else
                view.setBackgroundResource(R.color.purple_700)
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val marginTop = context.resources.getDimension(R.dimen.top_margin_item).toInt()
        val marginLeft = context.resources.getDimension(R.dimen.left_margin_item).toInt()
        outRect.set(marginLeft, marginTop, marginLeft, marginTop)
    }
}