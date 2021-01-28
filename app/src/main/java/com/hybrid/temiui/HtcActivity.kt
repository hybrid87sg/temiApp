package com.hybrid.temiui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hybrid.temiui.databinding.ActivityHtcBinding

class HtcActivity : AppCompatActivity(R.layout.activity_htc) {

    private lateinit var binding: ActivityHtcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtcBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}