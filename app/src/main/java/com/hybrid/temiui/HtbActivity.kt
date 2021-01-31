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

        binding.llHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.step1.setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc1)
        }
        binding.step2. setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc2)
        }
        binding.step3 . setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc3)
        }
    }
}