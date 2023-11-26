package com.rishav.smvduclubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rishav.smvduclubapp.adapters.RvAdapter
import com.rishav.smvduclubapp.databinding.ActivityClubDirectoryBinding

class ClubDirectoryActivity : AppCompatActivity() {

    private val binding: ActivityClubDirectoryBinding by lazy {
        ActivityClubDirectoryBinding.inflate(layoutInflater)
    }
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvAdapter = RvAdapter(ClubConstant.getData(),this)
        binding.rvClubs.layoutManager = LinearLayoutManager(this)
        binding.rvClubs.adapter = rvAdapter
    }
}