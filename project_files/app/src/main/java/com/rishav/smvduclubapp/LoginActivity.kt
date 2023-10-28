package com.rishav.smvduclubapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.transition.Slide
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rishav.smvduclubapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the enter transition animation.
        window.enterTransition = Slide()

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextLoginEmail.text.toString()
            val password = binding.editTextLoginPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                MainActivity.auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // The user has successfully logged in.
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            // The user has failed to log in.
                            Toast.makeText(this, task.exception?.localizedMessage, Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}
