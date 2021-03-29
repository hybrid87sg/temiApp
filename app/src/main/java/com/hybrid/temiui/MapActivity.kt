package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.*
import com.robotemi.sdk.Robot


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        val intent = Intent(this, MainActivity::class.java)

        val fragmentZone = ZoneFragment()
        val fragmentZone2 = Zone2Fragment()
        val fragmentMap = MapFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragmentZone2)
            commit()

            //btmNavBarLayout
            binding.llHome.setOnClickListener {
                startActivity(intent)
            }
            binding.llZone.setOnClickListener {
                setCurrentFragment(fragmentZone2)
            }
            binding.llMap.setOnClickListener {
                setCurrentFragment(fragmentMap)
            }
            binding.llWifi.setOnClickListener {
                val dialog = CustomDialogFragment()
                dialog.show(supportFragmentManager,"customdialog")
                dialog.isCancelable = false
            }

        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragment)
            commit()
        }

}

