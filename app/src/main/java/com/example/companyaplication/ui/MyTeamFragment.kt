package com.example.companyaplication.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFragment

class MyTeamFragment : BaseFragment() {

    private lateinit var viewModel: MyTeamViewModel
    override val layoutId: Int=R.layout.my_team_fragment


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MyTeamViewModel::class.java)
    }

}