package com.example.companyaplication.ui

import android.os.BaseBundle
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFragment

class AllTeamFragment : BaseFragment() {

    override val layoutId: Int=R.layout.all_team_fragment

    private lateinit var viewModel: AllTeamViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(AllTeamViewModel::class.java)
    }

}