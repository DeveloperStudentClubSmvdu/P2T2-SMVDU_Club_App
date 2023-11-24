package com.rishav.smvduclubapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rishav.smvduclubapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        lateinit var auth: FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
//        val currentUser: FirebaseUser? = auth.currentUser

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //signOut button onclick
//        binding.signOut.setOnClickListner{
//            auth.signOut()
//            binding.userDetails.text =updateData()
//            startActivity(Intent(this,LoginActivity::class.java))
//
//        }

        binding.buttonLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()

//            addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Update UI with signed-out state
////                    binding.userDetails.text = ""
//                    Toast.makeText(this, "Logged Out Successfully!", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "Logout failed. Please try again.", Toast.LENGTH_SHORT).show()
//                }
            }
        }
    }


//    override fun onResume() {
//        super.onResume()
////        binding.userDetails.text =updateData()
//    }
//    private fun updateData():String{
//        return "Email: ${auth.currentUser?.email}"
//    }

//}