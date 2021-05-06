package com.example.companyaplication.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.companyaplication.R
import kotlinx.android.synthetic.main.filter_buttons_view.view.*

class FilterButtonsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?=null,
    defStyleAttr: Int=0
): LinearLayout(context,attrs,defStyleAttr) {

    private var listener:FilterSelectListener?=null

    init {
        initializeLayout(context,attrs,defStyleAttr)
    }


    private fun initializeLayout(context: Context,attrs: AttributeSet?,defStyleAttr: Int){
        val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.filter_buttons_view,this,true)

       // val a=context.obtainStyledAttributes(attrs,R.styleable.)

        activity_filter_button?.setOnClickListener { listener?.onActivityClick() }
        time_filter_button?.setOnClickListener { listener?.onTimeClick() }

    }

    fun setFilterSelectListener(filterSelectListener: FilterSelectListener){
        listener=filterSelectListener
    }


    fun setTextActivity(text:String){
        activity_text.text=text
    }

    fun setTextTime(text:String){
        time_text.text=text
    }

    fun setImageActivity(res:Int){
        activity_image?.setImageResource(res)
    }

    interface FilterSelectListener{
        fun onActivityClick()
        fun onTimeClick()
    }
}