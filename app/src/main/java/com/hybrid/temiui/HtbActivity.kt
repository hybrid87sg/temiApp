package com.hybrid.temiui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.hybrid.temiui.databinding.ActivityHtbBinding
import com.hybrid.temiui.fragments.CustomDialogFragment

class HtbActivity : AppCompatActivity(R.layout.activity_htb) {
    
    private lateinit var binding: ActivityHtbBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val intentMap = Intent(this,MapActivity::class.java)

        val intent = Intent(this, MainActivity::class.java)

        val dialog = CustomDialogFragment()


        binding.btmNavBar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.homeBtmNav -> startActivity(intent)
                R.id.wifiBtmNav -> dialog.show(supportFragmentManager,"Custom")
                R.id.zoneBtmNav -> startActivity(intentMap)
            }
            true
        }

        binding.backTwo.setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc1)
            binding.control2.visibility = View.GONE
            binding.nextOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step1)
        }
        binding.nextOne. setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc2)
            binding.control2.visibility = View.VISIBLE
            binding.nextOne.visibility = View.GONE
            binding.tvHtc.text = getText(R.string.step2)
        }
        binding.backOne. setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc2)
            binding.backOne.visibility = View.GONE
            binding.control2.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step2)

        }
        binding.nextTwo . setOnClickListener {
            binding.ivHtb.setImageResource(R.drawable.temiux_htc3)
            binding.control2.visibility = View.GONE
            binding.backOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step3)
        }
    }
}