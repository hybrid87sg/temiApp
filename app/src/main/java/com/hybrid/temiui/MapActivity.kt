package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar.make
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.*
import com.hybrid.temiui.fragments.adapter.GridAdapter
import com.hybrid.temiui.fragments.model.GridItem
import com.robotemi.sdk.Robot


class MapActivity : AppCompatActivity(R.layout.activity_map) {

    private lateinit var binding: ActivityMapBinding
    val robot = Robot.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        robot.hideTopBar()


        val fragmentZone = ZoneFragment()
        val fragmentBrands = BrandsFragment()
        val fragmentUtils = UtilsFragment()
        val fragmentMap = MapFragment()

        val intent = Intent(this, MainActivity::class.java)

        val dialog = CustomDialogFragment()
        val dialogZone = ViewZoneFragment()

        setCurrentFragment(fragmentZone)


        binding.menuView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.zones -> setCurrentFragment(fragmentZone)
                R.id.brands -> setCurrentFragment(fragmentBrands)
                R.id.utils -> setCurrentFragment(fragmentUtils)
            }
            true
        }

        binding.btmNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeBtmNav -> startActivity(intent)
                R.id.wifiBtmNav -> dialog.show(supportFragmentManager, "Wifi")
                R.id.zoneBtmNav -> dialogZone.show(supportFragmentManager, "Zone Views")
            }
            true
        }

        //btmNavBarLayout
        binding.llHome.setOnClickListener {
            startActivity(intent)
        }
        binding.llZone.setOnClickListener {
            dialogZone.show(supportFragmentManager, "Zone Views")
        }
        binding.llWifi.setOnClickListener {
            dialog.show(supportFragmentManager, "Wifi")
        }


    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flZone, fragment)
            commit()
        }
}
