package com.arkam.vascomm.ui.login


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arkam.vascomm.data.network.ApiConfig
import com.arkam.vascomm.data.network.ApiService
import com.arkam.vascomm.data.network.response.LoginResponse
import com.arkam.vascomm.databinding.ActivityLoginBinding
import com.arkam.vascomm.model.LoginUser
import com.arkam.vascomm.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()

    }

    fun initAction(){
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            login()
        }
    }

    fun login(){
        val request = LoginUser()
        request.email = binding.tvEditEmail.text.toString().trim()
        request.password =  binding.tvEditPassword.text.toString().trim()

        val retro = ApiConfig().getRetroClientInstance().create(ApiService::class.java)
        retro.userLogin(request).enqueue(object : retrofit2.Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val user = response.body()
                Log.e("token", user!!.token.toString())
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })
    }

}