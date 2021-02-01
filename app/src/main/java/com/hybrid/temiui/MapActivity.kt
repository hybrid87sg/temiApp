package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityMapBinding
import com.hybrid.temiui.fragments.*
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

        val intent = Intent(this, MainActivity::class.java)

        val dialog = CustomDialogFragment()


        setCurrentFragment(fragmentZone)

        binding.menuView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.zones -> setCurrentFragment(fragmentZone)
                R.id.brands -> setCurrentFragment(fragmentBrands)
                R.id.utils -> setCurrentFragment(fragmentUtils)
            }
            true
        }

        binding.btmNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeBtmNav -> startActivity(intent)
                R.id.wifiBtmNav -> dialog.show(supportFragmentManager,"Custom")
                R.id.zoneBtmNav -> setCurrentFragment(fragmentZone)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flZone,fragment)
            commit()
    }
}
