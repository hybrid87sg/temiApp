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


        val view = View.inflate(this,R.layout.fragment_custom_dialog,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog = builder.create()

        val intent = Intent(this, MainActivity::class.java)

        val fragmentZone = ZoneFragment()
        val fragmentZone2 = Zone2Fragment()
        val fragmentMap = MapFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragmentMap)
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
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            }

        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragment)
            commit()
        }

}

