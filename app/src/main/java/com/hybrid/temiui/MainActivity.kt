package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.airbnb.lottie.LottieDrawable.INFINITE
import com.airbnb.lottie.LottieDrawable.RESTART
import com.hybrid.temiui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out)
        val fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in)

        binding.lotView1.setOnClickListener {
            binding.htcFrame.visibility = View.VISIBLE
            binding.htcFrame.startAnimation(fadeIn)
            binding.lvHtc.resumeAnimation()

        }

        binding.ibClose.setOnClickListener {
            binding.htcFrame.visibility = View.GONE
            binding.lvHtc.pauseAnimation()
        }

        binding.lotView3.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}