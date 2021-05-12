package com.example.companyaplication.filterdialog

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.FragmentManager
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFilterDialog
import com.example.companyaplication.common.FilterType
import com.example.companyaplication.common.TypeFilterView
import kotlinx.android.synthetic.main.activity_dialog_fragment.*


class ActivityDialogFragment : BaseFilterDialog() {
    override val layoutId: Int = R.layout.activity_dialog_fragment
    private var listener: ActivityFilterDialogListener? = null
    private var type: FilterType? = null
    private var views: TypeFilterView? = null

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onDismiss()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stepButton = context?.let { TypeFilterView(it) }
        val kmButton = context?.let { TypeFilterView(it) }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.marginStart = 20
        params.weight = 1F
        stepButton?.layoutParams = params
        stepButton?.setIcon(R.drawable.ic_direction)
        stepButton?.setText("Step")
        kmButton?.layoutParams = params
        kmButton?.setIcon(R.drawable.ic_baseline_location_on_24)
        kmButton?.setText("Km")
        filter_type_layout.addView(stepButton)
        filter_type_layout.addView(kmButton)

        stepButton?.setOnClickListener { listener?.onSave(FilterType.STEPS) }
        kmButton?.setOnClickListener { listener?.onSave(FilterType.KM) }
        save_btn.setOnClickListener {  }
//        for (i in 0..2){
//            val params=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
//            val typeFilterView= context?.let { TypeFilterView(it) }
//            params.marginStart=20
//            params.weight= 1F
//            typeFilterView?.layoutParams=params
//            filter_type_layout.addView(typeFilterView)
//            typeFilterView?.let { typeView.add(it) }
//        }
    }


    override fun onStart() {
        super.onStart()
        this.dialog?.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    companion object {
        private fun newInstance() = ActivityDialogFragment()

        fun showFilters(
            manager: FragmentManager,
            listener: ActivityFilterDialogListener
        ): ActivityDialogFragment {
            return newInstance().apply {
                this.listener = listener
                manager.beginTransaction()
                    .add(this, ActivityDialogFragment::class.java.simpleName).commit()
            }
        }
    }

    interface ActivityFilterDialogListener {
        fun onSave(filterType: FilterType?)
        fun onBack()
        fun onDismiss()
    }


}