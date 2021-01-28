package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hybrid.temiui.databinding.ActivityHtcBinding

class HtcActivity : AppCompatActivity(R.layout.activity_htc) {

    private lateinit var binding: ActivityHtcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.htcNext.setOnClickListener {
            binding.lotFrame2.visibility = View.VISIBLE
            binding.lotFrame1.visibility = View.GONE
        }
        binding.htcNext2.setOnClickListener {
            binding.lotFrame3.visibility = View.VISIBLE
            binding.lotFrame2.visibility = View.GONE
        }
        binding.htcBack3.setOnClickListener {
            binding.lotFrame2.visibility = View.VISIBLE
            binding.lotFrame3.visibility = View.GONE
        }
        binding.htcBack2.setOnClickListener {
            binding.lotFrame1.visibility = View.VISIBLE
            binding.lotFrame2.visibility = View.GONE
        }

        binding.ibHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}