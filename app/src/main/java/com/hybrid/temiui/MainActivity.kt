package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import coil.load
import com.hybrid.temiui.databinding.ActivityMainBinding
import com.hybrid.temiui.fragments.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        val faqfragment = FaqFragment()
        val htcFragment = HtcFragment()
        val htbFragment = HtbFragment()
        val mainFragment = MainFragment()


        val intentHtn = Intent(this,MapActivity::class.java)

        binding.ivHomely.load("https://cdn.dynamicyield.com/api/8769097/images/3569b3b4c53f0__WFHEssentials_homepage_desktop.jpg")


        /*binding.optionsBtn.setOnClickListener {
            val popup = PopupMenu(this,binding.optionsBtn)
            popup.inflate(R.menu.drawer_menu)
            popup.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.qrMenu -> {
                        val view = View.inflate(this,R.layout.fragment_custom_dialog,null)
                        val builder = AlertDialog.Builder(this)
                        builder.setView(view)
                        val dialog = builder.create()

                        dialog.show()
                        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                    }
                    R.id.mapMenu -> startActivity(intentHtn)

                    R.id.faqMenu -> {
                        setCurrentFragment(faqfragment)
                    }
                }
                true
            }
            popup.show()
        }*/

        binding.htcBtn.setOnClickListener {
            setCurrentFragment(htcFragment)
            binding.mainFrome.visibility = View.VISIBLE
        }

        binding.htbBtn.setOnClickListener {
            setCurrentFragment(htbFragment)
            binding.mainFrome.visibility = View.VISIBLE
        }
        binding.logo.setOnClickListener {
            binding.mainFrome.visibility = View.GONE
        }

        //btmNavBarLayout
        binding.llHome.setOnClickListener {
            binding.mainFrome.visibility = View.GONE
        }
        binding.llZone.setOnClickListener {
            val intent= Intent(this,MapActivity::class.java)
            startActivity(intent)
        }
        binding.llWifi.setOnClickListener {
            val view = View.inflate(this,R.layout.fragment_custom_dialog,null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)
            val dialog = builder.create()

            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFrome,fragment)
                commit()
            }
    }
}