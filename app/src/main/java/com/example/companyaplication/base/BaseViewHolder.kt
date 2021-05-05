package com.example.companyaplication.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import retrofit2.http.POST

abstract class BaseViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {
     abstract fun bind(item: T, position:Int)
}