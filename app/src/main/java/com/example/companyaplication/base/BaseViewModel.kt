package com.example.companyaplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.companyaplication.LoadingState

abstract class BaseViewModel: ViewModel() {
    abstract fun fetchData()

}