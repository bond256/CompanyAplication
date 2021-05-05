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
import com.example.companyaplication.adapters.MyCompanyAdapter
import com.example.companyaplication.base.BaseFragment
import com.example.companyaplication.filterdialog.ActivityDialogFragment
import com.example.companyaplication.model.AllTeamData
import com.example.companyaplication.model.MyCompanyData
import com.example.companyaplication.viewmodel.MyCompanyViewModel
import kotlinx.android.synthetic.main.all_team_fragment.*
import kotlinx.android.synthetic.main.my_company_fragment.*

class MyCompanyFragment : BaseFragment(),ActivityDialogFragment.ActivityFilterDialogListener {

    override val layoutId: Int=R.layout.my_company_fragment

    private lateinit var viewModel: MyCompanyViewModel
    private var activityDialogFragment:ActivityDialogFragment?=null

    private val dataResult: MutableList<MyCompanyData> by lazy { mutableListOf() }
    private val adapters: MyCompanyAdapter by lazy { MyCompanyAdapter(dataResult) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        viewModel = ViewModelProvider(this).get(MyCompanyViewModel::class.java)

        viewModel.data.observe(viewLifecycleOwner, Observer {
            when(it.state){
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
        activity_filter_button.setOnClickListener { ActivityDialogFragment.showFilters(childFragmentManager,this) }
    }


    private fun initRecycler(){
        my_company_recycler?.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=adapters
        }
    }

    private fun showPlaceHolder() {
        progressBar2.visibility = View.VISIBLE
    }

    private fun hidePlaceHolder() {
        //Thread.sleep(1000)
        progressBar2.visibility = View.GONE
    }

    override fun onSave() {
        TODO("Not yet implemented")
    }

    override fun onBack() {
        activityDialogFragment?.dismiss()
        onDismiss()
    }

    override fun onDismiss() {
        activityDialogFragment=null
    }

}