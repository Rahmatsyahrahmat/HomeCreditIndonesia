package com.hcid.app.ui.util

import androidx.recyclerview.widget.DiffUtil
import com.hcid.app.domain.entity.Product

class ProductDiffCallback(private val oldItems:List<Product>, private val newItems:List<Product>):
    DiffUtil.Callback(){

    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.image == newItem.image && oldItem.link == newItem.link && oldItem.name == newItem.name
    }

}