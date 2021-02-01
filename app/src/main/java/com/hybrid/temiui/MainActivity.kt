package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.hybrid.temiui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up)

        binding.btnHtc.setOnClickListener {
            val intent = Intent(this,HtcActivity::class.java)
            startActivity(intent)
        }
        binding.btnHtb.setOnClickListener {
            val intent = Intent(this,HtbActivity::class.java)
            startActivity(intent)
        }
        binding.btnHtn.setOnClickListener {
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }



    }
}