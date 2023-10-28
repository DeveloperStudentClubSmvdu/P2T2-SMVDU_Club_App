package com.rishav.smvduclubapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rishav.smvduclubapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


//        val textViewLoginHere = findViewById<TextView>(R.id.textViewLoginHere)
        binding.textViewLoginHere.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.buttonRegister.setOnClickListener {
            val name = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (email.isNotEmpty() && name.isNotEmpty() && password.isNotEmpty()){
                MainActivity.auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}