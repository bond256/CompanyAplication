package com.example.companyaplication.filterdialog

import android.content.DialogInterface
import androidx.fragment.app.FragmentManager
import com.example.companyaplication.R
import com.example.companyaplication.base.BaseFilterDialog


class ActivityDialogFragment : BaseFilterDialog() {
    override val layoutId: Int = R.layout.activity_dialog_fragment
    private var listener: ActivityFilterDialogListener? = null

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onDismiss()
        listener = null
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
        fun onSave()
        fun onBack()
        fun onDismiss()
    }


}