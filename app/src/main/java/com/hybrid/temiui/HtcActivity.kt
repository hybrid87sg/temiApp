package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hybrid.temiui.databinding.ActivityHtcBinding

class HtcActivity : AppCompatActivity(R.layout.activity_htc) {

    private lateinit var binding: ActivityHtcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.llHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.step1.setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc1)
        }
        binding.step2. setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc2)
        }
        binding.step3 . setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc3)
        }

    }
}