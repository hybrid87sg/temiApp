package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hybrid.temiui.databinding.ActivityZoneBinding

class ZoneActivity : AppCompatActivity(R.layout.activity_zone) {

    private lateinit var binding: ActivityZoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibHome.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}