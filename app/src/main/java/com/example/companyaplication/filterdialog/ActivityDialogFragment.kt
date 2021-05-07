package com.example.companyaplication.filterdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFilterDialog
import com.example.companyaplication.common.FilterType
import kotlinx.android.synthetic.main.activity_dialog_fragment.*


class ActivityDialogFragment : BaseFilterDialog() {
    override val layoutId: Int = R.layout.activity_dialog_fragment
    private var listener: ActivityFilterDialogListener? = null
    private var type:FilterType?=null

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onDismiss()
        listener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //step_button.setOnClickListener { type=FilterType.STEPS }
        //km_button.setOnClickListener { type=FilterType.KM }
//        button3.setOnClickListener {
//            listener?.onSave(type)
//            onBackPressed()
//            }

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