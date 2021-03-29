package com.hybrid.temiui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import coil.load
import com.hybrid.temiui.databinding.ActivityMainBinding
import com.hybrid.temiui.fragments.*
import com.robotemi.sdk.Robot

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val htcFragment = HtcFragment()
        val htbFragment = HtbFragment()
        val faqFragment = FaqFragment()

        val robot = Robot.getInstance()

        binding.barHtc.setOnClickListener {
            setCurrentFragment(htcFragment)
            binding.mainFrome.visibility = View.VISIBLE
            binding.tvHome.text = getString(R.string.closeb)
            binding.ivIcon.setImageResource(R.drawable.ic_close)
        }

        binding.barHtb.setOnClickListener {
            setCurrentFragment(htbFragment)
            binding.mainFrome.visibility = View.VISIBLE
            binding.tvHome.text =  getString(R.string.closeb)
            binding.ivIcon.setImageResource(R.drawable.ic_close)
        }

        //btmNavBarLayout
        binding.llHome.setOnClickListener {
            binding.mainFrome.visibility = View.GONE
            binding.tvHome.text =  getString(R.string.home)
            binding.ivIcon.setImageResource(R.drawable.ic_home)
        }
        binding.llZone.setOnClickListener {
            val intent= Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        binding.llWifi.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager,"customdialog")
            dialog.isCancelable = false
        }

        binding.llFaq.setOnClickListener {
            setCurrentFragment(faqFragment)
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrome,fragment)
                commit()
            }
    }
}