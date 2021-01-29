package com.hybrid.temiui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.Toast
import androidx.gridlayout.widget.GridLayout
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.ZoneFragment


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val fragmentZone = ZoneFragment()
        val gridZoneA = findViewById<GridLayout>(R.id.gridZoneA)
        val gridZoneB = findViewById<GridLayout>(R.id.gridZoneB)

        binding.btnMap.setOnClickListener {
            binding.frameMap.visibility = View.VISIBLE
            binding.frameZone.visibility = View.GONE
        }

        binding.btnZone.setOnClickListener {
            binding.frameZone.visibility = View.VISIBLE
            binding.frameMap.visibility = View.GONE
        }

        binding.ibHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.zoneA.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentZone)
                commit()
            }
        }

        binding.zoneB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentZone)
                commit()
            }
        }
    }
}
