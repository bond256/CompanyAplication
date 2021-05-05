package com.example.companyaplication.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(private val items:List<T>) :RecyclerView.Adapter<BaseViewHolder<T>>() {


    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(items[position],position)
    }
}