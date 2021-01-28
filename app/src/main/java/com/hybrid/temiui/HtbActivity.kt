package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hybrid.temiui.databinding.ActivityHtbBinding

class HtbActivity : AppCompatActivity(R.layout.activity_htb) {
    
    private lateinit var binding: ActivityHtbBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.htbNext.setOnClickListener {
            binding.lotFrame2.visibility = View.VISIBLE
            binding.lotFrame1.visibility = View.GONE
        }
        binding.htbNext2.setOnClickListener {
            binding.lotFrame3.visibility = View.VISIBLE
            binding.lotFrame2.visibility = View.GONE
        }
        binding.htbBack3.setOnClickListener {
            binding.lotFrame2.visibility = View.VISIBLE
            binding.lotFrame3.visibility = View.GONE
        }
        binding.htbBack2.setOnClickListener {
            binding.lotFrame1.visibility = View.VISIBLE
            binding.lotFrame2.visibility = View.GONE
        }

        binding.ibHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}