package com.example.companyaplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseAdapter
import com.example.companyaplication.base.BaseViewHolder
import com.example.companyaplication.model.AllTeamData
import com.example.companyaplication.model.AllTeamsModelApi
import kotlinx.android.synthetic.main.all_teams_item.view.*

class AllTeamsAdapter(private val items: List<AllTeamData>): BaseAdapter<AllTeamData>(items) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<AllTeamData> {
        return AllTeamsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.all_teams_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class AllTeamsViewHolder(itemView: View): BaseViewHolder<AllTeamData>(itemView){
        override fun bind(item: AllTeamData, position: Int) {
            itemView.rank.text=item.rank.toString()
            itemView.name.text=item.displayName
        }

    }
}