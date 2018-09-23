package com.applab.ktmvvm.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import com.applab.ktmvvm.R
import androidx.graphics.drawable.toDrawable

object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

}