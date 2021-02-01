package com.hybrid.temiui

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.hybrid.temiui.databinding.ActivityHtcBinding
import com.hybrid.temiui.fragments.CustomDialogFragment
import com.hybrid.temiui.fragments.MapFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class HtcActivity : AppCompatActivity(R.layout.activity_htc) {

    private lateinit var binding: ActivityHtcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHtcBinding.inflate(layoutInflater)
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
            binding.ivHtc.setImageResource(R.drawable.temiux_htc1)
            binding.control2.visibility = View.GONE
            binding.nextOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step1)
        }
        binding.nextOne. setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc2)
            binding.control2.visibility = View.VISIBLE
            binding.nextOne.visibility = View.GONE
            binding.tvHtc.text = getText(R.string.step2)
        }
        binding.backOne. setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc2)
            binding.backOne.visibility = View.GONE
            binding.control2.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step2)

        }
        binding.nextTwo . setOnClickListener {
            binding.ivHtc.setImageResource(R.drawable.temiux_htc3)
            binding.control2.visibility = View.GONE
            binding.backOne.visibility = View.VISIBLE
            binding.tvHtc.text = getText(R.string.step3)
        }

    }

}