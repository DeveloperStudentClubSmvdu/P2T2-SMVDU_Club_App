package com.rishav.smvduclubapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rishav.smvduclubapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialize the firebase auth
        auth = FirebaseAuth.getInstance()

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.textViewLoginHere.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.buttonRegister.setOnClickListener {
            val name = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val repeatPassword = binding.editTextReenterPassword.text.toString()


            if (email.isNotEmpty() && name.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()){
                if (password != repeatPassword){
                    Toast.makeText(this, "Both passwords must be same!", Toast.LENGTH_SHORT).show()
                }
                else{
                    auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener{
                            if(it.isSuccessful){
                                Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this,LoginActivity::class.java))
                                finish()
                            }
                        }.addOnFailureListener {
                            Toast.makeText(this,"Failed : ${it.localizedMessage}",Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }
}