package com.example.companyaplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.companyaplication.LoadingState
import com.example.companyaplication.model.MyCompanyModelApi
import com.example.companyaplication.network.NetworkClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MyCompanyRepository(private val networkClient: NetworkClient) {
    fun getMyCompany(): MutableLiveData<LoadingState<MyCompanyModelApi>>{
        val data = MutableLiveData<LoadingState<MyCompanyModelApi>>()
        data.postValue(LoadingState.loading())
        networkClient.getClient()
            .getMyCompany()
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