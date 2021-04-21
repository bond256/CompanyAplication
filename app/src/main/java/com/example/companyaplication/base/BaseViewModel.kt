package com.example.companyaplication.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    abstract fun fetchData()

}