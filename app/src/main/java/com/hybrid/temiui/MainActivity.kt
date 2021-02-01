package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hybrid.temiui.databinding.ActivityMainBinding
import com.hybrid.temiui.fragments.CustomDialogFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val intentMap = Intent(this,MapActivity::class.java)

        val intent = Intent(this, MainActivity::class.java)

        val dialog = CustomDialogFragment()

        binding.btnHtc.setOnClickListener {
            val intent = Intent(this,HtcActivity::class.java)
            startActivity(intent)
        }
        binding.btnHtb.setOnClickListener {
            val intent = Intent(this,HtbActivity::class.java)
            startActivity(intent)
        }
        binding.btnHtn.setOnClickListener {
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }


        binding.btmNavBar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.homeBtmNav -> startActivity(intent)
                R.id.wifiBtmNav -> dialog.show(supportFragmentManager,"Custom")
                R.id.zoneBtmNav -> startActivity(intentMap)
            }
            true
        }


    }
}