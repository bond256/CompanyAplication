package com.example.companyaplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companyaplication.R
import com.example.companyaplication.State
import com.example.companyaplication.adapters.AllTeamsAdapter
import com.example.companyaplication.base.BaseFragment
import com.example.companyaplication.model.AllTeamData
import com.example.companyaplication.viewmodel.AllTeamViewModel
import kotlinx.android.synthetic.main.all_team_fragment.*

class AllTeamFragment : BaseFragment() {

    override val layoutId: Int = R.layout.all_team_fragment

    private lateinit var viewModel: AllTeamViewModel

    private val dataResult: MutableList<AllTeamData> by lazy { mutableListOf() }
    private val adapters: AllTeamsAdapter by lazy { AllTeamsAdapter(dataResult) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        viewModel = ViewModelProvider(this).get(AllTeamViewModel::class.java)

        viewModel.data.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                State.SUCCESS -> {
                    hidePlaceHolder()
                    dataResult.clear()
                    it.data?.results?.let { it1 -> dataResult.addAll(it1) }
                    adapters.notifyDataSetChanged()
                }
                State.ERROR -> Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                State.LOADING -> showPlaceHolder()
            }
        })

    }

    private fun initRecycler() {
        all_teams_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapters
        }
    }

    private fun showPlaceHolder() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hidePlaceHolder() {
        //Thread.sleep(10000)
        progressBar.visibility = View.GONE
    }


}