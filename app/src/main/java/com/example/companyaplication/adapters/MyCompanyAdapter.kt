package com.example.companyaplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.companyaplication.App
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseAdapter
import com.example.companyaplication.base.BaseViewHolder
import com.example.companyaplication.model.MyCompanyData
import kotlinx.android.synthetic.main.my_company_item.view.*

class MyCompanyAdapter(private val items: List<MyCompanyData>) : BaseAdapter<MyCompanyData>(items) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<MyCompanyData> {
        return when (viewType) {
            ITEM_VIEW_FILTER -> MyCompanyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.my_company_item, parent, false)
            )
            ITEM_VIEW_DATA -> MyCompanyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.my_company_item, parent, false)
            )
            else -> throw IllegalArgumentException()
        }
    }

    companion object {
        const val ITEM_VIEW_FILTER = 0
        const val ITEM_VIEW_DATA = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ITEM_VIEW_FILTER
        } else{
            ITEM_VIEW_DATA
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MyCompanyViewHolder(itemView: View) : BaseViewHolder<MyCompanyData>(itemView) {
        override fun bind(item: MyCompanyData, position: Int) {
            itemView.comapany_rank.text = item.rank.toString()
            itemView.name_company.text = item.displayName
            itemView.total_company.text = item.total.toString()
            Glide
                .with(App.instance)
                .load("https://static0.fitbit.com/images/profile/defaultProfile_150.png")
                .centerCrop()
                .into(itemView.avatar_company)
        }

    }

    inner class FilterPanelViewHolder(itemView: View) {

    }


}