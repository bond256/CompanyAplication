package com.example.companyaplication.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.companyaplication.App
import com.example.companyaplication.LoadingState
import com.example.companyaplication.base.BaseViewModel
import com.example.companyaplication.model.MyCompanyModelApi
import com.example.companyaplication.network.NetworkClient
import com.example.companyaplication.repository.MyCompanyRepository

class MyCompanyViewModel : BaseViewModel() {

    var data = MutableLiveData<LoadingState<MyCompanyModelApi>>()

    init {
        fetchData()
    }

    override fun fetchData() {
        data = App.myCompanyRepository
            .getMyCompany()
    }

}