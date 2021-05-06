package com.example.companyaplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

abstract class BaseFilterDialog: DialogFragment() {
    abstract val layoutId:Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId,container,false)
    }

    fun onBackPressed(){
        activity?.onBackPressed()
    }

}