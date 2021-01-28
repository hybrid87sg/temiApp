package com.hybrid.temiui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import coil.load
import com.hybrid.temiui.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private lateinit var binding: ActivitySecondBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()



        binding.btnMap.setOnClickListener {
            binding.frameMap.visibility = View.VISIBLE
            binding.frameZone.visibility = View.GONE

        }

        binding.btnZone.setOnClickListener {
            binding.frameZone.visibility = View.VISIBLE
            binding.frameMap.visibility = View.GONE
        }

        binding.ibHome.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}
