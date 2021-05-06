package com.example.companyaplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companyaplication.R
import com.example.companyaplication.State
import com.example.companyaplication.adapters.MyCompanyAdapter
import com.example.companyaplication.base.BaseFragment
import com.example.companyaplication.common.FilterButtonsView
import com.example.companyaplication.common.FilterType
import com.example.companyaplication.filterdialog.ActivityDialogFragment
import com.example.companyaplication.model.MyCompanyData
import com.example.companyaplication.viewmodel.MyCompanyViewModel
import kotlinx.android.synthetic.main.filter_buttons_view.*
import kotlinx.android.synthetic.main.my_company_fragment.*
import kotlin.math.log


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

        val t=object: FilterButtonsView.FilterSelectListener{
            override fun onActivityClick() {
                Log.d("tag", "onActivityClick: ")
                ActivityDialogFragment.showFilters(childFragmentManager,this@MyCompanyFragment)
            }

            override fun onTimeClick() {
                Log.d("tag", "onTimeClick: ")
            }

        }
        filterButtonsView.setFilterSelectListener(t)
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

    override fun onSave(filterType: FilterType?) {
        Log.d("tag", "onSave: ${filterType?.name}")
        if(filterType==FilterType.STEPS){
            filterButtonsView.setImageActivity(R.drawable.ic_baseline_directions_walk_24)
        }else{
            filterButtonsView.setImageActivity(R.drawable.ic_baseline_location_on_24)
        }
    }

    override fun onBack() {
        activityDialogFragment?.dismiss()
        onDismiss()
    }

    override fun onDismiss() {
        activityDialogFragment=null
    }

}