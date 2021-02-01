package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.hybrid.temiui.fragments.MapFragment
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.BrandsFragment
import com.hybrid.temiui.fragments.UtilsFragment
import com.hybrid.temiui.fragments.ZoneFragment


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        val zoneView = findViewById<Button>(R.id.zoneView)

        val fragmentZone = ZoneFragment()
        val fragmentBrands = BrandsFragment()
        val fragmentUtils = UtilsFragment()
        val fragmentMap = MapFragment()

        setCurrentFragment(fragmentZone)

        binding.menuView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.zones -> setCurrentFragment(fragmentZone)
                R.id.brands -> setCurrentFragment(fragmentBrands)
                R.id.utils -> setCurrentFragment(fragmentUtils)
            }
            true
        }


        binding.brandView.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentBrands)
                commit()
            }
        }

        binding.utilsView.setOnClickListener {
            zoneView.setBackgroundColor(getColor(R.color.white))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentUtils)
                commit()
            }
        }

        binding.zoneView.setOnClickListener {
            zoneView.isSelected = !zoneView.isSelected
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentZone)
                commit()
            }
        }

        binding.llHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.llMap.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flZone, fragmentMap)
                commit()
            }
        }


    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flZone,fragment)
            commit()
    }
}
