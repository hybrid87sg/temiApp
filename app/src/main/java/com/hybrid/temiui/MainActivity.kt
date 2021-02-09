package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityMainBinding
import com.hybrid.temiui.fragments.CustomDialogFragment
import com.hybrid.temiui.fragments.HtbFragment
import com.hybrid.temiui.fragments.HtcFragment
import com.hybrid.temiui.fragments.ViewZoneFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val dialog = CustomDialogFragment()
        val dialogZone = ViewZoneFragment()

        val htcFragment = HtcFragment()
        val htbFragment = HtbFragment()

        val intentHtn = Intent(this,MapActivity::class.java)

        setCurrentFragment(htcFragment)

        binding.btnHtc.setOnClickListener {
            binding.mainFrome.visibility = View.VISIBLE
            setCurrentFragment(htcFragment)
        }

        binding.btnHtb.setOnClickListener {
            binding.mainFrome.visibility = View.VISIBLE
            setCurrentFragment(htbFragment)
        }

        binding.btnHtn.setOnClickListener {
            startActivity(intentHtn)
        }

        //btmNavBarLayout
        binding.llHome.setOnClickListener {
            binding.mainFrome.visibility = View.GONE
        }
        binding.llZone.setOnClickListener {
            dialogZone.show(supportFragmentManager, "Zone Views")
        }
        binding.llWifi.setOnClickListener {
            dialog.show(supportFragmentManager, "Wifi")
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrome,fragment)
                commit()
            }
    }
}