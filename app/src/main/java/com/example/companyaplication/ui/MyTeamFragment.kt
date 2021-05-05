package com.example.companyaplication.ui

import android.os.Bundle
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFragment
import com.example.companyaplication.viewmodel.MyTeamViewModel

class MyTeamFragment : BaseFragment() {

    private lateinit var viewModel: MyTeamViewModel
    override val layoutId: Int=R.layout.my_team_fragment


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MyTeamViewModel::class.java)
    }

}