package com.rishav.smvduclubapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.rishav.smvduclubapp.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    private val binding:ActivityLauncherBinding by lazy {
        ActivityLauncherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)

    }
}