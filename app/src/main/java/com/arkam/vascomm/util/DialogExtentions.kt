package com.arkam.vascomm.util

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.arkam.vascomm.R
import com.arkam.vascomm.databinding.DialogMainBinding
import com.arkam.vascomm.ui.profile.ProfileActivity

interface DialogDashboardListener{
    fun onCloseDialog()
}

fun Activity.showDialogDashboard(listener: DialogDashboardListener) {
    // custom dialog
    val dialog = Dialog(this, R.style.DialogSlideZoom)
    val binding = DialogMainBinding.bind(layoutInflater.inflate(R.layout.dialog_main, null))
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
    dialog.setContentView(binding.root)
    dialog.setCancelable(false)

    binding.imgClose.setOnClickListener {
        listener.onCloseDialog()
        dialog.dismiss()
    }

    binding.constraintLayoutProfileSaya.setOnClickListener {
        Intent(this@showDialogDashboard, ProfileActivity::class.java).also {
            startActivity(it)
        }
    }

    if (!isFinishing) dialog.show()
}