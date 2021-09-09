package com.matheusbrandao.pokemon.ui.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T, TH : RecyclerView.ViewHolder>(private var items: List<T>) :
    RecyclerView.Adapter<TH>() {

    open fun getItemByPosition(position: Int) = items[position]

    fun replaceData(items: List<T>) {
        setList(items)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int) = position.toLong()

    private fun setList(list: List<T>) {
        this.items = list
        notifyDataSetChanged()
    }
}