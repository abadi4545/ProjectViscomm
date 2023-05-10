package com.arkam.vascomm.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arkam.vascomm.databinding.ActivityRegisterBinding

class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val inten = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(inten)
        }
        btnNext()
    }

    private fun btnNext(){
        binding.tvSudahPunyaAkun.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}