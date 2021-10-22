package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityMainBinding
import com.hybrid.temiui.fragments.*
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    val robot = Robot.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        robot.hideTopBar()
        robot.isReady

        val htcFragment = HtcFragment()
        val htbFragment = HtbFragment()
        val faqFragment = FaqFragment()


        binding.ivHomely.setOnClickListener {
            val dialog = LoginFragment()
            dialog.show(supportFragmentManager, "login")
        }

        binding.barHtc.setOnClickListener {
            setCurrentFragment(htcFragment)
            binding.mainFrome.visibility = View.VISIBLE
            binding.tvHome.text = getString(R.string.home)
            binding.llHome.visibility = View.VISIBLE
            binding.ivHomely.visibility = View.GONE
        }

        binding.barHtb.setOnClickListener {
            setCurrentFragment(htbFragment)
            binding.mainFrome.visibility = View.VISIBLE
            binding.tvHome.text = getString(R.string.home)
            binding.llHome.visibility = View.VISIBLE
            binding.ivHomely.visibility = View.GONE
        }

        //btmNavBarLayout
        binding.llHome.setOnClickListener {
            binding.mainFrome.visibility = View.GONE
            binding.tvHome.text = getString(R.string.home)
            binding.ivHomely.visibility = View.VISIBLE
        }
        binding.llZone.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        binding.llWifi.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "customdialog")
            dialog.isCancelable = false
        }

        binding.llFaq.setOnClickListener {
            setCurrentFragment(faqFragment)
            binding.tvHome.text = getString(R.string.home)
            binding.llHome.visibility = View.VISIBLE
        }

    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFrome, fragment)
            commit()
        }
    }


}