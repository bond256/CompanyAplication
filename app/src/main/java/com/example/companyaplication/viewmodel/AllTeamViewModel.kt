package com.example.companyaplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.companyaplication.App
import com.example.companyaplication.LoadingState
import com.example.companyaplication.base.BaseViewModel
import com.example.companyaplication.model.AllTeamData
import com.example.companyaplication.model.AllTeamsModelApi
import com.example.companyaplication.network.NetworkClient
import com.example.companyaplication.repository.AllTeamsRepository

class AllTeamViewModel : BaseViewModel() {

    var data=MutableLiveData<LoadingState<AllTeamsModelApi>>()

    init {
        fetchData()
    }

    override fun fetchData() {
        data=App.allTeamsRepository
            .getAllTeams()
    }

    override fun onCleared() {
        super.onCleared()
    }


}