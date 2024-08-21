package com.hamedmajdi.stickyrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val items: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HeaderData -> VIEW_TYPE_HEADER
            is ItemRowData -> VIEW_TYPE_ITEM
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
                HeaderViewHolder(view)
            }
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
                ItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val headerData = items[position] as HeaderData
                holder.bind(headerData)
            }
            is ItemViewHolder -> {
                val itemRowData = items[position] as ItemRowData
                holder.bind(itemRowData)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.headerTitle)
        private val headerLayout: View = itemView.findViewById(R.id.headerLayout)

        @SuppressLint("ResourceAsColor")
        fun bind(headerData: HeaderData) {
            title.text = headerData.title
            title.setTextColor(headerData.color)
//            headerLayout.setBackgroundColor(headerData.color)
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.itemTitle)
        private val desc: TextView = itemView.findViewById(R.id.itemDesc)
        private val stock: TextView = itemView.findViewById(R.id.itemStock)

        fun bind(itemRowData: ItemRowData) {
            title.text = itemRowData.title
            desc.text = itemRowData.desc
            stock.text = itemRowData.stock?.toString()
        }
    }
}
