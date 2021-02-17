package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.*


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val intent = Intent(this, MainActivity::class.java)

        val dialog = CustomDialogFragment()

        val fragmentBrands = BrandsFragment()
        val fragmentUtils = UtilsFragment()

        val fragmentZone = ZoneFragment()
        val fragmentMap = MapFragment()
        setCurrentFragment(fragmentZone)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragmentMap)
            commit()

            //btmNavBarLayout
            binding.llHome.setOnClickListener {
                startActivity(intent)
            }
            binding.llZone.setOnClickListener {
                setCurrentFragment(fragmentZone)
            }
            binding.llMap.setOnClickListener {
                setCurrentFragment(fragmentMap)
            }
            binding.llWifi.setOnClickListener {
                dialog.show(supportFragmentManager, "Wifi")
            }


        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragment)
            commit()
        }

}

