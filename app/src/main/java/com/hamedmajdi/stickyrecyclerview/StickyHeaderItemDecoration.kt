package com.hamedmajdi.stickyrecyclerview

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StickyHeaderItemDecoration(private val adapter: CustomAdapter) :
    RecyclerView.ItemDecoration() {

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val firstVisiblePosition =
            (parent.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if (firstVisiblePosition == RecyclerView.NO_POSITION) return

        val currentHeaderPosition =
            if (adapter.getItemViewType(firstVisiblePosition) == CustomAdapter.VIEW_TYPE_HEADER) {
                firstVisiblePosition
            } else {
                findPreviousHeaderPosition(firstVisiblePosition)
            }

        if (currentHeaderPosition != RecyclerView.NO_POSITION) {
            val header = createHeaderView(parent, currentHeaderPosition)
            fixHeaderOffset(parent, header, firstVisiblePosition)
            drawHeader(c, header)
        }
    }

    private fun findPreviousHeaderPosition(position: Int): Int {
        for (i in position downTo 0) {
            if (adapter.getItemViewType(i) == CustomAdapter.VIEW_TYPE_HEADER) {
                return i
            }
        }
        return RecyclerView.NO_POSITION
    }

    private fun createHeaderView(parent: RecyclerView, headerPosition: Int): View {
        val headerViewHolder = adapter.onCreateViewHolder(parent, CustomAdapter.VIEW_TYPE_HEADER)
        adapter.onBindViewHolder(headerViewHolder, headerPosition)

        val widthSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        val heightSpec =
            View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)
        headerViewHolder.itemView.measure(widthSpec, heightSpec)
        headerViewHolder.itemView.layout(
            0,
            0,
            headerViewHolder.itemView.measuredWidth,
            headerViewHolder.itemView.measuredHeight
        )

        return headerViewHolder.itemView
    }

    private fun fixHeaderOffset(parent: RecyclerView, header: View, firstVisiblePosition: Int) {
        var offset = 0f
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)

            if (position != RecyclerView.NO_POSITION && adapter.getItemViewType(position) == CustomAdapter.VIEW_TYPE_HEADER) {
                if (child.top < header.height && child.top > 0) {
                    offset = (child.top - header.height).toFloat()
                }
            }
        }
        header.translationY = offset
    }

    private fun drawHeader(c: Canvas, header: View) {
        c.save()
        c.translate(0f, header.translationY)
        header.draw(c)
        c.restore()
    }
}
