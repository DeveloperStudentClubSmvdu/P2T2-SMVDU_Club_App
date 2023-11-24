package com.rishav.smvduclubapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rishav.smvduclubapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set the enter transition animation.
        window.enterTransition = android.transition.Slide()

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        auth = FirebaseAuth.getInstance()

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextLoginEmail.text.toString()
            val password = binding.editTextLoginPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // The user has successfully logged in.
                            Toast.makeText(this,"Login Successfully!", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            // The user has failed to log in.
                            Toast.makeText(this, "FAILED:${task.exception?.localizedMessage}", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}
