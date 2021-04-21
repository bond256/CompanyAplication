package com.example.companyaplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.companyaplication.LoadingState
import com.example.companyaplication.model.AllTeamsModelApi
import com.example.companyaplication.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class AllTeamsRepository(
    private val allTeamsApi: NetworkClient
) {
    fun getAllTeams(): MutableLiveData<LoadingState<AllTeamsModelApi>> {
        val data = MutableLiveData<LoadingState<AllTeamsModelApi>>()
        data.postValue(LoadingState.loading())
        allTeamsApi.getClient()
            .getAllTeams()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.postValue(LoadingState.success(it))
            }, {
                data.postValue(LoadingState.error(it.localizedMessage))
            })
        return data
    }
}