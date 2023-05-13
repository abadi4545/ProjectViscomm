package com.arkam.vascomm.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arkam.vascomm.databinding.ActivityRegisterBinding
import com.arkam.vascomm.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val namaDepan = binding.tvNamaDepan.text.toString()
            val namaBelakang = binding.tvNamaBelakang.text.toString()
            val noKTP = binding.tvNoKtp.text.toString()
            val noTelpon = binding.tvNoTelpon.text.toString()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            val confirmPassword = binding.tvKonfrimasiPassword.text.toString()


            if (namaDepan.isNotEmpty() && namaBelakang.isNotEmpty() && noKTP.isNotEmpty() && noTelpon.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }

            binding.tvEditSudahPunyaAkun.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))

            }
        }
    }

}