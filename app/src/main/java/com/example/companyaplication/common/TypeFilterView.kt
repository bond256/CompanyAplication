package com.example.companyaplication.common

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.example.companyaplication.R
import kotlinx.android.synthetic.main.type_filter_view.view.*

class TypeFilterView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        initializeLayout(context,attrs,defStyleAttr)
    }

    private fun initializeLayout(context: Context,attrs: AttributeSet?,defStyleAttr: Int){
        val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.type_filter_view,this,true)

        type_btn?.setOnClickListener { Log.d("tag", "initializeLayout: ") }

    }
}