package com.hybrid.temiui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hybrid.temiui.databinding.ActivitySettingsBinding
import com.robotemi.sdk.Robot

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    val robot = Robot.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeIv.setOnClickListener {
            val intentHome = Intent(this,MainActivity::class.java)
            startActivity(intentHome)
        }

        binding.apply.setOnClickListener {
            binding.tvLocations.text = robot.locations.toList().toString()
        }
    }
}