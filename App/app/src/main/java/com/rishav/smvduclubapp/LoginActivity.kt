package com.rishav.smvduclubapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rishav.smvduclubapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth

    companion object {
        fun updateUI(user: FirebaseUser?) {
        }

        private fun reload() {
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            reload()
        }
        updateUI(currentUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set the enter transition animation.
        window.enterTransition = android.transition.Slide()

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        auth = FirebaseAuth.getInstance()

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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
                            Toast.makeText(this, "Login Successfully!", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // The user has failed to log in.
                            Toast.makeText(
                                this,
                                "FAILED:${task.exception?.localizedMessage}",
                                Toast.LENGTH_LONG
                            ).show()
                            updateUI(null)
                        }
                    }
            }
        }


        binding.textViewResetPassword.setOnClickListener {
            val email = binding.editTextLoginEmail.text.toString()
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Mail sent on Registered Email!", Toast.LENGTH_SHORT)
                            .show()
                    } else if (email.isEmpty()) {
                        Toast.makeText(this, "Please enter the email!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Please Try Again Later!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }
}