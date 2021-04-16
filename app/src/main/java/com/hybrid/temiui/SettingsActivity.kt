package com.hybrid.temiui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        /*binding.apply.setOnClickListener {
            when {
                binding.high.isChecked -> {
                    Toast.makeText(this, "High Speed Mode", Toast.LENGTH_SHORT).show()
                    robot.tiltAngle(40)
                }
                binding.medium.isChecked ->
                    Toast.makeText(this,"Medium Speed Selected",Toast.LENGTH_SHORT).show()
                binding.slow.isChecked ->
                    Toast.makeText(this,"Slow Speed Selected",Toast.LENGTH_SHORT).show()
            }
        }*/
    }
}