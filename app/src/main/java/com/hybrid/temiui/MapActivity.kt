package com.hybrid.temiui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.BrandsFragment
import com.hybrid.temiui.fragments.MapFragment
import com.hybrid.temiui.fragments.UtilsFragment
import com.hybrid.temiui.fragments.ZoneFragment


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val fragmentZone = ZoneFragment()
        val fragmentBrands = BrandsFragment()
        val fragmentUtils = UtilsFragment()
        val fragmentMap = MapFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragmentZone)
            commit()
        }

        binding.brandView.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentBrands)
                commit()
            }
        }
        binding.utilsView.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentUtils)
                commit()
            }
        }

        binding.zoneView.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentZone)
                commit()
            }
        }

        binding.llHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.llMap.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentMap)
                commit()
            }
        }

    }
}
